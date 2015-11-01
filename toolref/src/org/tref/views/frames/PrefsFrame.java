package org.tref.views.frames;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.tref.common.preferences.PrefsGUI;
import org.tref.views.ViewsRessources;
import org.tref.views.comp.ElementEnum;
import org.tref.views.comp.panes.LanguePane;
import org.tref.views.comp.panes.elements.ElementFactory;
import org.tref.views.comp.panes.elements.RButton;
import org.tref.views.comp.panes.elements.TFElement;

public class PrefsFrame extends AppFrame {

	/** Le TextField des LAF */
	private JTextField _lafTF;
	
	/** Le Label des LAF */
	private JLabel _lafLB;
	
	/** Le bouton des LAF */
	private JButton _lafBT;
	
	/** Le bouton de j'sais plus quoi. */
	private JButton _applyBT;
	
	/** Le panneau des themes (skins) */
	private JPanel _themesPane;
	
	/** Le panneau des langues. */
	private JPanel _languesPane;
	
	/** Le panneau de l'email. */
	private TFElement _emailPane;
	
	/** Attribut d'une instance de l'explorateur. */
	private ExploraterFrame _explorater;
	
	/**
	 * 
	 * Constructeur de la classe PrefsFrame.java
	 */
	public PrefsFrame() {
		// Appel du constructeur parent.
		super();
	}
	
	/**
	 * 
	 * Constructeur de la classe PrefsFrame.java
	 * @param title_
	 */
	public PrefsFrame(String title_){
		// Appel du constructeur parent.
		super();
		
		// Poisitionne le titre de la fenetre
		// et init de la fenetre.
		setTitle(title_);
		initPFrame();
		
	}

