package storage.database;

import domain.GeneralDObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BrokerDatabase {

//    public boolean insertRecord(GeneralDObject domainObject) throws SQLException {
//        StringBuilder sb = new StringBuilder();
//        sb.append("INSERT INTO ").append(domainObject.getClassName()).append(" VALUES(").append(domainObject.getAtrValue()).append(")");
//        String query = sb.toString();
//        System.out.println(query);
//        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
//        return statement.execute();
//    }
    public List<GeneralDObject> getAllRecord(GeneralDObject domainObject) throws SQLException {
        List<GeneralDObject> objects = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(domainObject.getClassName());
        String query = sb.toString();
        System.out.println(query);
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            objects.add(domainObject.getNewRecord(rs));
        }
        return objects;
    }

    public GeneralDObject findRecord(GeneralDObject odo) throws SQLException {
        ResultSet rs;
        Statement st;
        String query = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition();
        System.out.println(query);
        boolean signal;
        st = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        rs = st.executeQuery(query);
        signal = rs.next();
        if (signal == true) {
            odo = odo.getNewRecord(rs);
        } else {
            odo = null;
        }
        return odo;
    }

    public List<GeneralDObject> findRecords(GeneralDObject odo, GeneralDObject parent) throws SQLException {
        List<GeneralDObject> objects = new LinkedList<>();
        String query = "SELECT * FROM " + odo.getClassName() + " WHERE " + parent.getWhereCondition();
        System.out.println(query);
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            objects.add(odo.getNewRecord(rs));
        }
        return objects;
    }

    public boolean insertRecord(GeneralDObject odo) throws SQLException {
        String upit = "INSERT INTO " + odo.getClassName() + " VALUES (" + odo.getAtrValue() + ")";
        return executeUpdate(upit);
    }

    public boolean deleteRecord(GeneralDObject odo) throws SQLException {
        String upit = "DELETE FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit);
    }

    public boolean updateRecord(GeneralDObject odo, GeneralDObject odoold) throws SQLException {
        String upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue() + " WHERE " + odoold.getWhereCondition();
        return executeUpdate(upit);
    }

    public boolean updateRecord(GeneralDObject odo) throws SQLException {
        String upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue() + " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit);
    }

    public boolean executeUpdate(String upit) throws SQLException {
        Statement st;
        boolean signal = false;
        st = DatabaseConnection.getInstance().getConnection().prepareStatement(upit);
        int rowcount = st.executeUpdate(upit);
        if (rowcount > 0) {
            signal = true;
        }
        return signal;
    }

}
