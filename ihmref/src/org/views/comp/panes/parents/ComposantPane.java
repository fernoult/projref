/* ihmref-ComposantPane.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 25 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.panes.parents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

public class ComposantPane extends RPane{

	protected String _composantName;
	
	protected JLabel _libelle;
	
	protected int _libelleWidthMin;
	
	private static final int LIB_WIDTH = 200;
	
	protected GridBagConstraints _gbc;
	
	
	public ComposantPane(String libelle_){
		
		_libelle = new JLabel(libelle_);
		_libelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		_libelle.setSize(new Dimension(LIB_WIDTH, _libelle.getSize().height));
//		initPane();
	}
	
	@Override
	protected void initPane() {
		
		setLayout(new GridBagLayout());
		_gbc  = new GridBagConstraints();
	}
	
	
}
