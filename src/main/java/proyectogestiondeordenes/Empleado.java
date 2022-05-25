package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empleado extends Persona {
    
    public Empleado(String rut, String nombre){
        this.rut = rut;
        this.nombre = nombre;
    }
    
    /*Setters*/
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     /*Getters*/
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }
    
}
