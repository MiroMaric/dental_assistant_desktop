
package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ToothSideLabel implements GeneralDObject{
    
    private String toothSideLabelID;
    private String name;
    private String description;

    public ToothSideLabel() {
    }

    public ToothSideLabel(String toothSideLabelID, String name, String description) {
        this.toothSideLabelID = toothSideLabelID;
        this.name = name;
        this.description = description;
    }

    ToothSideLabel(String toothSideLabelID) {
        this.toothSideLabelID = toothSideLabelID;
    }

    public String getToothSideLabelID() {
        return toothSideLabelID;
    }

    public void setToothSideLabelID(String toothSideLabelID) {
        this.toothSideLabelID = toothSideLabelID;
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
        return "tooth_side_label";
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
        return "toothSideLabelID='"+toothSideLabelID+"'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothSideLabelID1 = rs.getString("toothSideLabelID");
        String name1 = rs.getString("name");
        String description1 = rs.getString("description");
        return new ToothSideLabel(toothSideLabelID1, name1, description1);
    }
    
    
}
