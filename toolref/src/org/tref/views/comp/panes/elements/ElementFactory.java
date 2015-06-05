/* ihmref-ElementFactory.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 18 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.comp.panes.elements;

import java.util.ResourceBundle;

import javax.swing.ImageIcon;

import org.tref.common.resources.Ressources;
import org.tref.views.ViewsRessources;
import org.tref.views.comp.ElementEnum;
import org.tref.views.comp.panes.parents.ComposantPane;
import org.tref.views.frames.AppFrame;

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
	
	public RButton getButton(ElementEnum type_, String[] values_){
		
		RButton button = new RButton();
		System.out.println(Ressources.getInstance().getSepProj() 
					+ ViewsRessources.getInstance().getImgsPath() + Ressources.getInstance().getSepProj() + values_[3]);
		try {
			ImageIcon icone = new ImageIcon(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
					+ Ressources.getInstance().getSepProj() + values_[3]));
			
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
			
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		
		return button;
	}
	
	public ComposantPane getElement(ElementEnum type_, String libelle_, RButton button_, AppFrame parent_){
		
		ComposantPane comp = null;
		
		if (type_.equals(ElementEnum.BT_ELEMENT)) {
			comp = new BTElement(libelle_);
			
		}else if (type_.equals(ElementEnum.CB_ELEMENT)) {
			comp = new CBElement(libelle_);
			
		}else if (type_.equals(ElementEnum.ChB_ELEMENT)) {
			comp = new ChBElement(libelle_);
			
		}else if (type_.equals(ElementEnum.RB_ELEMENT)) {
			comp = new RBElement(libelle_);
			
		}else if (type_.equals(ElementEnum.TF_ELEMENT)) {
			comp = new TFElement(libelle_, button_, parent_);
			
		}
		
		return comp;
		
	}
	
	
	
}
