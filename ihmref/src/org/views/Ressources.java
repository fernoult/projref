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
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import org.IHMAccess;

public class Ressources {

	private static Ressources RES_INSTANCE;
	private String[] LAF_LIST; 
	private static String LAF_PATH = Ressources.class.getPackage().getName() + ".Libelles";
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle(LAF_PATH);
	private Preferences PREFS = Preferences.userNodeForPackage(IHMAccess.class);
	
	private Ressources(){
		
	}
	
	public static Ressources getInstance(){
		
		// Le singleton qui va bien.
		if (RES_INSTANCE == null) {
			RES_INSTANCE = new Ressources();
		}
		return RES_INSTANCE;
	}
	
	public Dimension getSreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public String[] getLafAvaible(){
		LAF_LIST = BUNDLE.getString("laf.dispo.list.values").split(" ");
		for (int i = 0; i < LAF_LIST.length; i++) {
			LAF_LIST[i] = LAF_LIST[i].trim();
			System.out.println(LAF_LIST[i]);
		}
		return LAF_LIST;
	}
	
	public String getPrefixLaf(){
		return BUNDLE.getString("laf.dispo.prefix.value");
	}
	
	public Preferences getPrefs(){
		return PREFS;
	}
}
