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
import java.util.ResourceBundle;

import org.tref.common.resources.Ressources;
import org.tref.views.frames.PFrame;

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
		System.out.println(ViewPrefs.getInstance().getLocale());
		return ResourceBundle.getBundle(LIBELLES_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
	}
	
	public String getLafValue(String key_){
		return ResourceBundle.getBundle(LAF_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
	}
	
	public String getPFrameLabel(String key_){
		return ResourceBundle.getBundle(FRAMES_PROPS_PATH).getString(key_);
	}
	
	public String[] getLibelleButtonValues(String key_){
		// TODO Ca plante ici, tu as un petit problème de Local  (en fait d'init de tes préférences)
		return ResourceBundle.getBundle(LIBELLES_PATH, ViewPrefs.getInstance().getLocale()).getString(key_).split("@");
	}
	
	public Dimension getSreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public String[] getLafAvaible(){
		
		LAF_LIST = getInstance().getLafValue("laf.dispo.list.values").split(" ");
		
		for (int i = 0; i < LAF_LIST.length; i++) {
			LAF_LIST[i] = LAF_LIST[i].trim();
			System.out.println(LAF_LIST[i]);
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
		return IMGS_RACINE.replace(".", Ressources.getInstance().getSepProj());
	}
	
	public String getImgsFlagsPath(){
		return getImgsPath() + COMMON_RESOURCE.getSepProj() + "flags";
	}
	
	public String getImgsLafsPath(){
		return getImgsPath() + COMMON_RESOURCE.getSepProj() + "lafs";
	}
}
