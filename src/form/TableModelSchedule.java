package form;

import domain.Appointment;
import domain.Patient;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import utill.SettingsLoader;

public class TableModelSchedule extends AbstractTableModel {

    private List<Appointment> appointments;
    private List<Appointment> filteredAppointments;
    private final String[] columnName;
    GregorianCalendar dateFrom;
    GregorianCalendar dateTo;

    public TableModelSchedule() {
        this(new LinkedList<>());
    }
    
    public TableModelSchedule(List<Appointment> appointments) {
        setDates();
        this.appointments = appointments;
        this.filteredAppointments = appointments.stream().collect(Collectors.toList());
        this.columnName = new String[]{"Vreme", "Ponedeljak", "Utorak", "Sreda", "Četvrtak", "Petak", "Subota", "Nedelja"};
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public int getRowCount() {
        return SettingsLoader.getInstance().getEndTime()-
                    SettingsLoader.getInstance().getStartTime();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return rowIndex + SettingsLoader.getInstance().getStartTime();
        return 0;
    }

    @Override
    public String getColumnName(int column) {
        GregorianCalendar columnDay = (GregorianCalendar)dateFrom.clone();
        columnDay.add(GregorianCalendar.DAY_OF_YEAR, column-1);
        if(column!=0){
            SimpleDateFormat sfm = new SimpleDateFormat("MMM");
            return columnName[column].substring(0,3)+", "+(columnDay.get(GregorianCalendar.DAY_OF_MONTH))+". "+
                    sfm.format(columnDay.getTime());
        }
        return columnName[column];
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public boolean addAppointments(Appointment appointment) {
        appointments.add(appointment);
        filteredAppointments.add(appointment);
        fireTableDataChanged();
        return true;
    }

    public void setDateFrom(GregorianCalendar dateFrom) {
        this.dateFrom = dateFrom;
    }

    public GregorianCalendar getDateFrom() {
        return dateFrom;
    }

    public void setDateTo(GregorianCalendar dateTo) {
        this.dateTo = dateTo;
    }

    public GregorianCalendar getDateTo() {
        return dateTo;
    }
    
    public void nextMonth(){
        dateFrom.add(GregorianCalendar.DAY_OF_YEAR, 7);
        dateTo.add(GregorianCalendar.DAY_OF_YEAR, 7);
        fireTableDataChanged();
    }
    
    public void previousMonth(){
        dateFrom.add(GregorianCalendar.DAY_OF_YEAR, -7);
        dateTo.add(GregorianCalendar.DAY_OF_YEAR, -7);
        fireTableDataChanged();
    }
    
    public Appointment getCellState(int row, int column, int index) {
        if (column == 0) {
            return null;
        }
        GregorianCalendar time = (GregorianCalendar)dateFrom.clone();
        time.add(GregorianCalendar.DAY_OF_YEAR, column-1);
        time.set(GregorianCalendar.HOUR_OF_DAY, row+SettingsLoader.getInstance().getStartTime());
        time.set(GregorianCalendar.MINUTE,index);
        time.set(GregorianCalendar.SECOND,2);
        for(Appointment a:filteredAppointments){
                if(a.getStartTime().getTimeInMillis()<=time.getTimeInMillis() && a.getEndTime().getTimeInMillis()>=time.getTimeInMillis()){
                    return a;
                }
        }
        return null;
    }
    
    private void setDates() {
        dateFrom = new GregorianCalendar();
        dateFrom.set(GregorianCalendar.DAY_OF_WEEK,2);
        dateTo = (GregorianCalendar)dateFrom.clone();
        dateTo.add(GregorianCalendar.DAY_OF_YEAR, 7);
    }

    public void filter(String filter) {
        filteredAppointments.clear();
        for(Appointment a:appointments){
            if((a.getPatient().getFirstname().toLowerCase()+" "+a.getPatient().getLastname().toLowerCase()).startsWith(filter)){
                filteredAppointments.add(a);
            }
        }
        fireTableDataChanged();
    }

    List<Appointment> getScheduledAppointments(GregorianCalendar time) {
        return appointments.stream().filter((t) -> {
            return (Math.abs(t.getStartTime().getTimeInMillis()-time.getTimeInMillis())<1000*60*59) &&
                    t.getStartTime().get(GregorianCalendar.HOUR)==time.get(GregorianCalendar.HOUR);
        }).collect(Collectors.toList());
    }

    void removeScheduledAppointment(Appointment appointment) {
        appointments.remove(appointment);
        this.filteredAppointments = appointments.stream().collect(Collectors.toList());
        fireTableDataChanged();
    }
}
