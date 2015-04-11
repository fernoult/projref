/* ihmref-LafFrame.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 8 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JTextField;

import org.views.comp.panes.LafPane;

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
		get_centerPane().add(centerPane, BorderLayout.CENTER);
		add(get_centerPane());
		
		setSize(310, 470);
		if (_parentLocation != null) {
			setLocation(_parentLocation);			
		}else {
			setLocationRelativeTo(null);
		}
		setResizable(false);
	}

	
}
