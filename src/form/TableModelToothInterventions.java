package form;

import domain.intervention.InterventionItem;
import domain.tooth.Tooth;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelToothInterventions extends AbstractTableModel{

    private Tooth tooth;
    private List<InterventionItem> interventions;
    private final String[] columns;
    
    public TableModelToothInterventions(Tooth tooth) {
        this.tooth = tooth;
        interventions = tooth.getAllInterventions();
        columns = new String[]{"Oznaka","Stanje","Opis","Datum"};
    }

    public TableModelToothInterventions() {
        columns = new String[]{"Oznaka","Stanje","Opis","Datum"};
        interventions = new LinkedList<>();
    }
    
    public InterventionItem getIntervention(int index) {
        return interventions.get(index);
    }
    
    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
        interventions = tooth.getAllInterventions();
        fireTableDataChanged();
    }
  
    public Date getInterventionDate(int selectedRowIndex) {
        return interventions.get(selectedRowIndex).getIntervention().getDate();
    }
    
    public void addInterventionItem(InterventionItem item){
        interventions.add(item);
        fireTableDataChanged();
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
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        InterventionItem item = interventions.get(row);
        switch(column){
            case 0:
                return item.getItemLabel();
            case 1:
                return item.getStateLabel();
            case 2:
                return item.getNote();
            case 3:
                return new SimpleDateFormat("dd.MM.yyyy").format(item.getIntervention().getDate());
            default:
                return "N/A";
        }
    }

    public void removeInterventionItem(int index) {
        interventions.remove(index);
        fireTableDataChanged();
    }

    public InterventionItem getInterventionItem(int index) {
        return interventions.get(index);
    }
}
