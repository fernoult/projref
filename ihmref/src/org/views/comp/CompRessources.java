/* ihmref-CompRessources.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 24 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp;

public class CompRessources {

	private static CompRessources CR_INSTANCE;
	
	private CompRessources(){
		
	}
	
	public static CompRessources getInstance(){
		
		// Le singleton qui va bien.
		if (CR_INSTANCE == null) {
			CR_INSTANCE = new CompRessources();
		}
		return CR_INSTANCE;
	}
	
	
}
