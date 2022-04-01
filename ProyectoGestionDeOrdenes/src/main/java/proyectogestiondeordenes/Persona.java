package proyectogestiondeordenes;

import java.io.*;

public class Persona {
    private String nombre;
    private String rut;
    private Orden[] listaOrdenes = new Orden[20];
    

    /*Constructores*/
    public Persona(String nombre, String rut, Orden[] listaOrdenes) {
        this.nombre = nombre;
        this.rut = rut;
        this.listaOrdenes = listaOrdenes;
    }
    
    /*Metodos*/
    /*Getter*/
    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public Orden[] getListaOrdenes() {
        return listaOrdenes;
    }

    /*Setter*/ 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setListaOrdenes(Orden[] listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    
}
