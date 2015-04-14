/* ihmref-ExploraterFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.frames;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import org.views.Ressources;

import com.sun.awt.AWTUtilities;

/**
 * @author fre
 *
 */
public class ExploraterFrame extends AppFrame {
	
	private JButton _exit;
	
	private JButton _newObj;
	
	private JButton _newList;
	
	private JButton _prefs;
	
	private int _width = get_ressources().getSreenSize().width / 3;
	
	private int _height = get_ressources().getSreenSize().height / 2;
	
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
		
        // Ajout de l'interdiction sur la croix.
        addWindowListener(new WindowAdapter() {
        	
        	@SuppressWarnings("static-access")
			@Override
        	public void windowClosing(WindowEvent e) {
        		
        		// Si le traitement n'est pas encore termin�, on interdit de fermer la fen�tre avec la croix.
        		// et on affiche une fen�tre d'avertissement avec message + possibilit� d'annuler proprement la requ�te.
        		
        		if ( confirmClose() == 0) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					dispose();
				}else {
        			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}

        	}
		});
		
		// init des composants.
		initComposants();
		initPanels();
		
		
		add(get_northPane());
		
		// Comportement de base de la fenetre.
		setSize(_width, _height);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/views/images/explo.png")));
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
		_exit = new JButton(new ImageIcon(getClass().getResource("/org/views/images/exit.png")));
		_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e_) {
				if (confirmClose() == 0) {
					dispose();					
				}
			}
		});
		
		_newObj = new JButton(new ImageIcon(getClass().getResource("/org/views/images/objet.png")));
		_newObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ObjFrame objf = new ObjFrame("OBJ");
				get_frames().add(objf);
			}
		});
		
		_newList = new JButton(new ImageIcon(getClass().getResource("/org/views/images/list.png")));
		_newList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TabFrame tabf = new TabFrame("TAB");
				get_frames().add(tabf);
			}
		});
		
		_prefs = new JButton(new ImageIcon(getClass().getResource("/org/views/images/prefs.png")));
		final ExploraterFrame explo = this;
		_prefs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PrefsFrame laff = new PrefsFrame("PREFS", explo);
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
	
	private int confirmClose(){
		return  JOptionPane.showConfirmDialog(null, "Etes vous sur de vouloir quitter l'application?", "CONFIRM", JOptionPane.WARNING_MESSAGE);
	}

	
}
