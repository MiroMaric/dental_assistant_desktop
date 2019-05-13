package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ToothRootLabel implements GeneralDObject{
    private String toothRootLabelID;
    private String name;
    private String description;

    public ToothRootLabel() {
    }

    public ToothRootLabel(String toothRootLabelID, String name, String description) {
        this.toothRootLabelID = toothRootLabelID;
        this.name = name;
        this.description = description;
    }

    ToothRootLabel(String toothRootLabelID) {
        this.toothRootLabelID = toothRootLabelID;
    }

    public String getToothRootLabelID() {
        return toothRootLabelID;
    }

    public void setToothRootLabelID(String toothRootLabelID) {
        this.toothRootLabelID = toothRootLabelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getClassName() {
        return "tooth_root_label";
    }

    @Override
    public String getAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "toothRootLabelID='"+toothRootLabelID+"'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothRootLabelID1 = rs.getString("toothRootLabelID");
        String name1 = rs.getString("name");
        String description1 = rs.getString("description");
        return new ToothRootLabel(toothRootLabelID1, name1, description1);
    }
    
    
}
