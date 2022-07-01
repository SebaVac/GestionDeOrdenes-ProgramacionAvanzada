package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Empleado extends Persona {
    
    /**
     *
     * @param rut
     * @param nombre
     */
    public Empleado(String rut, String nombre){
        setRut(rut);
        setNombre(nombre);
    }
    
    /*Setters*/

    /**
     *
     * @param rut
     */

    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     /*Getters*/

    /**
     *
     * @return
     */

    public String getRut() {
        return rut;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }
        /**
     *
     * @param rut
     * @return
     * @throws IOException
     */
    public Empleado agregarNombreEmpleado(String rut) throws IOException{
        Empleado empleado = new Empleado("rut","nombre");
        
        String nombre;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
         //Se ingresan los datos por teclado
        System.out.println("Ingrese nombre de la cliente: ");
        nombre = teclado.readLine();
        empleado.setNombre(nombre);
        
        return empleado;
    }
    
    /**
     *
     * @param empleado
     */
    public void agregarNombreEmpleado(Empleado empleado){
        System.out.println("El empleado se ha ingresado correctamente.");
    }
    
    //mostrar

    /**
     *
     */
    public void mostrarEmpleado(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Rut: "+this.rut);
    }
}
        