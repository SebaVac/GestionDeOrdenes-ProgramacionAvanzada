package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empleado extends Persona {
    
    private ArrayList<Orden> ordenes;
    
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
    
    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
    
    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }
    
    
    /*Sobrecarga de metodos*/
    public Orden agregarOrden(String rut,String servicio){
        Orden orden = new Orden("rut","servicio");
        
        orden.setRut(rut);
        orden.setServicio(servicio);
        
        return orden;
    }
    
    public void agregarOrden(Orden orden) {
        this.ordenes.add(orden);
        System.out.println("\nLa orden se ha ingresado correctamente.\n");
    }

    public void eliminarOrden(String servicio) {
        Orden orden = buscarOrden(servicio);
        ordenes.remove(orden);
        System.out.println("\nLa orden se ha eliminado correctamente.\n");
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
        int aux;
        for (int i = 0; i < ordenes.size(); i++) {
            orden = (Orden) ordenes.get(i);
            aux = i+1;
            System.out.println("Datos orden n°" + aux + ":");
            System.out.println("Rut cliente: " + orden.getRut() + "");
            System.out.println("Servicio: " + orden.getServicio());
            System.out.println("\n");
        }
    }
   
    public Orden modificarOrden(Orden orden) throws IOException{
            String rutOrden;
            String auxRut;
            String servicio;
            rutOrden = orden.getRut();
            
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            
            if(buscarOrden(rutOrden) == orden){
                
                System.out.println("Modificar Datos");
                System.out.println("Rut cliente: ");
                auxRut = teclado.readLine();
                orden.setRut(auxRut);
                
                System.out.println("Servicio ofrecido: ");
                servicio = teclado.readLine();
                orden.setServicio(servicio);
                
                System.out.println("\nSe ha modificado correctamente.\n");
            }
            
        return orden;
    }
    
}
