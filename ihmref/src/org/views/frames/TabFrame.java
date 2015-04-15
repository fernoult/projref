package org.views.frames;

import java.awt.Toolkit;

import org.views.Ressources;

import com.jtattoo.plaf.About;
import com.jtattoo.plaf.JTattooUtilities;

public class TabFrame extends AppFrame {

	public TabFrame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TabFrame(String title_){
		super();
		title_ = Ressources.getInstance().getLibelleValue("frame.tab.title.text");
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/views/images/list.png")));
		setSize(250, 200);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
