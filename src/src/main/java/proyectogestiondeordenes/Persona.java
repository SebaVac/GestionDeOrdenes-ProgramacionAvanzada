package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Persona {

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

    /*Getters*/
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    /*Metodos*/
    
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
        for (int i = 0; i < ordenes.size(); i++) {//ciclo que recorre la lista de ordenes en busca de un servicio en especifico
            orden = (Orden) ordenes.get(i);
            if (orden.getServicio().equals(servicio)) {
                return orden;
            }
        }
        return null;//si no se encuentra la orden, se retorna null
    }
    
    public Orden buscarOrden(int index){
        
        Orden orden = ordenes.get(index); //se retorna el objeto "orden" que se encuentra en el lugar "i" del arreglo de ordenes
        
        return orden;
    }

    public void mostrarOrdenes(){
        Orden orden;
        int aux;
        for (int i = 0; i < ordenes.size(); i++) {//se recorre la lista de ordenes y se muestran los datos
            orden = (Orden) ordenes.get(i);
            aux = i+1;
            System.out.println("\nDatos orden n°" + aux + ":");
            System.out.println("Rut cliente: " + orden.getRut() + "");
            System.out.println("Servicio: " + orden.getServicio());
        }
    }

    public Orden modificarOrden(Orden orden) throws IOException{
        String servicio;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                
        System.out.println("Modificar Servicio");
        System.out.println("Servicio ofrecido: ");
        servicio = teclado.readLine();
        
        orden.setServicio(servicio);//se sobreescribe el servicio
        
        System.out.println("\nSe ha modificado correctamente.\n");
            
        return orden;
    }


}
