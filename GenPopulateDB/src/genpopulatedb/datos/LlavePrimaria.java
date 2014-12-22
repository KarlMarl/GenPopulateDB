/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genpopulatedb.datos;

import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 *
 * @author toshiba satelite
 */
public class LlavePrimaria extends Columna{
    private boolean autoIncrement;

    public LlavePrimaria(boolean autoIncrement,String nombre, int tipoDeDato, int tamamhoColumna, boolean nullable, int nroDigitosSignificativos, int nroPosicion) {
        super(nombre, tipoDeDato, tamamhoColumna, nullable, nroDigitosSignificativos, nroPosicion);
        this.autoIncrement = autoIncrement;
    }
     public LlavePrimaria(boolean autoIncrement,Columna columna) {
        super(columna.getNombre(), columna.getTipoDeDato(), columna.getTamamhoColumna(), columna.isNullable(),columna.getNroDigitosSignificativos(),columna.getNroPosicion());
        this.autoIncrement = autoIncrement;
    }



    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }
    
    
}
