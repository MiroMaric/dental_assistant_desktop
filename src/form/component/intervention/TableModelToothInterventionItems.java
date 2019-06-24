package form.component.intervention;

import domain.intervention.InterventionItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MikoPC
 */
public class TableModelToothInterventionItems extends AbstractTableModel{

    private List<InterventionItem> interventions;
    private final String[] columns;
    
    public TableModelToothInterventionItems() {
        this.columns = new String[]{"Zub","Oznaka","Status","Opis"};
        interventions = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return interventions.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        InterventionItem item = interventions.get(row);
        switch(column){
            case 0:
                return item.getToothLabel();
            case 1:
                return item.getItemLabel();
            case 2:
                return item.getStateLabel();
            case 3:
                return item.getNote();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public void addInterventionItem(InterventionItem item){
        interventions.add(item);
        fireTableDataChanged();
    }
    
    public void removeInterventionItem(int index) {
        interventions.remove(index);
        fireTableDataChanged();
    }

    public InterventionItem getInterventionItem(int index) {
        return interventions.get(index);
    }
    
}
