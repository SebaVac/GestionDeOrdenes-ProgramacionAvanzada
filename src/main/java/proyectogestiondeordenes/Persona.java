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
    
    public void paresEimpares(Persona persona){
        
        int aux=ordenes.size();  
        int cont=0;
        
        //Se evalua si el numero total de arreglos es par o impar
        if(aux % 2 == 0){
           
            String nombre2 = persona.getNombre();
            String rut2 = persona.getRut();
            System.out.println("");
            System.out.println("El cliente "+nombre2+" con rut "+rut2);
            System.out.println("Posee una cantidad de ordenes totales pares ");
            System.out.println("");
            
            cont=1+cont;
            
        }else{
        //Si el numero no es par, se entiende que es impar
            String nombre2 = persona.getNombre();
            String rut2 = persona.getRut();
            System.out.println("");
            System.out.println("El cliente "+nombre2+" con rut "+rut2);
            System.out.println("Posee una cantidad de ordenes totales impares ");
            System.out.println("");
            cont=1+cont;
        }
        //Se evalua con un contador si es que existen personas
        if(cont == 0){
        System.out.println("No existen usuarios que evaluar"); 
        }

    
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

    
    public void mostrarOrdenesPendientes(){
        Orden orden;
        String comp = "Pendiente";
        int cont=0;
        
        for (int i = 0; i < ordenes.size(); i++) {//se recorre la lista de ordenes y se muestran los datos
        orden = (Orden) ordenes.get(i);
            if(comp.equals(orden.getServicio())){
            cont=cont+1;
            }
        }
        System.out.println("");
        System.out.println("Se ecuentran "+cont+" ordenes pendientes");
        System.out.println("");
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
