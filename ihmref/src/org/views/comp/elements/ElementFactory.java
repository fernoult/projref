/* ihmref-ElementFactory.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 18 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.elements;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.views.Ressources;
import org.views.comp.ElementEnum;

public class ElementFactory {

	private static ElementFactory FACTORY_INSTANCE;
	
	private ElementFactory(){
		
	}
	
	public static ElementFactory getInstance(){
		
		// Le singleton qui va bien.
		if (FACTORY_INSTANCE == null) {
			FACTORY_INSTANCE = new ElementFactory();
		}
		
		return FACTORY_INSTANCE;
	}
	
	public JButton getButton(ElementEnum type_, String[] values_){
		
		ImageIcon icone = new ImageIcon(getClass().getResource("/org/views/images/flags/" + values_[3]));
		
		JButton button = new JButton();
		button.setName(values_[0]);
		button.setToolTipText(values_[2]);
		
		if (type_.equals(ElementEnum.ICON_BUTTON)) {
			button.setIcon(icone);
		}else if (type_.equals(ElementEnum.TEXT_BUTTON)) {
			button.setText(values_[1]);
		}else if (type_.equals(ElementEnum.MIXTE_BUTTON)) {
			button.setText(values_[1]);
			button.setIcon(icone);
		}
		return new JButton();
	}
	
	
	
}
