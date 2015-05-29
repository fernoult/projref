package org.tref.views.comp.panes;

import java.util.Locale;

import javax.swing.JPanel;

import org.tref.views.frames.PrefsFrame;

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
