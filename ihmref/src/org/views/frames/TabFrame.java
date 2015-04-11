package org.views.frames;

import com.jtattoo.plaf.About;
import com.jtattoo.plaf.JTattooUtilities;

public class TabFrame extends AppFrame {

	public TabFrame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TabFrame(String title_){
		super();
		setTitle(title_);
	}

	@Override
	protected void initPFrame() {
		super.initPFrame();
		
		setSize(700, 700);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
