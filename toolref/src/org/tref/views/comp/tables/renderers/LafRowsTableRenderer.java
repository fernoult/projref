package org.tref.views.comp.tables.renderers;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LafRowsTableRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object object, boolean isSelected, boolean hasFocus, int row, int column) {
		Component component =  super.getTableCellRendererComponent(table, object, isSelected, hasFocus, row, column);
		
        // On passe les caracteres en gras et on centre dans la cellule
        Font font = component.getFont();
        component.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
        ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
        
//        LafTableModel model = (LafTableModel) table.getModel();
		
		return component;
	}
}
