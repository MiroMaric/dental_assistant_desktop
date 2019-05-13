
package form;

import domain.Patient;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelPatient extends AbstractTableModel{
    
    List<Patient> patients;
    List<Patient> filteredPatients;
    String[] columnNames;

    public TableModelPatient(List<Patient> patients) {
        this.patients = patients;
        filteredPatients = new LinkedList<>();
        patients.forEach((p) -> {
            filteredPatients.add(p);
        });
        columnNames = new String[]{"Ime","Prezime","Telefon","Adresa"};
    }
    
    
    @Override
    public int getRowCount() {
        return filteredPatients==null?0:filteredPatients.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Patient patient = filteredPatients.get(rowIndex);
        switch(columnIndex){
            case 0:
                return patient.getFirstname();
            case 1:
                return patient.getLastname();
            case 2:
                return patient.getPhone();
            case 3:
                return patient.getAddress();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public List<Patient> getFilteredPatients(){
        return filteredPatients;
    }
    
    public void filter(String filter){
        Patient p;
        filteredPatients.clear();
        for(int i=0;i<patients.size();i++){
            p = patients.get(i);
            if((p.getFirstname().trim().toLowerCase()+" "+p.getLastname().toLowerCase().trim()).startsWith(filter)){
                filteredPatients.add(p);
            }
        }
        fireTableDataChanged();
    }
    
    
    
}
