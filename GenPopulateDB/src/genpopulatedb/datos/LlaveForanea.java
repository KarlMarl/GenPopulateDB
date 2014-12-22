/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genpopulatedb.datos;

/**
 *
 * @author toshiba satelite
 */
public class LlaveForanea extends Columna{
    private String nombreTabla;
    private String nombrePrimaryKey;

    public LlaveForanea(String nombreTabla, String nombrePrimaryKey, String nombre, int tipoDeDato, int tamamhoColumna, boolean nullable, int nroDigitosSignificativos, int nroPosicion) {
        super(nombre, tipoDeDato, tamamhoColumna, nullable, nroDigitosSignificativos, nroPosicion);
        this.nombreTabla = nombreTabla;
        this.nombrePrimaryKey = nombrePrimaryKey;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombrePrimaryKey() {
        return nombrePrimaryKey;
    }

    public void setNombrePrimaryKey(String nombrePrimaryKey) {
        this.nombrePrimaryKey = nombrePrimaryKey;
    }
    
   
    
    
    
}
