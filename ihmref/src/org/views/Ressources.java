/* ihmref-Ressources.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import org.IHMAccess;

public class Ressources {

	private static Ressources RES_INSTANCE;
	private String[] LAF_LIST; 
	private static String LAF_PATH = Ressources.class.getPackage().getName() + ".Laf";
	private static String LIBELLES_PATH = Ressources.class.getPackage().getName() + ".Libelles";
	private ViewPrefs PREFS = ViewPrefs.getInstance();
	
	
	private Ressources(){
		
	}
	
	public static Ressources getInstance(){
		
		// Le singleton qui va bien.
		if (RES_INSTANCE == null) {
			RES_INSTANCE = new Ressources();
		}
		return RES_INSTANCE;
	}
	
	public String getLibelleValue(String key_){
		
		return ResourceBundle.getBundle(LIBELLES_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
	}
	
	public String getLafValue(String key_){
		return ResourceBundle.getBundle(LAF_PATH, ViewPrefs.getInstance().getLocale()).getString(key_);
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
}
