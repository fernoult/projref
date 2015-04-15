package org.views.comp.panes;

import java.awt.LayoutManager;
import java.util.Locale;

import javax.swing.JPanel;

import org.views.frames.PrefsFrame;

public class AdminPane extends JPanel {

	public AdminPane() {
		super();
		initPane("FR");
	}

	public AdminPane(PrefsFrame parentFrame_, Locale locale_){
		super();
		initPane(locale_.getCountry());
	}

	private void initPane(String locale_){
		
	}
}
