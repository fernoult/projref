package org.tref.views.frames;

import java.awt.Toolkit;

import org.tref.common.resources.Ressources;
import org.tref.views.ViewsRessources;

public class ObjFrame extends AppFrame{

	public ObjFrame() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjFrame(String title_){
		super();
		title_ = ViewsRessources.getInstance().getLibelleValue("frame.obj.title.text");
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
				+ Ressources.getInstance().getSepProj() + "objet.png")));
		setSize(250, 200);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
	}
	
}
