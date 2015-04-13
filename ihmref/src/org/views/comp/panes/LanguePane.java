/* ihmref-LanguePane.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 12 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.views.frames.PrefsFrame;

public class LanguePane extends JPanel {

	/** Instance de la fenetre parente. */
	private PrefsFrame _parentFrame;
	
	/** Les boutons de choix des langues. */
	private JButton _fr;
	private JButton _en;
	private JButton _sp;
	private JButton _ge;
	
	/** Le label d'affichage de la langue choisie. */
	private String _prefixe = "Choix de la langue : ";
	private String _langue = "";
	private JLabel _choix;
	private String _locale = "";
	
	
	/** LanguePane
	 * Constructeur
	 */
	public LanguePane() {
		super();
		initPane("FR");
	}
	
	/**
	 * LanguePane
	 * Constructeur
	 */
	public LanguePane(PrefsFrame parentFrame_, String locale_){
		super();
		setParentFrame(parentFrame_);
		System.out.println("locale LangPane : " + locale_);
		initPane(locale_);
	}
	
	/**
	 * 
	 * initPane
	 * [DESCRIPTION]:
	 * Cette methode permet d'initialiser le panneau </br></br>
	 * [PARAMETRES]:
	 * void
	 */
	private void initPane(String locale_){
		
		
		initcomposants(locale_);											// Declenche l'init des composants du panneau.
		
		setLayout(new GridBagLayout());								// Positionne le GridBagLayout.
		GridBagConstraints gbc = new GridBagConstraints();			// Instancie un GridBagConstraints
		
		// Flag FR Button
		gbc.gridx = gbc.gridy = 0;									// Ligne 0, Colonne 0.
		gbc.insets = new Insets(5, 5, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules). 
		add(_fr, gbc);												// Ajout du composant dans le GridBagLayout.
		
		// Flag EN Button
		gbc.gridx = 1;												// Colonne 1.
		gbc.gridy = 0;												// Ligne 0.
		gbc.insets = new Insets(5, 2, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_en, gbc);												// Ajout du composant dans le GridBagLayout.
		
		// Flag SP Button
		gbc.gridx = 2;												// Colonne 2.
		gbc.gridy = 0;												// Ligne 0.
		gbc.gridwidth = GridBagConstraints.RELATIVE;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_sp, gbc);												// Ajout du composant dans le GridBagLayout.
		
		// Flag GE Button
		gbc.gridx = 3;												// Colonne 3.
		gbc.gridy = 0;												// Ligne 0.
		gbc.gridwidth = GridBagConstraints.REMAINDER;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_ge, gbc);												// Ajout du composant dans le GridBagLayout.
		
		// Label de confirmation
		gbc.gridx = 0;												// Colonne 0.
		gbc.gridy = 1;												// Ligne 1.
		gbc.gridwidth = GridBagConstraints.REMAINDER;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_choix, gbc);											// Ajout du composant dans le GridBagLayout.
		
		setBorder(BorderFactory.createTitledBorder(" Langues "));	// Positionne le cadre du panneau.
	}
	
	/**
	 * 
	 * initcomposants
	 * [DESCRIPTION]:
	 * Cette methode permet d'initialiser les composants du panneau </br></br>
	 * [PARAMETRES]:
	 * void
	 */
	private void initcomposants(String locale_){
		
		_choix = new JLabel(_prefixe + locale_);																		// Instancie le Label du choix de la langue.
		
		_fr = new JButton(new ImageIcon(getClass().getResource("/org/views/images/flags/France.png")));		// Instancie le bouton avec son icone.
		_fr.setName("FR");																				// On lui affecte un nom.
		_fr.setToolTipText("Francais");																		// On lui positionne un ToolTypeText.
		_fr.addActionListener(new ActionListener() {														// On positionne un ActionListner sur l'action du bouton
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				_langue = _fr.getToolTipText();																	// On recupere le nom du bouton
				_choix.setText(_prefixe + _langue);															// On affecte la nouvelle valeur au label.
				_locale = _fr.getName();																	// On positionne la locale.
				revalidate();																				// On rafraichit l'affichage du panneau.
			}
		});
		
		_en = new JButton(new ImageIcon(getClass().getResource("/org/views/images/flags/England.png")));	// Memes actions que le bouton _fr
		_en.setName("EN");
		_en.setToolTipText("Anglais");
		_en.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				_langue = _en.getToolTipText();
				_choix.setText(_prefixe + _langue);
				_locale = _en.getName();
				revalidate();
			}
		});
		
		_sp = new JButton(new ImageIcon(getClass().getResource("/org/views/images/flags/Spain.png")));		// Memes actions que le bouton _fr
		_sp.setName("SP");
		_sp.setToolTipText("Espagnol");
		_sp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				_langue = _sp.getToolTipText();
				_choix.setText(_prefixe + _langue);
				_locale = _sp.getName();
				revalidate();
			}
		});
		
		_ge = new JButton(new ImageIcon(getClass().getResource("/org/views/images/flags/Germany.png")));	// Memes actions que le bouton _fr
		_ge.setName("GE");
		_ge.setToolTipText("Allemand");
		_ge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				_langue = _ge.getToolTipText();
				_choix.setText(_prefixe + _langue);
				_locale = _ge.getName();
				revalidate();
			}
		});
		
		set_locale(locale_);
		
	}

	/** Methode getParentFrame();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the parentFrame
	 */
	public PrefsFrame getParentFrame() {
		return _parentFrame;
	}

	/** Methode setParentFrame();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * PrefsFrame LanguePane.java
	 * 
	 * @return the parentFrame
	 */
	public void setParentFrame(PrefsFrame parentFrame_) {
		_parentFrame = parentFrame_;
	}

	/** Methode getFr();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the fr
	 */
	public JButton getFr() {
		return _fr;
	}

	/** Methode setFr();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton LanguePane.java
	 * 
	 * @return the fr
	 */
	public void setFr(JButton fr_) {
		_fr = fr_;
	}

	/** Methode getEn();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the en
	 */
	public JButton getEn() {
		return _en;
	}

	/** Methode setEn();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton LanguePane.java
	 * 
	 * @return the en
	 */
	public void setEn(JButton en_) {
		_en = en_;
	}

	/** Methode getSp();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the sp
	 */
	public JButton getSp() {
		return _sp;
	}

	/** Methode setSp();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton LanguePane.java
	 * 
	 * @return the sp
	 */
	public void setSp(JButton sp_) {
		_sp = sp_;
	}

	/** Methode getGe();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the ge
	 */
	public JButton getGe() {
		return _ge;
	}

	/** Methode setGe();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton LanguePane.java
	 * 
	 * @return the ge
	 */
	public void setGe(JButton ge_) {
		_ge = ge_;
	}

	public String get_locale() {
		return _locale;
	}

	public void set_locale(String locale_) {
		this._locale = locale_;
		if (locale_.equals("FR")) {
			_langue = _fr.getToolTipText();
			_choix = new JLabel(_prefixe + _langue);
		}else if (locale_.equals("EN")) {
			_langue = _en.getToolTipText();
			_choix = new JLabel(_prefixe + _langue);
		}else if (locale_.equals("SP")) {
			_langue = _sp.getToolTipText();
			_choix = new JLabel(_prefixe + _langue);
		}else if (locale_.equals("GE")) {
			_langue = _ge.getToolTipText();
			_choix = new JLabel(_prefixe + _langue);
		}else if (locale_.equals("null")) {
			_langue = "FUCK";
			_choix = new JLabel(_prefixe + _langue);
		}
	}
	
	
	
	
}
