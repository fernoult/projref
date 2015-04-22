/* ihmref-CompEnum.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 18 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp;

public enum CompEnum {

	PN_PREFS ("");
	
	private String _key;
	
	private CompEnum(String key_) {
		setKey(key_);
	}

	/** Methode getKey();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the key
	 */
	public String getKey() {
		return _key;
	}

	/** Methode setKey();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String CompEnum.java
	 * 
	 * @return the key
	 */
	public void setKey(String key_) {
		_key = key_;
	}
	
	
}
