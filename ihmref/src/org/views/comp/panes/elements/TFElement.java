/* ihmref-TFElement.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 18 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.panes.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import org.views.comp.ElementEnum;
import org.views.comp.panes.parents.ComposantPane;
import org.views.frames.LafFrame;

public class TFElement extends ComposantPane{

	private static final int TF_COL = 25;
	
	private String _tfValue;
	
	private JTextField _textField;
	
	private RButton _button;
	
	/** TFElement
	 * Constructeur
	 */
	public TFElement(String libelle_) {
		super(libelle_);
		initPane();
	}
	
	/** TFElement
	 * Constructeur
	 */
	public TFElement(String libelle_, RButton button_) {
		super(libelle_);
		setButton(button_);
		initPane();
	}
	
	
	@Override
	protected void initPane() {

		initComposants();
		
		super.initPane();
		
		// Label
		_gbc.gridx = _gbc.gridy = 0;									// Ligne 0, Colonne 0.
		_gbc.insets = new Insets(5, 5, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		_gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules). 
		add(_libelle, _gbc);											// Ajout du composant dans le GridBagLayout.
		
		// TextField
		_gbc.gridx = 1;												// Colonne 1.
		_gbc.gridy = 0;												// Ligne 0.
		_gbc.gridwidth = GridBagConstraints.RELATIVE;				// Precise que le composant occupe toute la place depuis sa position jusqu'a l'avant derniere cellule.
		_gbc.insets = new Insets(5, 2, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		_gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(getTextField(), _gbc);											// Ajout du composant dans le GridBagLayout.
		
		// Bouton
		_gbc.gridx = 2;												// Colonne 2.
		_gbc.gridy = 0;												// Ligne 0.
		_gbc.gridwidth = GridBagConstraints.REMAINDER;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		_gbc.insets = new Insets(5, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		_gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_button, _gbc);											// Ajout du composant dans le GridBagLayout.
		
	}
	
	@Override
	protected void initComposants() {
		
		_textField = new JTextField(TF_COL);
		
		
	}

	/** Methode getTfValue();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the tfValue
	 */
	public String getTfValue() {
		return _tfValue;
	}

	/** Methode setTfValue();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String TFElement.java
	 * 
	 * @return the tfValue
	 */
	public void setTfValue(String tfValue_) {
		_tfValue = tfValue_;
	}

	/** Methode getTextField();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the textField
	 */
	public JTextField getTextField() {
		return _textField;
	}

	/** Methode setTextField();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JTextField TFElement.java
	 * 
	 * @return the textField
	 */
	public void setTextField(JTextField textField_) {
		_textField = textField_;
	}

	/** Methode getButton();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the button
	 */
	public RButton getButton() {
		return _button;
	}

	/** Methode setButton();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * RButton TFElement.java
	 * 
	 * @return the button
	 */
	public void setButton(RButton button_) {
		
		if (button_ == null) {					// Si le RButton est null, alors on en instancie un autre et on mentionne qu'il est par defaut
			_button = new RButton("A_DEF");
			putRButtonAction(_button);
		}else {
			_button = button_;			
			putRButtonAction(_button);
		}
	}
	
	/**
	 * 
	 * putRButtonAction
	 * [DESCRIPTION]:
	 * Cette methode positionne l'ActionListner sur le bouton.</br></br>
	 * [PARAMETRES]:
	 * void
	 */
	private void putRButtonAction(RButton but_){
		
		but_.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				
			}
		});
		
		but_.addMouseListener(new MouseListener() {													// On positionne un ActionListner sur l'action du bouton.
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				_location = e.getLocationOnScreen();													// On recupere la position du curseur au moment du clic.
				_parentFrame.get_frames().add(new LafFrame(_location, _textField));						// On instancie la fenetre des LAF en l'ajoutant a la liste des fenetres dependantes de PrefsFrame.
				
			}
		});
	}
	
	
	
	
	
	

	
}
