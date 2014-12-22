/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genpopulatedb.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author daudth
 */
public class Conexion {

    private String driverClasName;
    private String dbms;
    private String host;
    private String port;
    private String db;
    private String user;
    private String pass;
    private String jdbc_url;
    private Connection connection;
    

    public String getDriverClasName() {
        return driverClasName;
    }

    public void setDriverClasName(String driverClasName) {
        this.driverClasName = driverClasName;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getJdbc_url() {
        return jdbc_url;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }
    
    public void setJdbc_url() {
        
        this.jdbc_url ="jdbc:"+dbms.toLowerCase()+"://"+host+":"+port+"/"+db;
    }
    
    public Connection setupConnection() {
        try {
            Class.forName(driverClasName);
            connection = DriverManager.getConnection(jdbc_url, user, pass);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }

    }
}
