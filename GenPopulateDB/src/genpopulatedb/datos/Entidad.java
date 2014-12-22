/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genpopulatedb.datos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daudth
 */
public class Entidad {

    private String catalogo;
    private String esquema;
    private String nombre;
    private String tipo;
    private boolean foranea;
    private List<Columna> columnas;

    public Entidad(String catalogo, String esquema, String nombre, String tipo, boolean foranea) {
        this.catalogo = catalogo;
        this.esquema = esquema;
        this.nombre = nombre;
        this.tipo = tipo;
        this.foranea = foranea;
        columnas = new ArrayList<Columna>();
    }
    
    public void addColumna(Columna columna){
         columnas.add(columna);
    }
    public void addColumnas(List<Columna> columnas){
         for (Columna columna : columnas) {
            this.columnas.add(columna);
        }
       
    }
    
    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isForanea() {
        return foranea;
    }

    public void setForanea(boolean foranea) {
        this.foranea = foranea;
    }
}
