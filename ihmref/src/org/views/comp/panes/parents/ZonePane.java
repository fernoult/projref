/* ihmref-ZonePane.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 25 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.panes.parents;

import java.util.HashMap;

import javax.swing.BorderFactory;

import org.views.Ressources;

public class ZonePane extends RPane {

	protected String _zonetitle;
	
	protected HashMap<String, ComposantPane> _compList;
	
	public ZonePane(String title_) {
		
	}

	@Override
	protected void initPane() {
		
		super.initPane();
		setBorder(BorderFactory.createTitledBorder(_zonetitle));
	}
	
	@Override
	protected void initComposants() {
		
		super.initComposants();
	}
	
	/** Methode getZonetitle();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the zonetitle
	 */
	public String getZonetitle() {
		return _zonetitle;
	}

	/** Methode setZonetitle();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String ZonePane.java
	 * 
	 * @return the zonetitle
	 */
	public void setZonetitle(String zonetitle_) {
		_zonetitle = zonetitle_;
	}

	/** Methode getCompList();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the compList
	 */
	public HashMap<String, ComposantPane> getCompList() {
		return _compList;
	}

	/** Methode setCompList();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * HashMap<String,ComposantPane> ZonePane.java
	 * 
	 * @return the compList
	 */
	public void setCompList(HashMap<String, ComposantPane> compList_) {
		_compList = compList_;
	}
	
	
	
}
