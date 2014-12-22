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
public class Columna {
    private String nombre;
    private int tipoDeDato;
    private int tamamhoColumna;
    private boolean nullable;
    private int nroDigitosSignificativos;
    private int nroPosicion;
    
    public Columna(String nombre, int tipoDeDato, int tamamhoColumna, boolean nullable, int nroDigitosSignificativos, int nroPosicion) {
        this.nombre = nombre;
        this.tipoDeDato = tipoDeDato;
        this.tamamhoColumna = tamamhoColumna;
        this.nullable = nullable;
        this.nroDigitosSignificativos = nroDigitosSignificativos;
        this.nroPosicion = nroPosicion;
    }
    
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(int tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }

    public int getTamamhoColumna() {
        return tamamhoColumna;
    }

    public void setTamamhoColumna(int tamamhoColumna) {
        this.tamamhoColumna = tamamhoColumna;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public int getNroDigitosSignificativos() {
        return nroDigitosSignificativos;
    }

    public void setNroDigitosSignificativos(int nroDigitosSignificativos) {
        this.nroDigitosSignificativos = nroDigitosSignificativos;
    }

    public int getNroPosicion() {
        return nroPosicion;
    }

    public void setNroPosicion(int nroPosicion) {
        this.nroPosicion = nroPosicion;
    }
    
}
