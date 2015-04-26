/* ihmref-ThemesPane.java
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
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.views.Ressources;
import org.views.frames.LafFrame;
import org.views.frames.PFrame;
import org.views.frames.PrefsFrame;

public class ThemesPane extends JPanel {

	/** Instance de la fenetre parente. */
	private PFrame _parentFrame;
	
	/** Composants du panneau */
	private JLabel _themeLB;
	private JTextField _themeTF;
	private JButton _themeBT;
	private String _theme = "";
	
	/** Objet Point pour la position du curseur. */
	private Point _location;
	
	/** ThemesPane
	 * Constructeur
	 */
	public ThemesPane() {
		super();
		initPane();
	}
	
	/**
	 * ThemesPane
	 * Constructeur
	 */
	public ThemesPane(PFrame parentFrame_, String theme_){
		super();
		setParentFrame(parentFrame_);
		set_theme(theme_);
		initPane();
		
	}

	/**
	 * 
	 * initPane
	 * [DESCRIPTION]:
	 * Cette methode permet d'initialiser le panneau</br></br>
	 * [PARAMETRES]:
	 * void
	 */
	private void initPane(){
		
		initComposants();											// On declenche l'initialisation des composants du panneau.
		
		setLayout(new GridBagLayout());								// Positionne un GridBagLayout.
		GridBagConstraints gbc = new GridBagConstraints();			// Instancie le GridBagConstarints.
		
		// Label
		gbc.gridx = gbc.gridy = 0;									// Ligne 0, Colonne 0.
		gbc.insets = new Insets(5, 5, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules). 
		add(_themeLB, gbc);											// Ajout du composant dans le GridBagLayout.
		
		// TextField
		gbc.gridx = 1;												// Colonne 1.
		gbc.gridy = 0;												// Ligne 0.
		gbc.gridwidth = GridBagConstraints.RELATIVE;				// Precise que le composant occupe toute la place depuis sa position jusqu'a l'avant derniere cellule.
		gbc.insets = new Insets(5, 2, 5, 2);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_themeTF, gbc);											// Ajout du composant dans le GridBagLayout.
		
		// Bouton
		gbc.gridx = 2;												// Colonne 2.
		gbc.gridy = 0;												// Ligne 0.
		gbc.gridwidth = GridBagConstraints.REMAINDER;				// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);						// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;						// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		add(_themeBT, gbc);											// Ajout du composant dans le GridBagLayout.
		
		
		
	}
	
	/**
	 * 
	 * initComposants
	 * [DESCRIPTION]:
	 * Cette methode permet d'initialiser les composants du panneau.</br></br>
	 * [PARAMETRES]:
	 * void
	 */
	private void initComposants(){
		
		_themeLB = new JLabel("Look And Feel : ");														// On instancie le label
		_themeTF = new JTextField(20);																	// On instancie le TextField.
		_themeTF.setText(_theme);
		_themeBT = new JButton(new ImageIcon(getClass().getResource("/org/views/images/lnf.png")));		// On instancie le bouton avec son icone.
		_themeBT.addMouseListener(new MouseListener() {													// On positionne un ActionListner sur l'action du bouton.
			
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
				_parentFrame.get_frames().add(new LafFrame(_location, _themeTF));						// On instancie la fenetre des LAF en l'ajoutant a la liste des fenetres dependantes de PrefsFrame.
				
			}
		});
	}
	
	/**
	 * 
	 * getParentFrame
	 * [DESCRIPTION]:
	 * Cette methode permet de </br></br>
	 * [PARAMETRES]:
	 * PFrame
	 */
	public PFrame getParentFrame() {
		return _parentFrame;
	}
	
	/**
	 * 
	 * setParentFrame
	 * [DESCRIPTION]:
	 * Cette methode permet de </br></br>
	 * [PARAMETRES]:
	 * void
	 */
	public void setParentFrame(PFrame parentFrame_) {
		_parentFrame = parentFrame_;
	}

	/** Methode getThemeLB();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the themeLB
	 */
	public JLabel getThemeLB() {
		return _themeLB;
	}

	/** Methode setThemeLB();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JLabel ThemesPane.java
	 * 
	 * @return the themeLB
	 */
	public void setThemeLB(JLabel themeLB_) {
		_themeLB = themeLB_;
	}

	/** Methode getThemeTF();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the themeTF
	 */
	public JTextField getThemeTF() {
		return _themeTF;
	}

	/** Methode setThemeTF();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JTextField ThemesPane.java
	 * 
	 * @return the themeTF
	 */
	public void setThemeTF(JTextField themeTF_) {
		_themeTF = themeTF_;
	}

	/** Methode getThemeBT();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the themeBT
	 */
	public JButton getThemeBT() {
		return _themeBT;
	}

	/** Methode setThemeBT();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton ThemesPane.java
	 * 
	 * @return the themeBT
	 */
	public void setThemeBT(JButton themeBT_) {
		_themeBT = themeBT_;
	}

	/** Methode getLocation();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the location
	 */
	public Point getLocation() {
		return _location;
	}

	/** Methode setLocation();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * Point ThemesPane.java
	 * 
	 * @return the location
	 */
	public void setLocation(Point location_) {
		_location = location_;
	}

	public String get_theme() {
		return _theme;
	}

	public void set_theme(String theme_) {
		if (!theme_.equals("null")) {
			this._theme = theme_;
		}else {
			this._theme = "pas de themes prefere.";
		}
		
	}
	
	
	
}
