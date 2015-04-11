/* ihmref-IHMAccess.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 7 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.views.frames.ExploraterFrame;
import org.views.frames.ObjFrame;

import com.jtattoo.plaf.About;
import com.jtattoo.plaf.JTattooUtilities;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

public class IHMAccess {

	public static void main(String[] args) {
		
		setDefaultLAF();
		new ExploraterFrame("EXPLO");
		System.out.println("JTattoo " + About.JTATTOO_VERSION);
//		displayAllLAF();
		
	}
	
	private static void setDefaultLAF(){
		
		try {
			
			// On positione le LAF par defaut.
			UIManager.setLookAndFeel(new FastLookAndFeel());
			System.out.println("LAF configure : " + FastLookAndFeel.class.getName());
			
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	public static void setLAF(String laf_){
		
		try {
			
			// On positione le LAF selectionne.
			UIManager.setLookAndFeel(laf_);
			System.out.println("LAF configure : " + FastLookAndFeel.class.getName());
			
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
	
	private static void displayAllLAF(){
		String[] lafs = Ressources.getInstance().getLafAvaible();
		String prefixe = Ressources.getInstance().getPrefixLaf();
		
		for (int i = 0; i < lafs.length; i++) {
			
			String laf = prefixe + lafs[i].trim();
			System.out.println(laf);
			try {
				
				// On positione le LAF selectionne.
				UIManager.setLookAndFeel(laf);
				
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			new ObjFrame("LAF : " + lafs[i]);
			
		}
	}
	
	

}
