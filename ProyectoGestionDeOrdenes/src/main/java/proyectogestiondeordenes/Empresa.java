
package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {
    
     /*Variables iniciales*/
    private int rut; //key del Hashmap
    private HashMap mapaOrdenes = new HashMap();
    private ArrayList<Orden> ordenes;
    

    /*Constructores*/
    public Empresa(int rut, HashMap mapaOrdenes) {
        this.rut = rut;
        this.mapaOrdenes = mapaOrdenes;
        ordenes = new ArrayList();
    }
    
    public Empresa(int rut, ArrayList aa){
        this.rut = rut;
        // libros = aa // esto esta MALO
        ordenes = new ArrayList();
        ordenes.addAll(aa);
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
    
    public void agregarOrdenes(Orden oo){
        ordenes.add(oo);
    }
    
    
}

