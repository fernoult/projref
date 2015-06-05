package org.tref.views.comp.panes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ZonePane extends JPanel {

	private ArrayList<JPanel> _elementList = new ArrayList<>();
	
	public ZonePane() {
	}

	public ZonePane(LayoutManager arg0) {
		super(arg0);
	}

	public ZonePane(boolean arg0) {
		super(arg0);
	}

	public ZonePane(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
	}
	
	private void initZonePane(String _zoneTitle){
		
		setLayout(new FlowLayout());
		Font font = new Font("Tahoma", Font.BOLD, 12);
		
		JLabel titl = new JLabel("Themes");
//		Border CLine = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#210B61"));
		Border CLine = BorderFactory.createEmptyBorder();
		
		TitledBorder title = BorderFactory.createTitledBorder(CLine, _zoneTitle, TitledBorder.LEFT, TitledBorder.TOP, font, Color.decode("#210B61"));
		
		setBorder(title);
	}

}
