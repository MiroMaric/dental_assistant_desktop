package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Appointment implements GeneralDObject {

    private String appointmentID;
    private User user;
    private Patient patient;
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private String description;

    public Appointment() {
    }

    public Appointment(String appointmentID, Patient patient, User user, GregorianCalendar startTime, GregorianCalendar endTime, String description) {
        this.appointmentID = appointmentID;
        this.user = user;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Appointment(Patient patient, User user, GregorianCalendar startTime, GregorianCalendar endTime, String description) {
        this.appointmentID = UUID.randomUUID().toString();
        this.user = user;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public void setStartTime(GregorianCalendar startTime) {
        this.startTime = startTime;
    }

    public GregorianCalendar getEndTime() {
        return endTime;
    }

    public void setEndTime(GregorianCalendar endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getStrDuration() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(getStartTime().getTime()) + " - " + sdf.format(getEndTime().getTime());
    }

    @Override
    public String getClassName() {
        return "appointment";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(appointmentID).
                append("', '").append(patient.getPatientID()).
                append("', '").append(user.getUsername()).
                append("', '").append(new java.sql.Timestamp(startTime.getTimeInMillis())).
                append("', '").append(new java.sql.Timestamp(endTime.getTimeInMillis())).
                append("', '").append(description).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("appointmentID='").append(appointmentID).
                append("',patientID='").append(patient.getPatientID()).
                append("',username='").append(user.getUsername()).
                append("',startTime='").append(new java.sql.Timestamp(startTime.getTimeInMillis())).
                append("',endTime='").append(new java.sql.Timestamp(endTime.getTimeInMillis())).
                append("',description='").append(description).
                append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] names = {"appointmentID", "patient", "user", "startTime", "endTime", "description"};
        return names[i];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String appointmentID1 = rs.getString("appointmentID");
        String patientID = rs.getString("patientID");
        String username = rs.getString("username");
        Date startTime1 = rs.getTimestamp("startTime");
        Date endTime1 = rs.getTimestamp("endTime");
        String description1 = rs.getString("description");
        GregorianCalendar gStartTime = new GregorianCalendar();
        gStartTime.setTimeInMillis(startTime1.getTime());
        GregorianCalendar gEndTime = new GregorianCalendar();
        gEndTime.setTimeInMillis(endTime1.getTime());
        return new Appointment(appointmentID1, new Patient(patientID), new User(username), gStartTime, gEndTime, description1);
    }

    @Override
    public String getWhereCondition() {
        return "appointmentID = "+"'"+appointmentID+"'";
    }

}
