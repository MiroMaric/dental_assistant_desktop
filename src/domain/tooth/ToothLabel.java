package domain.tooth;

import domain.GeneralDObject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToothLabel implements GeneralDObject {

    private String toothLabelID;
    private int number;
    private int quadrant;
    private int numOfRoots;
    private String description;

    public ToothLabel() {
    }
    
    public ToothLabel(String toothLabelID) {
        this.toothLabelID = toothLabelID;
    }
    
    public ToothLabel(String toothLabelID, int number, int quadrant, int numOfRoots, String description) {
        this.toothLabelID = toothLabelID;
        this.number = number;
        this.quadrant = quadrant;
        this.numOfRoots = numOfRoots;
        this.description = description;
    }

    public String getToothLabelID() {
        return toothLabelID;
    }

    public void setToothLabelID(String toothLabelID) {
        this.toothLabelID = toothLabelID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(int quadrant) {
        this.quadrant = quadrant;
    }

    public int getNumOfRoots() {
        return numOfRoots;
    }

    public void setNumOfRoots(int numOfRoots) {
        this.numOfRoots = numOfRoots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    @Override
    public String getClassName() {
        return "tooth_label";
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
        String[] atributes = {"id","number", "quadrant", "numOfRoots", "description"};
        return atributes[i];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String idl = rs.getString("toothLabelID");
        int numberl= rs.getInt("number");
        int quadrantl = rs.getInt("quadrant");
        int numOfRootsl = rs.getInt("numOfRoots");
        String descriptionl = rs.getString("description");
        return new ToothLabel(idl, numberl, quadrantl, numOfRootsl, descriptionl);
    }

    @Override
    public String getWhereCondition() {
        return "toothLabelID='"+toothLabelID+"'";
    }

    @Override
    public String toString() {
        return number + "" + quadrant;
    }

}
