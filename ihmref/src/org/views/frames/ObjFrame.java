package org.views.frames;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import org.views.Ressources;

public class ObjFrame extends AppFrame{

	public ObjFrame() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjFrame(String title_){
		super();
		title_ = Ressources.getInstance().getLibelleValue("frame.obj.title.text");
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/views/images/objet.png")));
		setSize(250, 200);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
	}
	
}
