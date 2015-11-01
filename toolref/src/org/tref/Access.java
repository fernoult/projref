package org.tref;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.MessageFormat;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.tref.application.InstallManager;
import org.tref.common.preferences.PrefsGUI;
import org.tref.common.resources.Ressources;
import org.tref.common.resources.enums.EnumLogs;
import org.tref.common.tools.ConfigTool;
import org.tref.common.tools.FileTool;
import org.tref.model.IConfig;
import org.tref.views.frames.ExploraterFrame;
import org.tref.views.frames.erreurs.ErrorFrame;
import org.tref.views.frames.splash.RunSplashScreen;


public class Access {
	
	/** Les ressources. */
	private static Ressources _ressources = Ressources.getInstance();
	
	/**
	 * 
	 * <b>Methode: org.tref.main()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Le main de l'application.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 * @param args
	 */
	public static void main(String[] args) {
	
		// On initialise les Préférences.
		PrefsGUI.getInstance().initPrefs();
		
		// On initialise les attributs de ressources.
		initResourcesAttributes();
		
		// On verifie qu'une autre instance de l'appli ne tourne pas deja,
		// on positionne le LookAndFeel, check les arguments et check si l'application
		// n'est pas deja installee sur le poste.
		checkAlreadyRunning();			
		fixLookAndFeel();				
		checkArguments(args);			
		checkAlreadyInstalled();		
		
		System.out.println("===================================================================================================");
		
		// On lance la fenetre de demarrage.
	    RunSplashScreen splash = new RunSplashScreen(4000);
	    splash.showSplashAndExit();	
		new ExploraterFrame("EXPLO");
		
	}
	
	/**
	 * 
	 * <b>Methode: org.tref.checkAlreadyRunning()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Verifie qu'une instance de l'appli n'est pas deja lancee.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 */
	@SuppressWarnings({ "resource" })
	private static void checkAlreadyRunning(){
		
		try {
			
			// On instancie une ServerSocket dans la JVM sur un numero de port.
			// Si une deuxieme tentatice d'instanciation sur ce meme numero de port est faite, la JVM refusera et levera une erreur.
			ServerSocket servsock = new ServerSocket(Ressources.LAUNCH_PORT);
			
			// Affichage du log en console.
			System.out.println(EnumLogs.INFO.getLogMessage(_ressources.getLogsLabel("logs.install.AlreadyRunning.text") + servsock.getLocalPort()));
			
		} catch (IOException e) {
			
			// Affichage du log en console.
			System.err.println(EnumLogs.ERREUR.getLogMessage(Ressources.ALREADY_RUN_MESSAGE));
			
			// Positionne le LookAndFeel.
			fixLookAndFeel();
			
			// PopUp d'erreur affichee a l'ecran.
			JOptionPane.showMessageDialog(null, Ressources.ALREADY_RUN_MESSAGE, 
					Ressources.ALREADY_RUN_TITLE, JOptionPane.ERROR_MESSAGE);
			
			// Sortie forcee du processus.
			System.exit(0);
		}
		
	}
	
	/**
	 * 
	 * <b>Methode: org.tref.checkAlreadyInstalled()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Verifie si l'application a deja ete installee.<br/>
	 *		Si oui, elle se lance, si non, elle s'installe.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 */
	private static void checkAlreadyInstalled() {
		
		Preferences prefs = Preferences.userNodeForPackage(Access.class);
		String flag = Ressources.ALREADY_INSTALLED;
		
		// Affichage du log en console.
		System.out.println(EnumLogs.INFO.getLogMessage(_ressources.getLogsLabel("logs.install.AlreadyInstalled.text") + prefs.getBoolean(flag, true)));
		
			if (prefs.getBoolean(flag, true)) {
				prefs.putBoolean(flag, false);
				try {
					prefs.flush();
				} catch (BackingStoreException bse) {
					System.err.println(EnumLogs.ERREUR.getLogMessage(bse.getClass().getName() + " - " + bse.getMessage()));
					new ErrorFrame(bse.getClass().toString(), bse.getStackTrace());
				}
				InstallManager.getInstance().install();
			}

	}

	/**
	 * 
	 * <b>Methode: org.tref.checkArguments()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Verifie les arguments passes en parametres.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 * @param args_
	 */
	private static void checkArguments(String[] args_){

		// Affichage du log en console.
		Object[] tab = {args_.length};
		System.out.println(EnumLogs.INFO.getLogMessage(MessageFormat.format(_ressources.getLogsLabel("logs.install.CheckArguments.text"), tab)));
		
		// Si il y a u argument au lancement:
		if (args_ != null && args_.length > 0 && args_.length < 2) {
			switch (args_[0]) {
			case "dev":
				
				// Parametre dev indique que l'application est lancee en mode developpement et 
				// que le path du filechooser d'install est directement positionn� sur un repertoire de test.
				File file = new File(System.getProperty("user.home") + Ressources.getInstance().getSepProj() + "DEPLOIE_TEST");
				
				if (file.exists()) {
					InstallManager.getInstance().setFileChooserPath(file.getAbsolutePath());	
				}else {
					try {
						file.createNewFile();
						InstallManager.getInstance().setFileChooserPath(file.getAbsolutePath());
					} catch (IOException e) {
						System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
						new ErrorFrame(e.getClass().toString(), e.getStackTrace());
					}
				}
				break;
				
			case "remove":
				
				// Remove du parametre des preferences JVM.
				InstallManager.getInstance().removePrefs();

				// Detruit l'arborescence deployee.
				IConfig conf = ConfigTool.getInstance().getConfigObject();
				FileTool.getInstance().removeArbo(conf.get_appliRacine(), conf);
				
				JOptionPane.showMessageDialog(null, _ressources.getCommonLabel("popup.desinstallation.message.text"), 
						_ressources.getCommonLabel("popup.desinstallation.titre.text"), JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				break;
				
			default:
				break;
			}
		}	// Sinon, on ne fait rien et il y a un lancement normal.
	}
	
	/**
	 * 
	 * <b>Methode: org.tref.fixLookAndFeel()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Positionne le LookAndFeel par defaut.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 */
	private static void fixLookAndFeel(){
		
		// Affichage du log en console.
		System.out.println(EnumLogs.INFO.getLogMessage(_ressources.getLogsLabel("logs.install.LookAndFeel.text")));
		
		try {
			
			// On positione le LAndFImpl par defaut.
			UIManager.setLookAndFeel(PrefsGUI.getInstance().getLAF());
			
			UIManager.put("ProgressBar.background", Color.WHITE);
			UIManager.put("ProgressBar.foreground", Color.decode("#0B3861"));
			UIManager.put("ProgressBar.selectionBackground", Color.BLACK);  
			UIManager.put("ProgressBar.selectionForeground",Color.decode("#CEE3F6"));
			
		} catch (ClassNotFoundException e) {
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		} catch (InstantiationException e) {
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		} catch (IllegalAccessException e) {
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		} catch (UnsupportedLookAndFeelException e) {
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
	}
	
	/**
	 * 
	 * <b>Methode: org.tref.initResourcesAttributes()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialise les attributs de ressources.<br/>
	 * <b>Tags: </b> <br/>
	 * <br/>
	 */
	private static void initResourcesAttributes(){
		
		// Init des ressources.
		_ressources = Ressources.getInstance();
	}

}
