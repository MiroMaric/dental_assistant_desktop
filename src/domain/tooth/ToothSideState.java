/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MikoPC
 */
public class ToothSideState implements GeneralDObject {

    private int toothSideStateID;
    private String name;
    private String description;
    private int color;

    public ToothSideState() {
    }


    public ToothSideState(int toothSideStateID, String name, String description, int color) {
        this.toothSideStateID = toothSideStateID;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public ToothSideState(int toothSideStateID) {
        this.toothSideStateID = toothSideStateID;
    }

    public int getToothSideStateID() {
        return toothSideStateID;
    }

    public void setToothSideStateID(int toothSideStateID) {
        this.toothSideStateID = toothSideStateID;
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
        return "tooth_side_state";
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
            return "toothSideStateID="+toothSideStateID;
        }
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        int toothSideStateID1 = rs.getInt("toothSideStateID");
        String name1 = rs.getString("name");
        String description1 = rs.getString("description");
        int color1 = rs.getInt("color");
        return new ToothSideState(toothSideStateID1, name1, description1, color1);
    }

}
