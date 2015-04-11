package org.views.frames;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ObjFrame extends AppFrame{

	public ObjFrame() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjFrame(String title_){
		super();
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/views/images/objet.png")));
		setSize(700, 700);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
	}
	
}
