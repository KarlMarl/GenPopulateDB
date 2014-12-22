/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genpopulatedb.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 *
 * @author daudth
 */
public class PropConnexion {

    static String filename = "conn.properties";
    static String drivers = "drivers";
    public static PropConnexion instance;
    Properties properties;

    public static PropConnexion getInstance() {
        if (instance == null) {
            instance = new PropConnexion();
            instance.WritePropertiesFile();
        }

        return instance;
    }

    private PropConnexion() {
        properties = new Properties();
        properties.setProperty(drivers, "MySQL;PostgreSQL");
        properties.setProperty("MySQL","com.mysql.jdbc.Driver");
        properties.setProperty("PostgreSQL","org.postgresql.Driver");
        
    }

    public String[] getDrivers() {
        return properties.getProperty(drivers).split(";");
    }
     public String getDriverClass(String key) {
        return properties.getProperty(key);
        
    }

    public void WritePropertiesFile() {

        try {

            File file = new File(filename);
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Conexion");

            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ReadPropertiesFile() {
        try {
            File file = new File(filename);
            FileInputStream fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
