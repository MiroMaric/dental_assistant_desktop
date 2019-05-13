package form;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;


public class MyTableCellRenderer extends DefaultTableCellRenderer{

    Color cellColor;
    public MyTableCellRenderer() {
    }

    public MyTableCellRenderer(Color cellColor) {
        this.cellColor = cellColor;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        TableModel tm = (TableModel) table.getModel();
        if (row == -1) {
            JLabel headerCell = new JLabel(tm.getColumnName(column));
            headerCell.setOpaque(true);
            headerCell.setBackground(ColorConstant.GREEN_STRONG);
            headerCell.setForeground(Color.WHITE);
            headerCell.setHorizontalAlignment(JLabel.CENTER);
            return headerCell;
        }
        if(cellColor!=null){
            System.out.println(c.getClass());
            c.setBackground(cellColor);
        }
        return c;
    }
}
