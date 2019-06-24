package domain.intervention;

import domain.GeneralDObject;
import domain.tooth.ToothRoot;
import domain.tooth.ToothRootState;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RootIntervention extends InterventionItem {

    private ToothRoot toothRoot;
    private ToothRootState toothRootState;

    public RootIntervention(Intervention intervention, String note, ToothRoot toothRoot, ToothRootState toothRootState) {
        super(intervention, note);
        this.toothRoot = toothRoot;
        this.toothRootState = toothRootState;
    }

    public RootIntervention() {
    }

    public RootIntervention(String itemID, ToothRootState state) {
        super(itemID);
        this.toothRootState = state;
    }

    public RootIntervention(String itemID, ToothRootState state, Intervention intervention) {
        this(itemID, state);
        this.intervention = intervention;
    }

    public ToothRoot getToothRoot() {
        return toothRoot;
    }

    public void setToothRoot(ToothRoot toothRoot) {
        this.toothRoot = toothRoot;
    }

    public ToothRootState getToothRootState() {
        return toothRootState;
    }

    public void setToothRootState(ToothRootState toothRootState) {
        this.toothRootState = toothRootState;
    }

    @Override
    public String getToothLabel() {
        return toothRoot.getTooth().toString();
    }

    @Override
    public String getStateLabel() {
        return getToothRootState().getName();
    }

    @Override
    public String getItemLabel() {
        return toothRoot.getLabel().getName();
    }

    @Override
    public String getClassName() {
        return "root_intervention";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(intervention.getInterventionID()).append("',")
                .append("'").append(itemID).append("',")
                .append("'").append(toothRoot.getTooth().getToothID()).append("',")
                .append("'").append(toothRoot.getTooth().getPatient().getPatientID()).append("',")
                .append(toothRootState.getToothRootStateID()).append(",")
                .append("'").append(toothRoot.getToothRootID()).append("'");
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
        String toothSideID1 = rs.getString("toothRootID");
        String toothID1 = rs.getString("toothID");
        String patientID1 = rs.getString("patientID");
        int toothRootStateID1 = rs.getInt("toothRootStateID");
        return new RootIntervention(itemID1, new ToothRootState(toothRootStateID1), new Intervention(interventionID1));
    }
}
