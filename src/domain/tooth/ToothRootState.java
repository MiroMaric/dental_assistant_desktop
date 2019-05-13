
package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ToothRootState implements GeneralDObject{
    private String toothRootStateID;
    private String name;
    private String description;
    private int color;

    public ToothRootState() {
    }

    public ToothRootState(String toothRootStateID, String name, String description, int color) {
        this.toothRootStateID = toothRootStateID;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    ToothRootState(String toothRootStateID) {
        this.toothRootStateID = toothRootStateID;
    }

    public String getToothRootStateID() {
        return toothRootStateID;
    }

    public void setToothRootStateID(String toothRootStateID) {
        this.toothRootStateID = toothRootStateID;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String getClassName() {
        return "tooth_root_state";
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
        if(name!=null){
            return "name='" + name + "'";
        }else{
            return "toothRootStateID='"+toothRootStateID+"'";
        }
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothRootStateID1 = rs.getString("toothRootStateID");
        String name1 = rs.getString("name");
        String description1 = rs.getString("description");
        int color1 = rs.getInt("color");
        return new ToothRootState(toothRootStateID1, name1, description1, color1);
    }
}
