/* ihmref-PFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 7 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import org.tref.views.ViewsRessources;


public class PFrame extends JFrame{

	/** Nom de la fenetre. */
	protected String _name;
	
	/** Panneau nord */
	protected JPanel _northPane;
	
	/** Panneau central */
	protected JPanel _centerPane;
	
	/** Panneau sud. */
	protected JPanel _southPane;
	
	/** Liste des fenetres filles */
	protected ArrayList<PFrame> _frames;
	
	/** La ToolBar */
	protected JToolBar _toolBar;
	
	/** Les ressources des vues. */
	protected ViewsRessources _ressources; 
	
	
	
	/**
	 * 
	 * Constructeur de la classe PFrame.java
	 */
	public PFrame(){
		
		// On initialise la liste des fenetres filles,
		// et l'instance d'access aux ressources.
		_frames = new ArrayList<>();
		_ressources = ViewsRessources.getInstance();
		
		// On declenche l'init de la fenetre.
		initPFrame();
		
	}
	
	/**
	 * 
	 * <b>initPFrame() - org.tref.views.frames.PFrame.initPFrame()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Methode d'initialisation de la fenetre.<br/>
	 * <br/>
	 */
	protected void initPFrame(){
		
		// le layout
		setLayout(new BorderLayout());
		
		// Init des panneaux.
		_northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		_centerPane = new JPanel(new BorderLayout());
		_southPane = new JPanel();
		
		// Init de la toolbar.
		_toolBar = new JToolBar();
		_toolBar.setFloatable(false);
		
		// La fenetre est visible.
		setVisible(true);
		
	}
	
	/**
	 * 
	 * <b>initPFrame() - org.tref.views.frames.PFrame.initPFrame()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Methode d'initialisation de la fenetre avec le TextField.<br/>
	 * <br/>
	 * @param lafTF_
	 */
	protected void initPFrame(JTextField lafTF_) {
		
		// On appel l'init principal.
		initPFrame();
	}
	
	/**
	 * 
	 * <b>initPanels() - org.tref.views.frames.PFrame.initPanels()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialiation des panneaux.<br/>
	 * <br/>
	 */
	protected void initPanels(){
		
	}
	
	/**
	 * 
	 * <b>initComposants() - org.tref.views.frames.PFrame.initComposants()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Initialisation des composants.<br/>
	 * <br/>
	 */
	protected void initComposants(){
		
	}

	/**
	 * @return the _name
	 */
	
	public String get_name() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void set_name(String _name) {
		this._name = _name;
	}

	/**
	 * @return the _northPane
	 */
	
	public JPanel get_northPane() {
		return _northPane;
	}

	/**
	 * @param _northPane the _northPane to set
	 */
	public void set_northPane(JPanel _northPane) {
		this._northPane = _northPane;
	}
	
	/**
	 * @return the _centerPane
	 */
	
	public JPanel get_centerPane() {
		return _centerPane;
	}

	/**
	 * @param _centerPane the _centerPane to set
	 */
	public void set_centerPane(JPanel _centerPane) {
		this._centerPane = _centerPane;
	}

	/**
	 * @return the _southPane
	 */
	
	public JPanel get_southPane() {
		return _southPane;
	}

	/**
	 * @param _southPane the _southPane to set
	 */
	public void set_southPane(JPanel _southPane) {
		this._southPane = _southPane;
	}

	/**
	 * @return the _frames
	 */
	
	public ArrayList<PFrame> get_frames() {
		return _frames;
	}

	/**
	 * @param _frames the _frames to set
	 */
	public void set_frames(ArrayList<PFrame> _frames) {
		this._frames = _frames;
	}
	
	public JToolBar get_toolBar() {
		return _toolBar;
	}
	
	public void set_toolBar(JToolBar _toolBar) {
		this._toolBar = _toolBar;
	}

	/**
	 * @return the _ressources
	 */
	
	public ViewsRessources get_ressources() {
		return _ressources;
	}

	/**
	 * @param _ressources the _ressources to set
	 */
	public void set_ressources(ViewsRessources _ressources) {
		this._ressources = _ressources;
	}



	
	
	
	
}
