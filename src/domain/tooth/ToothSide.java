
package domain.tooth;

import domain.GeneralDObject;
import domain.Patient;
import domain.intervention.SideIntervention;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public class ToothSide implements GeneralDObject {

    private String toothSideID;
    private Tooth tooth;
    private ToothSideLabel label;
    private List<SideIntervention> sideInterventions;

    public ToothSide() {
    }

    
    public ToothSide(String toothSideID, Tooth tooth, ToothSideLabel label,List<SideIntervention> sideInterventions) {
        this.toothSideID = toothSideID;
        this.tooth = tooth;
        this.label = label;
        this.sideInterventions = sideInterventions;
    }

    public ToothSide(Tooth tooth,ToothSideLabel label) {
        toothSideID = UUID.randomUUID().toString();
        this.tooth = tooth;
        this.label = label;
    }
    
    public ToothSide(String toothSideID,Tooth tooth,ToothSideLabel label) {
        this.toothSideID = toothSideID;
        this.tooth = tooth;
        this.label = label;
    }
    
    public String getToothSideID() {
        return toothSideID;
    }

    public void setToothSideID(String toothSideID) {
        this.toothSideID = toothSideID;
    }

    public ToothSideLabel getLabel() {
        return label;
    }

    public void setLabel(ToothSideLabel label) {
        this.label = label;
    }

    public List<SideIntervention> getSideInterventions() {
        return sideInterventions;
    }
        
    public void setSideInterventions(List<SideIntervention> sideInterventions) {
        this.sideInterventions = sideInterventions;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }
    
    @Override
    public String getClassName() {
        return "tooth_side";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(toothSideID).append("',")
                .append("'").append(tooth.getPatient().getPatientID()).append("',")
                .append("'").append(tooth.getToothID()).append("',")
                .append("'").append(label.getToothSideLabelID())
                .append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByColumn(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereCondition() {
        return "toothSideID = "+"'"+toothSideID+"'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothSideID1 = rs.getString("toothSideID");
        String toothID1 = rs.getString("toothID");
        String patientID1 = rs.getString("patientID");
        String toothSideLabelID = rs.getString("toothSideLabelID");
        return new ToothSide(toothSideID1,new Tooth(toothID1,new Patient(patientID1)), new ToothSideLabel(toothSideLabelID));
    }
}
