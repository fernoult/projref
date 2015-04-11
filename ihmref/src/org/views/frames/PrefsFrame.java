package org.views.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.IHMAccess;

import com.jtattoo.plaf.About;

public class PrefsFrame extends AppFrame {

	private JTextField _lafTF;
	private JLabel _lafLB;
	private JButton _lafBT;
	private JButton _applyBT;
	private Point _location;
	
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
		
		add(get_centerPane());
		
		setSize(400, 300);
		setLocationRelativeTo(null);
	}
	
	
	@Override
	protected void initComposants() {
		
		// zone Skin
		_lafLB = new JLabel();
		_lafLB.setText("Choix du skins : ");
		_lafTF = new JTextField(20);
		_lafBT = new JButton(new ImageIcon(getClass().getResource("/org/views/images/deco.png")));
//		_lafBT.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				new LafFrame(_location);
//			}
//		});
		_lafBT.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				_location = e.getLocationOnScreen();
//				new LafFrame(_location);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO JavaDoc tout de suite !!!!!!
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				_location = e.getLocationOnScreen();
				addFrame(new LafFrame(_location, _lafTF));
			}
		});
		
		_applyBT = new JButton("Apply");
		_applyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// TODO : Solution un peu foireuse, a refaire mieux que ca!
				IHMAccess.setLAF(_lafTF.getText());
				dispose();
			}
		});
		
		
		
	}
	
	@Override
	protected void initPanels() {
		
		get_centerPane().setLayout(new BorderLayout());
		JPanel test = new JPanel(new FlowLayout(FlowLayout.CENTER));
		test.add(_lafLB);
		test.add(_lafTF);
		test.add(_lafBT);		
		
		JPanel pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pane.add(_applyBT);
		
		get_centerPane().add(test, BorderLayout.NORTH);
		get_centerPane().add(pane, BorderLayout.SOUTH);
	}
	
	private void displayOLAF(){ // LOOOOOOOL !!! T'as compris !!?? All LAF -> OLAF !! Reine des neiges, le bonhomme de neige!! OLAF quoi!!!
		
		Package packa = About.class.getPackage();
		Package[] packs = packa.getPackages();
		
		for (int i = 0; i < packs.length; i++) {
			System.out.println(packs[i].getName());
		}
	}

	@Override
	public void dispose() {
		removeFrames();
		super.dispose();
	}
}
