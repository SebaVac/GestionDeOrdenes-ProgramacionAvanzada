package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Cliente extends Persona {

    private ArrayList<Orden> ordenes;

    public Cliente(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.ordenes = new ArrayList<>();
    }
    
    /*Setters*/
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
    
    
}
