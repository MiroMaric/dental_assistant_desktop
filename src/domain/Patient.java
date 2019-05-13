package domain;

import domain.tooth.Tooth;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Patient extends Person implements GeneralDObject {

    private String patientID;
    private Date birthDate;
    private Date cardboardDate;
    private boolean deactivated;
    private List<Tooth> teeth;

    public Patient() {
    }

    public Patient(String firstname, String lastname, String email, String adress, String phone, Date birthDate, Date cardboardDate) {
        super(firstname, lastname, email, adress, phone);
        this.birthDate = birthDate;
        this.cardboardDate = cardboardDate;
        this.deactivated = false;
        this.patientID = UUID.randomUUID().toString();
    }

    public Patient(String patientID, String firstname, String lastname, String email, String adress, String phone, Date birthDate, Date cardboardDate, boolean deactivated) {
        this(firstname, lastname, email, adress, phone, birthDate, cardboardDate);
        this.patientID = patientID;
        this.deactivated = deactivated;
    }

    public Patient(String patientID) {
        this.patientID = patientID;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Tooth> getTeeth() {
        return teeth;
    }

    public void setTeeth(List<Tooth> teeth) {
        this.teeth = teeth;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCardboardDate() {
        return cardboardDate;
    }

    public void setCardboardDate(Date cartboardDate) {
        this.cardboardDate = cartboardDate;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    @Override
    public String getClassName() {
        return "Patient";
    }

    @Override
    public String toString() {
        return firstname+" "+lastname;
    }
    
    @Override
    public String getAtrValue() {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date cardboardDate1 = java.sql.Date.valueOf(sm.format(cardboardDate));
        java.sql.Date birthDate1 = birthDate==null?null:java.sql.Date.valueOf(sm.format(birthDate));
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(patientID).append("'").append(",").
                append("'").append(getFirstname()).append("'").append(",").
                append("'").append(getLastname()).append("'").append(",").
                append(getEmail()==null?null:"'"+getEmail()+"'").append(",").
                append(birthDate1==null?null:"'"+birthDate1+"'").append(",").
                append(getAddress()==null?null:"'"+getAddress()+"'").append(",").
                append(getPhone()==null?null:"'"+getPhone()+"'").append(",").
                append(cardboardDate1==null?null:"'"+cardboardDate1+"'").append(",").
                append(deactivated);
//        sb.append("'").append(patientID).
//                append("', '").append(getFirstname()).
//                append("', '").append(getLastname()).
//                append("', '").append(getEmail()).
//                append("', '").append(birthDate1).
//                append("', '").append(getAddress()).
//                append("', '").append(getPhone()).
//                append("', '").append(cardboardDate1).
//                append("',").append(deactivated);
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributes = {"patientID", "firstname", "lastname", "email", "birthDate", "adress", "phone", "cardboardDate", "deactivated"};
        return atributes[i];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String lPatientID = rs.getString("patientID");
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        String email = rs.getString("email");
        Date lBirthDate = rs.getDate("birthDate");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        Date lcardboardDate = rs.getDate("cardboardDate");
        boolean lDeactivated = rs.getBoolean("deactivated");
        return new Patient(lPatientID, firstname, lastname, email, address, phone, lBirthDate, lcardboardDate, lDeactivated);
    }

    @Override
    public String getWhereCondition() {
        return "patientID = "+"'"+patientID+"'";
    }

}
