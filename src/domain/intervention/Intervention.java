package domain.intervention;

import domain.GeneralDObject;
import domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Intervention implements GeneralDObject{

    private String interventionID;
    private Date date;
    private String note;
    private List<InterventionItem> items;
    private User user;

    public Intervention() {
        interventionID = UUID.randomUUID().toString();
    }
    
    public Intervention(String interventionID) {
        this.interventionID = interventionID;
    }
    public Intervention(String interventionID, Date date, String note, List<InterventionItem> items, User user) {
        this.interventionID = interventionID;
        this.date = date;
        this.note = note;
        this.items = items;
        this.user = user;
    }
    public Intervention(Date date, String note,User user) {
        this();
        this.date = date;
        this.note = note;
        this.user = user;
    }
    
    public String getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(String interventionID) {
        this.interventionID = interventionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<InterventionItem> getItems() {
        return items;
    }

    public void setItems(List<InterventionItem> items) {
        this.items = items;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getClassName() {
        return "intervention";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(interventionID).append("',")
                .append("'").append(new java.sql.Timestamp(date.getTime())).append("',")
                .append("'").append(note).append("',")
                .append("'").append(user.getUsername())
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
        return "interventionID='"+interventionID+"'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String interventionID1 = rs.getString("interventionID");
        Date date1 = rs.getTimestamp("date");
        String note1 = rs.getString("note");
        String userID = rs.getString("userID");
        return new Intervention(interventionID1, date1, note1, null, new User(userID));
    }
}
