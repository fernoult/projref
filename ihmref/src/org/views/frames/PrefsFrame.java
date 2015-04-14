package org.views.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.IHMAccess;
import org.views.Ressources;
import org.views.ViewPrefs;
import org.views.comp.panes.LanguePane;
import org.views.comp.panes.ThemesPane;

import com.jtattoo.plaf.About;

public class PrefsFrame extends AppFrame {

	private JTextField _lafTF;
	private JLabel _lafLB;
	private JButton _lafBT;
	private JButton _applyBT;
	
	private JPanel _themesPane;
	private JPanel _languesPane;
	
	public PrefsFrame() {
		super();
	}
	public PrefsFrame(String title_){
		super();
		setTitle(title_);
		initPFrame();
	}

	
	@Override
	protected void initPFrame() {
		
		super.initPFrame();
		
		initComposants();
		initPanels();
		
		add(_centerPane);
		
		setSize(400, 230);
		setLocationRelativeTo(null);
	}
	
	
	@Override
	protected void initComposants() {
		

		
		_applyBT = new JButton(Ressources.getInstance().getLibelleValue("prefs.submit.button.text"));
		_applyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				updatePrefs();
				dispose();
			}
		});
		
		
		
	}
	
	@Override
	protected void initPanels() {
		
		// zone Skin
		_themesPane = new ThemesPane(this, ViewPrefs.getInstance().getLAF());
		_languesPane = new LanguePane(this, ViewPrefs.getInstance().getLocale().getLanguage());
		
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
		
		// Bouton Apply
		gbc.gridx = 0;													// Colonne 0.
		gbc.gridy = 2;													// Ligne 2.
		gbc.anchor = GridBagConstraints.LINE_END;
		_centerPane.add(_applyBT, gbc);
	}

	/**
	 * 
	 * updatePrefs
	 * [DESCRIPTION]:
	 * Cette methode permet d'appliquer es changements des preferences.</br></br>
	 * [PARAMETRES]:
	 * void
	 */
	private void updatePrefs(){
		
		System.out.println("update preferences");
		
		ViewPrefs.getInstance().updateLOC(new Locale(((LanguePane) _languesPane).get_locale(), ((LanguePane) _languesPane).get_locale().toUpperCase()));
		ViewPrefs.getInstance().updateLAF(((ThemesPane) _themesPane).getThemeTF().getText());
	}
	
	/** Methode getLafTF();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafTF
	 */
	public JTextField getLafTF() {
		return _lafTF;
	}
	/** Methode setLafTF();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JTextField PrefsFrame.java
	 * 
	 * @return the lafTF
	 */
	public void setLafTF(JTextField lafTF_) {
		_lafTF = lafTF_;
	}
	/** Methode getLafLB();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafLB
	 */
	public JLabel getLafLB() {
		return _lafLB;
	}
	/** Methode setLafLB();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JLabel PrefsFrame.java
	 * 
	 * @return the lafLB
	 */
	public void setLafLB(JLabel lafLB_) {
		_lafLB = lafLB_;
	}
	/** Methode getLafBT();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafBT
	 */
	public JButton getLafBT() {
		return _lafBT;
	}
	/** Methode setLafBT();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton PrefsFrame.java
	 * 
	 * @return the lafBT
	 */
	public void setLafBT(JButton lafBT_) {
		_lafBT = lafBT_;
	}
	/** Methode getApplyBT();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the applyBT
	 */
	public JButton getApplyBT() {
		return _applyBT;
	}
	/** Methode setApplyBT();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JButton PrefsFrame.java
	 * 
	 * @return the applyBT
	 */
	public void setApplyBT(JButton applyBT_) {
		_applyBT = applyBT_;
	}
	/** Methode getThemesPane();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the themesPane
	 */
	public JPanel getThemesPane() {
		return _themesPane;
	}
	/** Methode setThemesPane();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JPanel PrefsFrame.java
	 * 
	 * @return the themesPane
	 */
	public void setThemesPane(JPanel themesPane_) {
		_themesPane = themesPane_;
	}
	/** Methode getLanguesPane();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the languesPane
	 */
	public JPanel getLanguesPane() {
		return _languesPane;
	}
	/** Methode setLanguesPane();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * JPanel PrefsFrame.java
	 * 
	 * @return the languesPane
	 */
	public void setLanguesPane(JPanel languesPane_) {
		_languesPane = languesPane_;
	}
	@Override
	public void dispose() {
		removeFrames();
		super.dispose();
	}
}
