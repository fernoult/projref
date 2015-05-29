/* ihmref-LanguePane.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 12 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.comp.panes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.tref.views.ViewsRessources;
import org.tref.views.ViewPrefs;
import org.tref.views.comp.ElementEnum;
import org.tref.views.comp.panes.elements.BTElement;
import org.tref.views.comp.panes.elements.ElementFactory;
import org.tref.views.comp.panes.elements.RButton;
import org.tref.views.frames.PrefsFrame;

public class LanguePane extends JPanel {

	/** Instance de la fenetre parente. */
	private PrefsFrame _parentFrame;
	

	
	/** Le label d'affichage de la langue choisie. */
	private String _prefixe = ViewsRessources.getInstance().getLibelleValue("prefs.choix.text");
	private String _langue = "";
	private JLabel _choix;
	private String _locale = "";
	private BTElement _btElement;
	
	
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
		_btElement = (BTElement) ElementFactory.getInstance().getElement(ElementEnum.BT_ELEMENT, "Langues", null, getParentFrame());
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
		gbc.anchor = GridBagConstraints.LINE_START;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules). 
		add(_btElement.get_buttonPane(), gbc);												// Ajout du composant dans le GridBagLayout.
											
		
		// Label de confirmation
		gbc.gridx = 0;												// Colonne 0.
		gbc.gridy = 1;												// Ligne 1.
		gbc.gridwidth = GridBagConstraints.REMAINDER;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.LINE_START;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_choix, gbc);											// Ajout du composant dans le GridBagLayout.
		
//		setBorder(BorderFactory.createTitledBorder(
//				Ressources.getInstance().getLibelleValue("prefs.pane.lang.cadre.value")));		// Positionne le cadre du panneau.
	
		Font font = new Font("Tahoma", Font.BOLD, 12);
//		Border CLine = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#210B61"));
		Border CLine = BorderFactory.createEmptyBorder();
		
		TitledBorder title = BorderFactory.createTitledBorder(CLine, ViewsRessources.getInstance().getLibelleValue("prefs.pane.lang.cadre.value"), 
				TitledBorder.LEFT, TitledBorder.TOP, font, Color.decode("#210B61"));
		
		setBorder(title);
	
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
		
		_choix = new JLabel();																		// Instancie le Label du choix de la langue.
		_choix.setFont(new Font("Tahoma", Font.BOLD, 12));
		String prefix = "/org/views/images/flags/";
		String lang = null;
		String[] btTab = ViewsRessources.getInstance().getLibelleValue("panes.prefs.lang.zone.buttons.values").split("#");
		
		for (int i = 0; i < btTab.length; i++) {
			
			String s = btTab[i].trim();
			String[] tab = s.split("@");
			
			final RButton btn = new RButton(new ImageIcon(getClass().getResource(prefix + tab[3])));
			btn.setName(tab[0]);																				// On lui affecte un nom.
			btn.setToolTipText(tab[1]);																		// On lui positionne un ToolTypeText.
			btn.addActionListener(new ActionListener() {														// On positionne un ActionListner sur l'action du bouton
				
				@Override
				public void actionPerformed(ActionEvent e_) {
					_langue = btn.getToolTipText();																	// On recupere le nom du bouton
					_choix.setText(_prefixe + _langue);															// On affecte la nouvelle valeur au label.
					_locale = btn.getName().toLowerCase();																	// On positionne la locale.
					revalidate();																				// On rafraichit l'affichage du panneau.
				}
			});
			String btnn = btn.getName();
			String btnttt = btn.getToolTipText();
			if (btn.getName().equals(ViewPrefs.getInstance().getLocale().getCountry())) {
				_choix.setText(_prefixe + btn.getToolTipText());
			}
			_btElement.addButton(btn);
		}
		
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

	public String get_locale() {
		return _locale;
	}

	public void set_locale(String locale_) {
		
		this._locale = locale_;
		
//		if (locale_.equals("fr")) {
//			_langue = _fr.getToolTipText();
//			_choix = new JLabel(_prefixe + _langue);
//		}else if (locale_.equals("en")) {
//			_langue = _en.getToolTipText();
//			_choix = new JLabel(_prefixe + _langue);
//		}else if (locale_.equals("es")) {
//			_langue = _es.getToolTipText();
//			_choix = new JLabel(_prefixe + _langue);
//		}else if (locale_.equals("de")) {
//			_langue = _de.getToolTipText();
//			_choix = new JLabel(_prefixe + _langue);
//		}else if (locale_.equals("null")) {
//			_langue = "FUCK";
//			_choix = new JLabel(_prefixe + _langue);
//		}
	}
	
	
	
	
}
