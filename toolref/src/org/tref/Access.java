package org.tref;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.MessageFormat;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.tref.common.resources.PEnumLogs;
import org.tref.common.resources.Ressources;
import org.tref.common.utils.Config;
import org.tref.common.utils.ConfigUtils;
import org.tref.common.utils.FichierUtils;
import org.tref.install.Install;
import org.tref.views.ViewPrefs;
import org.tref.views.frames.ExploraterFrame;

public class Access {
	
	/** Objet de conf. */
	private static Config _confObj;
	
	/**  */
	private static String [] _defaultConfigValues = Ressources.getInstance().getCommonLabel("config.default.values").split(" ");
	
	/**  */
	private static Ressources _ressources = Ressources.getInstance();
	
	/**	<b>Methode: 	fre.gena.main()</b><br/>
	 * <b>Description: </b><br/>
	 *
	 * <br/><br/>
	 * @param args void
	 */
	public static void main(String[] args) {
	
		// Actions d'usage.
		
		ViewPrefs.getInstance().initPrefs();
		checkAlreadyRunning();			// On verifie si une instance de l'application n'est pas deja lancee.
		fixLookAndFeel();				// On positionne le LookAnd Feel de l'application.
		checkArguments(args);			// On verifie les arguments passe au lancement de l'application.
		checkAlreadyInstalled();		// On verifie si l'application a deja etee installee sur le poste.
		
		System.out.println("===================================================================================================");
		
		// On lance la fenetre de demarrage.
		new ExploraterFrame("EXPLO");
		
		
	}
	
	/**
	 * 	<b>Methode: 	fre.gena.checkAlreadyRunning()</b><br/>
	 * <b>Description: Verifie qu'une instance de l'appli n'est pas deja lancee.</b><br/>
	 *
	 * <br/><br/> void
	 */
	@SuppressWarnings({ "resource" })
	private static void checkAlreadyRunning(){
		
		try {
			
			// On instancie une ServerSocket dans la JVM sur un numero de port.
			// Si une deuxieme tentatice d'instanciation sur ce meme numero de port est faite, la JVM refusera et levera une erreur.
			ServerSocket servsock = new ServerSocket(Ressources.LAUNCH_PORT);
			
			// Affichage du log en console.
			System.out.println(PEnumLogs.INFO.getLogMessage(_ressources.getLogsLabel("logs.install.AlreadyRunning.text") + servsock.getLocalPort()));
			
		} catch (IOException e) {
			
			// Affichage du log en console.
			System.err.println(PEnumLogs.ERREUR.getLogMessage(Ressources.ALREADY_RUN_MESSAGE));
			
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
	 * <b>Methode:  org.se.checkAlreadyInstalled()</b><br/>
	 *
	 *<b>Description: </b> Verifie si l'application a deja ete installee.<br/>
	 *	Si oui, elle se lance, si non, elle s'installe.<br/>
	 *<br/> void
	 */
	private static void checkAlreadyInstalled() {
		
		Preferences prefs = Preferences.userNodeForPackage(Access.class);
		String flag = Ressources.ALREADY_INSTALLED;
		
		// Affichage du log en console.
		System.out.println(PEnumLogs.INFO.getLogMessage(_ressources.getLogsLabel("logs.install.AlreadyInstalled.text") + prefs.getBoolean(flag, true)));
		
			if (prefs.getBoolean(flag, true)) {
				prefs.putBoolean(flag, false);
				try {
					prefs.flush();
				} catch (BackingStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Install.getInstance().install();
			}

	}

	/**
	 * 	<b>Methode: 	fre.gena.checkArguments()</b><br/>
	 * <b>Description: Verifie les arguments passes en parametres.</b><br/>
	 *
	 * <br/><br/>
	 * @param args_ void
	 */
	private static void checkArguments(String[] args_){

		// Affichage du log en console.
		Object[] tab = {args_.length};
		System.out.println(PEnumLogs.INFO.getLogMessage(MessageFormat.format(_ressources.getLogsLabel("logs.install.CheckArguments.text"), tab)));
		
		// Si il y a u argument au lancement:
		if (args_ != null && args_.length > 0 && args_.length < 2) {
			switch (args_[0]) {
			case "dev":
				
				// Parametre dev indique que l'application est lancee en mode developpement et 
				// que le path du filechooser d'install est directement positionn� sur un repertoire de test.
				Install.getInstance().setFileChooserPath(_ressources.getCommonLabel("config.install.repDev.text"));
				break;
				
			case "remove":
				
				// Remove du parametre des preferences JVM.
				Install.getInstance().removePrefs();

				// Detruit l'arborescence deployee.
				Config conf = ConfigUtils.getInstance().getConfigObject();
				FichierUtils.getInstance().removeArbo(conf.get_appliRacine(), conf);
				
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
	 * 	<b>Methode: 	fre.gena.fixLookAndFeel()</b><br/>
	 * <b>Description: Positionne le LookAndFeel par defaut.</b><br/>
	 *
	 * <br/><br/> void
	 */
	private static void fixLookAndFeel(){
		
		// Affichage du log en console.
		System.out.println(PEnumLogs.INFO.getLogMessage(_ressources.getLogsLabel("logs.install.LookAndFeel.text")));
		
		try {
			
			// On positione le LAF par defaut.
			UIManager.setLookAndFeel(ViewPrefs.getInstance().getLAF());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
