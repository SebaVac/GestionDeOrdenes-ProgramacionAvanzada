package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Persona {

    private String rut;
    private String nombre;
    private ArrayList ordenes;
    
    /*Constructor*/
    public Persona(String rut, String nombre, ArrayList ordenes) {
        this.rut = rut;
        this.nombre = nombre;
        this.ordenes = ordenes;
    }

    /*Setters*/
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrdenes(ArrayList ordenes) {
        this.ordenes = ordenes;
    }

    /*Getters*/
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList getOrdenes() {
        return ordenes;
    }

    /*Metodos*/
    public Orden agregarOrden(String rut,String servicio){
        Orden orden = null;
        
        orden.setRut(rut);
        orden.setServicio(servicio);
        
        return orden;
    }
    
    public void agregarOrden(Orden orden) {
        if (ordenes.add(orden)) {
            System.out.println("La orden se ha ingresado correctamente.");
        }
    }

    public boolean eliminarOrden(String servicio) {
        Orden orden = buscarOrden(servicio);
        return ordenes.remove(orden);
    }

    public Orden buscarOrden(String servicio) {
        Orden orden;
        for (int i = 0; i < ordenes.size(); i++) {
            orden = (Orden) ordenes.get(i);
            if (orden.getServicio().equals(servicio)) {
                return orden;
            }
        }
        return null;
    }

    public void mostrarOrdenes() {
        Orden orden;
        for (int i = 0; i < ordenes.size(); i++) {
            orden = (Orden) ordenes.get(i);
            System.out.println("Datos orden n°" + i + ":\n");
            System.out.println("Rut cliente: " + orden.getRut() + "\n");
            System.out.println("Servicio: " + orden.getServicio());
            System.out.println("     ----------     ");
        }
    }

    public Orden modificarOrden(Orden orden) throws IOException{
            String rutOrden;
            String rut;
            String servicio;
            rutOrden = (String) orden.getRut();
            
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            
            if(buscarOrden(rutOrden) == orden){
                
                System.out.println("Modificar Datos\n");
                System.out.println("Rut cliente: ");
                rut = teclado.readLine();
                orden.setRut(rut);
                
                System.out.println("\nServicio ofrecido: ");
                servicio = teclado.readLine();
                orden.setServicio(servicio);
                
                System.out.println("\nSe ha modificado correctamente.\n");

            }
            
        return orden;
    }

}
