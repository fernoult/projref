package org.tref.views.frames;

import java.awt.Toolkit;

import org.tref.common.resources.Ressources;
import org.tref.views.ViewsRessources;

public class TabFrame extends AppFrame {

	public TabFrame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TabFrame(String title_){
		super();
		title_ = ViewsRessources.getInstance().getLibelleValue("frame.tab.title.text");
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
				+ Ressources.getInstance().getSepProj() + "list.png")));
		setSize(250, 200);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
