/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genpopulatedb.negocio;

import genpopulatedb.datos.Columna;
import genpopulatedb.datos.Entidad;
import genpopulatedb.datos.LlavePrimaria;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daudth
 */
public class ControllerEntidad {

    Conexion conexion;
    static ControllerEntidad instance;
    private List<Entidad> entidadsDisponibles;
    private ControllerEntidad(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<Entidad> getEntidadsDisponibles() {
        return entidadsDisponibles;
    }

    public void setEntidadsDisponibles(List<Entidad> entidadsDisponibles) {
        this.entidadsDisponibles = entidadsDisponibles;
    }
    
    public static ControllerEntidad getInstance(Conexion conexion) {
        if (instance == null) {
            instance = new ControllerEntidad(conexion);
        }
        return instance;
    }
    

    
    public List<Entidad> getEntidads() {
        List<Entidad> entidads = new ArrayList<Entidad>();
        try {
            DatabaseMetaData dmd = conexion.getConnection().getMetaData();
            
            ResultSet resultSet = dmd.getTables(null, null, "%", null);
            while (resultSet.next()) {
                Entidad entidad = new Entidad(resultSet.getString("TABLE_CAT"), resultSet.getString("TABLE_SCHEM"), resultSet.getString("TABLE_NAME"), resultSet.getString("TABLE_TYPE"), false);
               
                entidads.add(entidad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerEntidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidads;
    }
     public List<Columna> getColumns(String table) {
        List<Columna> columnas = new ArrayList<Columna>();
        try {
            DatabaseMetaData dmd = conexion.getConnection().getMetaData();
            
            ResultSet resultSet = dmd.getColumns(null, null, table, null);
            while (resultSet.next()) {
                Columna columna=new Columna(resultSet.getString("COLUMN_NAME"), resultSet.getInt("DATA_TYPE"), resultSet.getInt("COLUMN_SIZE"), resultSet.getInt("NULLABLE")==1, resultSet.getInt("DECIMAL_DIGITS"),resultSet.getInt("ORDINAL_POSITION"));
                ResultSet rset = dmd.getPrimaryKeys(table, table, table);
                String AUTO=resultSet.getString("IS_AUTOINCREMENT");
                LlavePrimaria column=new LlavePrimaria(AUTO!=null?AUTO.equals("YES"):false,columna);
                columnas.add(columna);
                
            }
            

        } catch (SQLException ex) {
            
        }
        return columnas;
    }
     public List<Columna> PrimaryKeys(String table) {
        List<Columna> columnas = new ArrayList<Columna>();
        try {
            DatabaseMetaData dmd = conexion.getConnection().getMetaData();
            
            ResultSet rset = dmd.getPrimaryKeys(null, null, table);
            while (rset.next()) {
                ResultSet resultSet = dmd.getColumns(null, null, table, rset.getString("COLUMN_NAME"));
                Columna columna=new Columna(resultSet.getString("COLUMN_NAME"), resultSet.getInt("DATA_TYPE"), resultSet.getInt("COLUMN_SIZE"), resultSet.getInt("NULLABLE")==1, resultSet.getInt("DECIMAL_DIGITS"),resultSet.getInt("ORDINAL_POSITION"));
                String AUTO=resultSet.getString("IS_AUTOINCREMENT");
                LlavePrimaria column=new LlavePrimaria(AUTO!=null?AUTO.equals("YES"):false,columna);
                columnas.add(column);
            }
            

        } catch (SQLException ex) {
            
        }
        return columnas;
    }
}
