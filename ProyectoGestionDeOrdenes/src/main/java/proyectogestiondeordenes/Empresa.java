
package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {
    /*Variables iniciales*/
    private int rut; //key del Hashmap
    private HashMap mapaOrdenes = new HashMap();

    /*Constructores*/
    public Empresa(int rut, HashMap mapaOrdenes) {
        this.rut = rut;
        this.mapaOrdenes = mapaOrdenes;
    }
    

    //Metodos
    
    /*Setter*/
    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setMapaOrdenes(HashMap mapaOrdenes) {
        this.mapaOrdenes = mapaOrdenes;
    }


    /*Getter*/
    public int getRut() {
        return rut;
    }

    public HashMap getMapaOrdenes() {
        return mapaOrdenes;
    }
}
