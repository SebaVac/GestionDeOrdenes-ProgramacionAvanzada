package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Persona extends Ver {

    private String rut;
    private String nombre;
    private ArrayList<Orden> ordenes;

    public Persona(String rut, String nombre) {
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

    /*Getters*/
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    /*Metodos*/
    
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

    public void mostrar() {
        Orden orden;
        int aux;
        for (int i = 0; i < ordenes.size(); i++) {
            orden = (Orden) ordenes.get(i);
            aux = i+1;
            System.out.println("\nDatos orden n°" + aux + ":");
            System.out.println("Rut cliente: " + orden.getRut() + "");
            System.out.println("Servicio: " + orden.getServicio());
        }
    }

    public Orden modificarOrden(Orden orden) throws IOException{
        String auxRut;
        String servicio;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                
        System.out.println("Modificar Datos");
        System.out.println("Rut cliente: ");
        auxRut = teclado.readLine();
        orden.setRut(auxRut);

        System.out.println("Servicio ofrecido: ");
        servicio = teclado.readLine();
        orden.setServicio(servicio);

        System.out.println("\nSe ha modificado correctamente.\n");
            
        return orden;
    }

}
