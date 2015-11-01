/* ihmref-ExploraterFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.frames;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.tref.common.resources.Ressources;
import org.tref.common.resources.enums.EnumLogs;
import org.tref.views.comp.ElementEnum;
import org.tref.views.comp.panes.elements.ElementFactory;
import org.tref.views.comp.panes.elements.RButton;
import org.tref.views.frames.erreurs.ErrorFrame;

/**
 * @author fre
 *
 */
public class ExploraterFrame extends AppFrame {
	
	/** Le bouton de sortie de l'application. */
	private RButton _exit;
	
	/** Bouton de creation d'une fenetre representative d'un objet. */
	private RButton _newObj;
	
	/** Bouton de creation d'une fenetre qui liste des objets. */
	private RButton _newList;
	
	/** Bouton de creation de la fenetre des preferences. */
	private RButton _prefs;
	
	/** Largeur de la fenetre explorateur. */
	private int _width;
	
	/** Hauteur de la fenetre explorateur. */
	private int _height;
	
	/** Instance de l'explorateur pour passage dans un listner. */
	private ExploraterFrame _explo;

	/**
	 * 
	 * Constructeur de la classe ExploraterFrame.java
	 */
	public ExploraterFrame() {
		super();
		initSize();
		initPFrame();
	}
	
	/**
	 * 
	 * Constructeur de la classe ExploraterFrame.java
	 * @param title_
	 */
	public ExploraterFrame(String title_){
		super();
		setTitle(title_);
		initSize();
		initPFrame();
	}
	
	/**
	 * 
	 * <b>initSize() - org.tref.views.frames.ExploraterFrame.initSize()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Positionne la taille de l'exploratuer.<br/>
	 * <br/>
	 */
	protected void initSize(){
		
		// On poisitionne la taille de l'explorateur.
		_width = get_ressources().getSreenSize().width / 3;
		_height = get_ressources().getSreenSize().height / 2;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initPFrame()
	 */
	@Override
	protected void initPFrame() {
		
		// Appel de l'init de la fenetre parente.
		super.initPFrame();
		
		// On instancie this.
		// et init des composants.
		_explo = this;
		initComposants();
		initPanels();
		
		// On ajoute le panneau nord.
		add(get_northPane());
		
		// Comportement de base de la fenetre.
		// Taille, position sur l'ecran, comportement de fermeture.
		setSize(_width, _height);
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(_ressources.getImgsPath() + Ressources.getInstance().getSepProj() + _ressources.getPFrameLabel("explorater.icon.name"))));
			
		} catch (NullPointerException e) {
			e.getStackTrace();
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initPanels()
	 */
	@Override
	protected void initPanels() {
		
		// On initialise le panneau nord.
		_northPane.add(_toolBar);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.PFrame#initComposants()
	 */
	@Override
	protected void initComposants() {
		
		// ============= BOUTONS =================
		_exit = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.exit.values"));
		_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				if (confirmCloseApplication() == 0) {
					dispose();					
				}
			}
		});
		
		_newObj = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.attr.values"));
		_newObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// On ouvre une nouvelle fenetre representative d'un objet.
				ObjFrame objf = new ObjFrame("OBJ");
				addFrame(objf);
			}
		});
		
		_newList = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.tab.values"));
		_newList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// On ouvre une nouvelle fenetre qui liste des objets.
				TabFrame tabf = new TabFrame("TAB");
				addFrame(tabf);
			}
		});
		
		_prefs = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.prefs.values"));
		_prefs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PrefsFrame laff = new PrefsFrame("PREFS", _explo);
				addFrame(laff);
			}
		});
		
		// ============= TOOLBAR =================

		_toolBar.add(_prefs);
		_toolBar.add(_newObj);
		_toolBar.add(_newList);
		_toolBar.add(_exit);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.AppFrame#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		// Exit du programme
		System.exit(0);

	}
	
	/*
	 * (non-Javadoc)
	 * @see org.tref.views.frames.AppFrame#confirmCloseApplication()
	 */
	@Override
	protected int confirmCloseApplication() {
		// TODO Auto-generated method stub
		return super.confirmCloseApplication();
	}

	
}
