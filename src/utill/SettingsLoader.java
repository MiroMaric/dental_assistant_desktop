package utill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SettingsLoader {
    
    private static SettingsLoader instance;
    private Properties databaseProperties;
    private Properties scheduleProperties;
    
    private SettingsLoader() {
        loadProperties();
    }
    
    public static SettingsLoader getInstance(){
        if(instance==null)
            instance = new SettingsLoader();
        return instance;
    }

    private void loadProperties() {
        try {
            databaseProperties = new Properties();
            scheduleProperties = new Properties();
            databaseProperties.load(new FileReader(new File("database.properties")));
            scheduleProperties.load(new FileReader(new File("schedule.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDatabaseProperty(String key){
        return databaseProperties.getProperty(key,"n/a");
    }
    public String getScheduleProperty(String key){
        return scheduleProperties.getProperty(key,"n/a");
    }
    
    public int getStartTime(){
        return Integer.parseInt(scheduleProperties.getProperty("start_time"));
    }
    
    public int getEndTime(){
        return Integer.parseInt(scheduleProperties.getProperty("end_time"));
    }
    
    public void setScheduleProperty(String key, String value) {
        scheduleProperties.setProperty(key, value);
        try {
            scheduleProperties.store(new PrintWriter(new File("schedule.properties")), "komentar");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
