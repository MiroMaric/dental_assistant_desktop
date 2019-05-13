package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ToothRoot implements GeneralDObject{
    private String toothRootID;
    private String toothID;
    private String patientID;
    private ToothRootLabel label;
    private ToothRootState state;
    private List<ToothRootStateHistory> stateHistory;

    public ToothRoot() {
    }

    public ToothRoot(String toothRootID, String toothID, String patientID, ToothRootLabel label, ToothRootState state, List<ToothRootStateHistory> stateHistory) {
        this.toothRootID = toothRootID;
        this.toothID = toothID;
        this.patientID = patientID;
        this.label = label;
        this.state = state;
        this.stateHistory = stateHistory;
    }

    public String getToothRootID() {
        return toothRootID;
    }

    public void setToothRootID(String toothRootID) {
        this.toothRootID = toothRootID;
    }

    public String getToothID() {
        return toothID;
    }

    public void setToothID(String toothID) {
        this.toothID = toothID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public ToothRootLabel getLabel() {
        return label;
    }

    public void setLabel(ToothRootLabel label) {
        this.label = label;
    }

    public ToothRootState getState() {
        return state;
    }

    public void setState(ToothRootState state) {
        this.state = state;
    }

    public List<ToothRootStateHistory> getStateHistory() {
        return stateHistory;
    }

    public void setStateHistory(List<ToothRootStateHistory> stateHistory) {
        this.stateHistory = stateHistory;
    }

    @Override
    public String getClassName() {
        return "tooth_root";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(toothRootID).append("',")
                .append("'").append(patientID).append("',")
                .append("'").append(toothID).append("',")
                .append("'").append(label.getToothRootLabelID()).append("',")
                .append("'").append(state.getToothRootStateID()).append("'");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothRootID1 = rs.getString("toothRootID");
        String toothID1 = rs.getString("toothID");
        String patientID1 = rs.getString("patientID");
        String toothRootLabelID1 = rs.getString("toothRootLabelID");
        String toothRootStateID1= rs.getString("toothRootStateID");
        return new ToothRoot(toothRootID1, toothID1, patientID1, new ToothRootLabel(toothRootLabelID1), new ToothRootState(toothRootStateID1),null);
    }
    
    
}
