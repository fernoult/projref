/* ihmref-PFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 7 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import org.Ressources;

import com.sun.awt.AWTUtilities;


public class PFrame extends JFrame{

	protected String _name;
	
	protected JPanel _northPane;
	
	protected JPanel _centerPane;
	
	protected JPanel _southPane;
	
	protected ArrayList<PFrame> _frames = new ArrayList<>();
	
	protected JToolBar _toolBar;
	
	protected Ressources _ressources = Ressources.getInstance();
	
	
	
	
	public PFrame(){
		initPFrame();
	}
	
	protected void initPFrame(){
		
		// le layout
		setLayout(new BorderLayout());
		
		_northPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		_centerPane = new JPanel(new BorderLayout());
		_southPane = new JPanel();
		
		_toolBar = new JToolBar();
		_toolBar.setFloatable(false);
		
		// Le comportement de base.

		setVisible(true);
	}
	
	protected void initPFrame(JTextField lafTF_) {
		
		initPFrame();
	}
	
	protected void initPanels(){
		
	}
	
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
	
	public Ressources get_ressources() {
		return _ressources;
	}

	/**
	 * @param _ressources the _ressources to set
	 */
	public void set_ressources(Ressources _ressources) {
		this._ressources = _ressources;
	}



	
	
	
	
}
