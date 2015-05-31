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

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.tref.common.resources.Ressources;
import org.tref.views.comp.ElementEnum;
import org.tref.views.comp.panes.elements.ElementFactory;
import org.tref.views.comp.panes.elements.RButton;

/**
 * @author fre
 *
 */
public class ExploraterFrame extends AppFrame {
	
	private RButton _exit;
	
	private RButton _newObj;
	
	private RButton _newList;
	
	private RButton _prefs;
	
	private int _width = get_ressources().getSreenSize().width / 3;
	
	private int _height = get_ressources().getSreenSize().height / 2;
	
	private ExploraterFrame _explo;
	
	/** ExploraterFrame
	 * Constructeur
	 */
	public ExploraterFrame() {
		super();
		initPFrame();
	}
	
	public ExploraterFrame(String title_){
		super();
		setTitle(title_);
		initPFrame();
	}
	
	@Override
	protected void initPFrame() {
		super.initPFrame();
		
//        // Ajout de l'interdiction sur la croix.
//        addWindowListener(new WindowAdapter() {
//        	
//        	@SuppressWarnings("static-access")
//			@Override
//        	public void windowClosing(WindowEvent e) {
//        		
//        		// Si le traitement n'est pas encore termin�, on interdit de fermer la fen�tre avec la croix.
//        		// et on affiche une fen�tre d'avertissement avec message + possibilit� d'annuler proprement la requ�te.
//        		
//        		if ( confirmClose() == 0) {
//					setDefaultCloseOperation(EXIT_ON_CLOSE);
//					dispose();
//				}
//
//        	}
//		});
		_explo = this;
		// init des composants.
		initComposants();
		initPanels();
		
		
		add(get_northPane());
		
		// Comportement de base de la fenetre.
		setSize(_width, _height);
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(
					Ressources.getInstance().getSepProj() + _ressources.getImgsPath() + Ressources.getInstance().getSepProj() + _ressources.getPFrameLabel("explorater.icon.name"))));
			
		} catch (NullPointerException e) {
			System.out.println("fuck...");
		}
		setLocationRelativeTo(null);
		setDefaultCloseOperation(ExploraterFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	protected void initPanels() {
		
		_northPane.add(_toolBar);
		
	}
	
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
				
				ObjFrame objf = new ObjFrame("OBJ");
				get_frames().add(objf);
			}
		});
		
		_newList = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.tab.values"));
		_newList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TabFrame tabf = new TabFrame("TAB");
				get_frames().add(tabf);
			}
		});
		
		_prefs = ElementFactory.getInstance().getButton(ElementEnum.ICON_BUTTON, 
				_ressources.getLibelleButtonValues("explorateur.btn.prefs.values"));
//		final ExploraterFrame explo = this;
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
	
	@Override
	public void dispose() {
		super.dispose();
		// Exit du programme
		System.exit(0);

	}
	
	@Override
	protected int confirmCloseApplication() {
		// TODO Auto-generated method stub
		return super.confirmCloseApplication();
	}

	
}
