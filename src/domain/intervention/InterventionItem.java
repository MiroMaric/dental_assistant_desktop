package domain.intervention;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public abstract class InterventionItem implements GeneralDObject {

    protected String itemID;
    protected Intervention intervention;
    protected String note;

    public InterventionItem() {
    }

    public InterventionItem(String itemID) {
        this.itemID = itemID;
    }

    public InterventionItem(Intervention intervention, String note) {
        this.itemID = UUID.randomUUID().toString();
        this.intervention = intervention;
        this.note = note;
    }

    public InterventionItem(String itemID, Intervention intervention, String note) {
        this.itemID = itemID;
        this.intervention = intervention;
        this.note = note;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStateLabel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getItemLabel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getClassName() {
        return "intervention_item";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(itemID).append("',")
                .append("'").append(intervention.getInterventionID()).append("',")
                .append("'").append(note)
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
        return "itemID='" + itemID + "'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String interventionID1 = rs.getString("interventionID");
        String itemID1 = rs.getString("itemID");
        String note1 = rs.getString("note");
        return new InterventionItem(itemID, new Intervention(interventionID1), note1) {
        };
    }

}
