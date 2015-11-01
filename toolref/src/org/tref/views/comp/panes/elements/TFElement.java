/* ihmref-TFElement.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 18 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.comp.panes.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.tref.views.comp.panes.parents.ComposantPane;
import org.tref.views.frames.AppFrame;

public class TFElement extends ComposantPane{

	private static final int TF_COL = 20;
	
	private String _tfValue;
	
	private JTextField _textField;
	
	private RButton _button;
	
	private String _zonetitle;
	
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
	public TFElement(String libelle_, RButton button_, AppFrame parent_, String zoneTitle_) {
		super(libelle_);
		setButton(button_);
		_parentFrame = parent_;
		_zonetitle = zoneTitle_;
		initPane();
	}
	
	
	@Override
	protected void initPane() {

		initComposants();
		
		super.initPane();
		
		// Label
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = _gbc.gridy = 0;									// Ligne 0, Colonne 0.
		gbc1.insets = new Insets(10, 5, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).	
		gbc1.anchor = GridBagConstraints.LINE_START;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules). 
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		add(_libelle, gbc1);											// Ajout du composant dans le GridBagLayout.
		
		// TextField
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 1;												// Colonne 1.
		gbc2.gridy = 0;												// Ligne 0.
		gbc2.gridwidth = GridBagConstraints.RELATIVE;				// Precise que le composant occupe toute la place depuis sa position jusqu'a l'avant derniere cellule.
		gbc2.weightx = 1;
		gbc2.insets = new Insets(10, 2, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc2.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		add(getTextField(), gbc2);											// Ajout du composant dans le GridBagLayout.
		
		// Bouton
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 2;												// Colonne 2.
		gbc3.gridy = 0;												// Ligne 0.
		gbc3.gridwidth = GridBagConstraints.REMAINDER;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc3.insets = new Insets(10, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc3.anchor = GridBagConstraints.LINE_END;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(getButton(), gbc3);											// Ajout du composant dans le GridBagLayout.
		
		Font font = new Font("Tahoma", Font.BOLD, 12);
		
		JLabel titl = new JLabel("Themes");
//		Border CLine = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#210B61"));
		Border CLine = BorderFactory.createEmptyBorder();
		TitledBorder title = BorderFactory.createTitledBorder(CLine, _zonetitle, TitledBorder.LEFT, TitledBorder.TOP, font, Color.decode("#210B61"));
		
		setBorder(title);
	}
	
	@Override
	protected void initComposants() {
		
		_textField = new JTextField(TF_COL);
//		_textField.setPreferredSize(new Dimension(_parentFrame.getSize().width - 200, _textField.getSize().height));
		_location = new Point();
		
		
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
//			putRButtonAction(_button);
		}else {
			_button = button_;			
//			putRButtonAction(_button);
		}
	}
	
	@Override
	public Point getLocation() {
		if (_location != null) {
			return _location;			
		}else {
			return this.getLocationOnScreen();
		}
	}
	
	@Override
	public void setLocation(Point location_) {
		
		if (location_ != null) {
			_location = location_;
		}else {
			_location = this.getLocationOnScreen();
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
//				_location = e.getLocationOnScreen();													// On recupere la position du curseur au moment du clic.
//				_parentFrame.get_frames().add(new LafFrame(_location, _textField));						// On instancie la fenetre des LAndFImpl en l'ajoutant a la liste des fenetres dependantes de PrefsFrame.
//				
			}
		});
	}
	
	/**
	 * <b>Methode:  org.tref.views.comp.panes.elements.get_zonetitle()</b><br/>
	 *
	 *<b>Description: </b><br/>
	 *<br/>
	 * @return String
	 */
	public String get_zonetitle() {
		return _zonetitle;
	}
	
	/**
	 * <b>Methode:  org.tref.views.comp.panes.elements.set_zonetitle()</b><br/>
	 *
	 *<b>Description: </b><br/>
	 *<br/>
	 * @param _zonetitle void
	 */
	public void set_zonetitle(String zonetitle_) {
		this._zonetitle = zonetitle_;
		this.repaint();
		this.revalidate();
	}
	
	
	
	
	
	

	
}
