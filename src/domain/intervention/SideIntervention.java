package domain.intervention;

import domain.GeneralDObject;
import domain.tooth.ToothSide;
import domain.tooth.ToothSideState;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SideIntervention extends InterventionItem {

    private ToothSide toothSide;
    private ToothSideState state;

    public SideIntervention(Intervention intervention, String note, ToothSide toothSide, ToothSideState state) {
        super(intervention, note);
        this.toothSide = toothSide;
        this.state = state;
    }

    public SideIntervention(String itemID, ToothSideState state) {
        super(itemID);
        this.state = state;
    }

    public SideIntervention(String itemID, ToothSideState state, Intervention intervention) {
        this(itemID, state);
        this.intervention = intervention;
    }
    
    public SideIntervention() {

    }

    @Override
    public String getToothLabel() {
        return toothSide.getTooth().getLabel().toString();
    }

    public ToothSide getToothSide() {
        return toothSide;
    }

    public void setToothSide(ToothSide tooth) {
        this.toothSide = tooth;
    }

    public ToothSideState getState() {
        return state;
    }

    public void setState(ToothSideState state) {
        this.state = state;
    }

    @Override
    public String getStateLabel() {
        return getState().getName();
    }

    @Override
    public String getItemLabel() {
        return toothSide.getLabel().getName();
    }

    @Override
    public String getClassName() {
        return "side_intervention";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(intervention.getInterventionID()).append("',")
                .append("'").append(itemID).append("',")
                .append("'").append(toothSide.getToothSideID()).append("',")
                .append("'").append(toothSide.getTooth().getToothID()).append("',")
                .append("'").append(toothSide.getTooth().getPatient().getPatientID()).append("',")
                .append(state.getToothSideStateID());
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
        String interventionID1 = rs.getString("interventionID");
        String itemID1 = rs.getString("itemID");
        String toothSideID1 = rs.getString("toothSideID");
        String toothID1 = rs.getString("toothID");
        String patientID1 = rs.getString("patientID");
        int toothSideStateID1 = rs.getInt("toothSideStateID");
        return new SideIntervention(itemID1, new ToothSideState(toothSideStateID1), new Intervention(interventionID1));
    }

}
