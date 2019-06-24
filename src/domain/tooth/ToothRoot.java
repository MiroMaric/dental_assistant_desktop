package domain.tooth;

import domain.GeneralDObject;
import domain.Patient;
import domain.intervention.RootIntervention;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ToothRoot implements GeneralDObject {

    private String toothRootID;
    private Tooth tooth;
    private ToothRootLabel label;
    private List<RootIntervention> rootInterventions;

    public ToothRoot() {
    }

    public ToothRoot(String toothRootID, Tooth tooth, ToothRootLabel label, List<RootIntervention> rootInterventions) {
        this.toothRootID = toothRootID;
        this.tooth = tooth;
        this.label = label;
        this.rootInterventions = rootInterventions;
    }

    public ToothRoot(Tooth tooth, ToothRootLabel label) {
        toothRootID = UUID.randomUUID().toString();
        this.tooth = tooth;
        this.label = label;
    }

    private ToothRoot(String toothRootID, Tooth tooth, ToothRootLabel toothRootLabel) {
        this.toothRootID = toothRootID;
        this.tooth = tooth;
        this.label = toothRootLabel;
    }

    public String getToothRootID() {
        return toothRootID;
    }

    public void setToothRootID(String toothRootID) {
        this.toothRootID = toothRootID;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public ToothRootLabel getLabel() {
        return label;
    }

    public void setLabel(ToothRootLabel label) {
        this.label = label;
    }

    public List<RootIntervention> getRootInterventions() {
        return rootInterventions;
    }

    public void setRootInterventions(List<RootIntervention> rootInterventions) {
        this.rootInterventions = rootInterventions;
    }

    @Override
    public String getClassName() {
        return "tooth_root";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(toothRootID).append("',")
                .append("'").append(tooth.getToothID()).append("',")
                .append("'").append(tooth.getPatient().getPatientID()).append("',")
                .append("'").append(label.getToothRootLabelID())
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
        return "toothRootID = "+"'"+toothRootID+"'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothRootID1 = rs.getString("toothRootID");
        String toothID1 = rs.getString("toothID");
        String patientID1 = rs.getString("patientID");
        String toothRootLabelID = rs.getString("toothRootLabelID");
        return new ToothRoot(toothRootID1,new Tooth(toothID1,new Patient(patientID1)), new ToothRootLabel(toothRootLabelID));
    }
}
