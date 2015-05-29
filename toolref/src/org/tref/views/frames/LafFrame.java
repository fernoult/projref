/* ihmref-LafFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.views.frames;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JTextField;

import org.tref.views.comp.panes.LafPane;

public class LafFrame extends TabFrame {

	private Point _parentLocation;
	
	/** LafFrame
	 * Constructeur
	 */
	public LafFrame() {
		super();
		initPFrame();
	}
	
	public LafFrame(Point parentLocation_, JTextField lafTF_){
		super();
		_parentLocation = parentLocation_;
		System.out.println(_parentLocation.getX() + " - " + _parentLocation.getY());
		initPFrame(lafTF_);
	}
	
	@Override
	protected void initPFrame(JTextField lafTF_) {
		super.initPFrame();
		
		LafPane centerPane = new LafPane(lafTF_, this);
		_centerPane.add(centerPane, BorderLayout.CENTER);
		add(_centerPane);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/views/images/lnf.png")));
		setSize(310, 470);
		if (_parentLocation != null) {
			setLocation(_parentLocation);			
		}else {
			setLocationRelativeTo(null);
		}
		setResizable(false);
	}

	
}
