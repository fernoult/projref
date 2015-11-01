/* ihmref-BTElement.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 26 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.comp.panes.elements;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import org.tref.views.comp.panes.parents.ComposantPane;

public class BTElement extends ComposantPane{

	private ArrayList<RButton> _buttonList;
	private JPanel _buttonPane;
	
	/** BTElement
	 * Constructeur
	 */
	public BTElement(String libelle_) {
		super(libelle_);
		initPane();
	}
	
	@Override
	protected void initPane() {

		initComposants();
		
		super.initPane();
		
		_buttonPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		if (_buttonList != null) {
			updateButtonPanel(_buttonList);
		}
		
		
	}
	
	@Override
	protected void initComposants() {
		
		_buttonList = new ArrayList<>();
		
	}
	
	public ArrayList<RButton> get_buttonList() {
		return _buttonList;
	}

	public void set_buttonList(ArrayList<RButton> _buttonList) {
		this._buttonList = _buttonList;
	}

	public JPanel get_buttonPane() {
		return _buttonPane;
	}

	public void set_buttonPane(JPanel _buttonPane) {
		this._buttonPane = _buttonPane;
	}

	public void addButton(RButton button_){
		
		get_buttonList().add(button_);
		updateButtonPanel(button_);
		
	}
	
	private void updateButtonPanel(ArrayList<RButton> buttonList_){
		
		for (Iterator<RButton> iterator = buttonList_.iterator(); iterator.hasNext();) {
			RButton button = iterator.next();
			_buttonPane.add(button);
		}
		
	}
	
	private void updateButtonPanel(RButton button_){
		_buttonPane.add(button_);
	}
	
	

	
}
