package org.views.comp.table.renderer;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.views.comp.table.models.LafTableModel;
import org.views.comp.vbeans.LAF;

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
