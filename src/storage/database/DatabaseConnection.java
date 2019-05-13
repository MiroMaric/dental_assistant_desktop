
package storage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utill.SettingsLoader;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;
    
    private DatabaseConnection() throws SQLException{
        String url = SettingsLoader.getInstance().getDatabaseProperty("url");
        String user = SettingsLoader.getInstance().getDatabaseProperty("user");
        String password = SettingsLoader.getInstance().getDatabaseProperty("password");
        connection = DriverManager.getConnection(url,user,password);
    }
    
    public static DatabaseConnection getInstance() throws SQLException{
        if(instance==null)
            instance = new DatabaseConnection();
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }

}
