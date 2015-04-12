package org.views.frames;

import java.awt.Toolkit;

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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/org/views/images/list.png")));
		setSize(700, 700);
		setDefaultCloseOperation(ObjFrame.DISPOSE_ON_CLOSE);
		
	}
	
}
