
package proyectogestiondeordenes;

import java.util.*;

public class Empresa {
    
     /*Variables iniciales*/
    private int rut; //key del Hashmap
    private String nombre;
    private ArrayList<Orden> ordenes;
    

    /*Constructores*/
    public Empresa(int rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        ordenes = new ArrayList();
    }
    
    public Empresa(int rut, String nombre, ArrayList aa){
        this.rut = rut;
        this.nombre = nombre;
        // libros = aa // esto esta MALO
        ordenes = new ArrayList();
        ordenes.addAll(aa);
    }
    
    /*Setter*/
    public void setRut(int rut) {
        this.rut = rut;
    }
  
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /*Getter*/
    public int getRut() {
        return rut;
    }
    
    public void agregarOrden(Orden oo){
        ordenes.add(oo);
    }
    
    // SOBRECARGAS
    
    public void buscarOrden(int rut){
        System.out.println(rut);
    }
    
    public void buscarOrden(String nombre){
        System.out.println(nombre);
    }
    
    public void eliminarOrden(int rut){
        System.out.println(rut);
    }
    
    public void eliminarOrden(String nombre){
        System.out.println(nombre);
    }
    
}
