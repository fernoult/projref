/* ihmref-Ressources.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.tref.common.resources.PEnumLogs;
import org.tref.common.resources.Ressources;
import org.tref.common.utils.InternalException;
import org.tref.install.Install;
import org.tref.views.frames.PFrame;
import org.tref.views.frames.erreurs.ErrorFrame;

public class ViewsRessources {

	private static ViewsRessources RES_INSTANCE;
	private static Ressources COMMON_RESOURCE = Ressources.getInstance();
	private String[] LAF_LIST; 
	private static String LAF_PATH = ViewsRessources.class.getPackage().getName() + ".Laf";
	private static String LIBELLES_PATH = ViewsRessources.class.getPackage().getName() + ".Libelles";
	private static String FRAMES_PROPS_PATH = PFrame.class.getPackage().getName() + ".PFrame";
	private ViewPrefs PREFS = ViewPrefs.getInstance();
	private String IMGS_RACINE = ViewsRessources.class.getPackage().getName().replace(".", Ressources.getInstance().getSepProj()) 
			+ Ressources.getInstance().getSepProj() + "images";
	private static String ERREUR_PATH = ErrorFrame.class.getPackage().getName() + ".ErrorFrame";
	
	
	private ViewsRessources(){
		
	}
	
	public static ViewsRessources getInstance(){
		
		// Le singleton qui va bien.
		if (RES_INSTANCE == null) {
			RES_INSTANCE = new ViewsRessources();
		}
		return RES_INSTANCE;
	}
	
	public String getLibelleValue(String key_){
		String chaine = null;
		try {
			chaine = ResourceBundle.getBundle(LIBELLES_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
			
		} catch (MissingResourceException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		return chaine;
	}
	
	public String getErrorValue(String key_){
		return ResourceBundle.getBundle(ERREUR_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
	}
	
	public String getLafValue(String key_){
		return ResourceBundle.getBundle(LAF_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
	}
	
	public String getPFrameLabel(String key_){
		String chaine = null;
		try {
			chaine = ResourceBundle.getBundle(FRAMES_PROPS_PATH).getString(key_);
			
		} catch (MissingResourceException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		return chaine;
	}
	
	public String[] getLibelleButtonValues(String key_){
		// TODO Ca plante ici, tu as un petit probl�me de Local  (en fait d'init de tes pr�f�rences)
		return ResourceBundle.getBundle(LIBELLES_PATH, ViewPrefs.getInstance().getLocale()).getString(key_).split("@");
	}
	
	public Dimension getSreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public String[] getLafAvaible(){
		
		LAF_LIST = getInstance().getLafValue("laf.dispo.list.values").split(" ");
		
		for (int i = 0; i < LAF_LIST.length; i++) {
			LAF_LIST[i] = LAF_LIST[i].trim();
		}
		return LAF_LIST;
	}
	
	public String getPrefixLaf(){
		return getInstance().getLafValue("laf.dispo.prefix.value");// 
	}
	
	public void updateLocale(Locale locale_){
		
		PREFS.updateLOC(locale_);
	}
	
	public void updateLookAndFeel(String laf_){
		
		PREFS.updateLAF(laf_);
	}
	
	public void setLocale(Locale locale_){
		
	}
	
	public void setLookAndFeel(String laf_){
		
	}
	
	public String getImgsPath(){
		return Ressources.getInstance().getSepProj() 
				+ IMGS_RACINE.replace(".", Ressources.getInstance().getSepProj());
	}

}
