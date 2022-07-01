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
    
    public Empleado agregarEmpleado(String rut) throws IOException{
        Empleado empleado = new Empleado("rut","nombre");
        
        String nombre;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        //ciclo para validar el rut de una cliente

        
        //Se ingresan los datos por teclado
        System.out.println("Ingrese nombre de la cliente: ");
        nombre = teclado.readLine();
        empleado.setNombre(nombre);
        
        return empleado;
    }
    
    //mostrar
    public void mostrarEmpleado(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Rut: "+this.rut);
    }
}
