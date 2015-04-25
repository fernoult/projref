/* ihmref-RButton.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 24 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.panes.elements;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RButton extends JButton {

	

	/** RButton
	 * Constructeur
	 */
	public RButton(Action a_) {
		super(a_);
	}

	/** RButton
	 * Constructeur
	 */
	public RButton(Icon icon_) {
		super(icon_);
	}

	/** RButton
	 * Constructeur
	 */
	public RButton(String text_, Icon icon_) {
		super(text_, icon_);
	}

	/** RButton
	 * Constructeur
	 */
	public RButton(String text_) {
		super(text_);
	}
	
	
	
	
}
