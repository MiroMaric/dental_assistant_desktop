
package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ToothState implements GeneralDObject{
    private String toothStateID;
    private String name;
    private String description;
    private String color;
    
    public ToothState() {
    }
    
    public ToothState(String toothStateID) {
        this.toothStateID = toothStateID;
    }
    
    public ToothState(String toothStateID, String name, String description, String color) {
        this.toothStateID = toothStateID;
        this.name = name;
        this.description = description;
        this.color = color;
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
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getToothStateID() {
        return toothStateID;
    }

    public void setToothStateID(String toothStateID) {
        this.toothStateID = toothStateID;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getClassName() {
        return "tooth_state";
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
        String[] atributes = {"toothStateID", "name", "description"};
        return atributes[i];
    }

    @Override
    public String getWhereCondition() {
        if(toothStateID==null){
            return "name = '"+name+"'";
        }else{
            return "toothStateID = '"+toothStateID+"'";
        }
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothStateID1 = rs.getString("toothStateID");
        String name1 = rs.getString("name");
        String description1 = rs.getString("description");
        return new ToothState(toothStateID1, name1, description1, null);
    }
    
    
    
}