	/**
	 * 
	 * Constructeur de la classe PrefsFrame.java
	 * @param title_
	 * @param explorater_
	 */
	public PrefsFrame(String title_, ExploraterFrame explorater_){
		// Appel du constructeur parent.
		super();
		
		// Positionne le titre de la fenetre,
		// l'instance de l'explorateur,
		// et init de la fenetre.
		setTitle(title_);
		set_explorater(explorater_);
		initPFrame();
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initPFrame()
	 */
	@Override
	protected void initPFrame() {
		
		// Appel de l'init du parent.
		super.initPFrame();
		
		// Init des composants et 
		// des panneaux.
		initComposants();
		initPanels();
		
		// On ajoute le panneau central.
		add(_centerPane);
		
		// On positionne la taille et l'emplacement sur l'ecran.
		setSize(550, 300);
		setLocationRelativeTo(null);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initComposants()
	 */
	@Override
	protected void initComposants() {
		
		// Init du bouton Apply
		_applyBT = new RButton(ViewsRessources.getInstance().getLibelleValue("prefs.submit.button.text"));
		_applyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// On diffuse le changement des prefs 
				// aux composats concernes, et on ferme la fenetre des prefs.
				updatePrefs();
				dispose();
			}
		});
		
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initPanels()
	 */
	@Override
	protected void initPanels() {
		
		// zone Skin
		_themesPane = ElementFactory.getInstance().getElement(ElementEnum.TF_ELEMENT, "Look & Feel", 
				ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
						ViewsRessources.getInstance().getLibelleValue("panes.prefs.themes.button.value").split("@")), this, _ressources.getLibelleValue("prefs.pane.theme.cadre.value"));
		((TFElement) _themesPane).getButton().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				((TFElement) _themesPane).setLocation(arg0.getLocationOnScreen());													// On recupere la position du curseur au moment du clic.
				_explorater.get_frames().add(new LafFrame(((TFElement) _themesPane).getLocation(), ((TFElement) _themesPane).getTextField(), "LAndFImpl"));
			}
		});
		
		((TFElement) _themesPane).getTextField().setText(PrefsGUI.getInstance().getLAF());
		((TFElement) _themesPane).set_zonetitle("Themes");
		
		
		// Zone Langues
		_languesPane = new LanguePane(this, PrefsGUI.getInstance().getLocale().getLanguage());
		
		// Zone e-mail admin
		_emailPane = (TFElement) ElementFactory.getInstance().getElement(ElementEnum.TF_ELEMENT, "email admin", null, this, "Email");
		_emailPane.getTextField().setText(ViewsRessources.getInstance().getErrorValue("ErreurLabel.RapportErreur.TO.Text.Value"));
		_emailPane.getTextField().setEnabled(false);
		
		_centerPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// ThemePanel
		gbc.gridx = gbc.gridy = 0;										// Ligne 0, Colonne 0.
		gbc.insets = new Insets(5, 5, 5, 2);							// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;							// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules). 
		gbc.gridwidth = GridBagConstraints.REMAINDER;					// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		_centerPane.add(_themesPane, gbc);											// Ajout du composant dans le GridBagLayout.
		
		// LanguePanel
		gbc.gridx = 0;													// Colonne 0.
		gbc.gridy = 1;													// Ligne 1.
		gbc.gridwidth = GridBagConstraints.REMAINDER;					// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);							// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;							// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		_centerPane.add(_languesPane, gbc);								// Ajout du composant dans le GridBagLayout.
		
		// EmailPanel
		gbc.gridx = 0;													// Colonne 0.
		gbc.gridy = 2;													// Ligne 1.
		gbc.gridwidth = GridBagConstraints.REMAINDER;					// Precise que le composant occupe toute la place en derniere position de la ligne.
		gbc.insets = new Insets(5, 2, 5, 5);							// Inset permet de preciser une marge autour du composant dans sa cellule. (Insets(int TOP, int LEFT, int BOTTOM, int RIGHT)).
		gbc.anchor = GridBagConstraints.CENTER;							// Permet d'ancrer le composant dans son espace alloué (1 ou plusieurs cellules).
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		_centerPane.add(_emailPane, gbc);								// Ajout du composant dans le GridBagLayout.
		
		// Bouton Apply
		JPanel pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pane.add(_applyBT);
		gbc.gridx = 0;													// Colonne 0.
		gbc.gridy = 3;													// Ligne 2.
		gbc.anchor = GridBagConstraints.LINE_END;
		_centerPane.add(pane, gbc);
		
	}

	/**
	 * 
	 * <b>updatePrefs() - org.tref.views.frames.PrefsFrame.updatePrefs()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Applique les changements des preferences.<br/>
	 * <br/>
	 */
	private void updatePrefs(){
		
		
		PrefsGUI.getInstance().updateLOC(new Locale(((LanguePane) _languesPane).get_locale(), ((LanguePane) _languesPane).get_locale().toUpperCase()));
		PrefsGUI.getInstance().updateLAF(((TFElement) _themesPane).getTextField().getText());
		
		if (_explorater != null) {
			ArrayList<PFrame> liste = _explorater.get_frames();
			for (Iterator<PFrame> iterator = liste.iterator(); iterator.hasNext();) {
				PFrame pFrame = iterator.next();
				pFrame.revalidate();
				pFrame.repaint();
			}
		}
		
	}
	
	/**
	 * 
	 * <b>getLafTF() - org.tref.views.frames.PrefsFrame.getLafTF()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Retourne le LookAndFeel.<br/>
	 * <br/>
	 * @return
	 */
	public JTextField getLafTF() {
		return _lafTF;
	}

	/**
	 * 
	 * <b>setLafTF() - org.tref.views.frames.PrefsFrame.setLafTF()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialise le LookAndFeel.<br/>
	 * <br/>
	 * @param lafTF_
	 */
	public void setLafTF(JTextField lafTF_) {
		_lafTF = lafTF_;
	}

	/**
	 * 
	 * <b>getLafLB() - org.tref.views.frames.PrefsFrame.getLafLB()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Retourne le label des LookAndFeel<br/>
	 * <br/>
	 * @return
	 */
	public JLabel getLafLB() {
		return _lafLB;
	}

	/**
	 * 
	 * <b>setLafLB() - org.tref.views.frames.PrefsFrame.setLafLB()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialise le label des LookAndFeel<br/>
	 * <br/>
	 * @param lafLB_
	 */
	public void setLafLB(JLabel lafLB_) {
		_lafLB = lafLB_;
	}

	/**
	 * 
	 * <b>getLafBT() - org.tref.views.frames.PrefsFrame.getLafBT()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Retourne le bouton des LookAndFeel.<br/>
	 * <br/>
	 * @return
	 */
	public JButton getLafBT() {
		return _lafBT;
	}

	/**
	 * 
	 * <b>setLafBT() - org.tref.views.frames.PrefsFrame.setLafBT()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialise le bouton des LookAndFeel<br/>
	 * <br/>
	 * @param lafBT_
	 */
	public void setLafBT(JButton lafBT_) {
		_lafBT = lafBT_;
	}

	/**
	 * 
	 * <b>getApplyBT() - org.tref.views.frames.PrefsFrame.getApplyBT()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @return
	 */
	public JButton getApplyBT() {
		return _applyBT;
	}

	/**
	 * 
	 * <b>setApplyBT() - org.tref.views.frames.PrefsFrame.setApplyBT()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @param applyBT_
	 */
	public void setApplyBT(JButton applyBT_) {
		_applyBT = applyBT_;
	}

	/**
	 * 
	 * <b>getThemesPane() - org.tref.views.frames.PrefsFrame.getThemesPane()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @return
	 */
	public JPanel getThemesPane() {
		return _themesPane;
	}

	/**
	 * 
	 * <b>setThemesPane() - org.tref.views.frames.PrefsFrame.setThemesPane()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @param themesPane_
	 */
	public void setThemesPane(JPanel themesPane_) {
		_themesPane = themesPane_;
	}

	/**
	 * 
	 * <b>getLanguesPane() - org.tref.views.frames.PrefsFrame.getLanguesPane()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @return
	 */
	public JPanel getLanguesPane() {
		return _languesPane;
	}

	/**
	 * 
	 * <b>setLanguesPane() - org.tref.views.frames.PrefsFrame.setLanguesPane()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @param languesPane_
	 */
	public void setLanguesPane(JPanel languesPane_) {
		_languesPane = languesPane_;
	}
	
	/**
	 * 
	 * <b>get_explorater() - org.tref.views.frames.PrefsFrame.get_explorater()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		<br/>
	 * <br/>
	 * @return
	 */
	public ExploraterFrame get_explorater() {
		return _explorater;
	}

	public void set_explorater(ExploraterFrame _explorater) {
		this._explorater = _explorater;
	}

	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.AppFrame#dispose()
	 */
	@Override
	public void dispose() {
		removeFrames();
		super.dispose();
	}
}
