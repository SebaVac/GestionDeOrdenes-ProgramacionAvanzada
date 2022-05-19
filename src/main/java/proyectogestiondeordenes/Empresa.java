package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa extends Ver{

    /*Variables de instancia*/
    private HashMap <String, Persona> personas = new HashMap <> ();

    /*Setters*/
    public void setPersonas(HashMap<String, Persona> personas) {
        this.personas = personas;
    }

    /*Getters*/
    public HashMap<String, Persona> getPersonas() {
        return personas;
    }


    /*Metodos*/
    public void agregarPersona() throws IOException{
        Persona persona = new Persona("rut","nombre");
        
        Orden orden = new Orden("rut","servicio");
        String nombre, rut, servicio;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre de la persona: ");
        nombre = teclado.readLine();
        persona.setNombre(nombre);
        
        
        System.out.println("\nIngrese rut de la persona: ");
        rut = teclado.readLine();
        persona.setRut(rut);
        orden.setRut(rut);
        
        System.out.println("\nIngrese servicio ofrecido: ");
        servicio = teclado.readLine();
        orden.setServicio(servicio);
        
        persona.agregarOrden(orden);
        
        personas.put(rut,persona);  
    }
    
    public void agregarOrden() throws IOException {
        
        String rut;
        Orden orden;
        String servicio;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese el rut del cliente(con puntos y guion): ");
        rut = teclado.readLine();
        
        Persona persona = personas.get(rut);
        
        System.out.println("Ingresar nuevo servicio: ");
        servicio = teclado.readLine();
        
        orden = persona.agregarOrden(rut, servicio);
        persona.agregarOrden(orden);
    }
    
    
    public void mostrar(){//mostrarPersonas
        Persona persona;
        
        if(personas != null){
            for(int i = 0;i < personas.size();i++){
                persona = personas.get(i);
                System.out.println("Rut: " + persona.getRut()+"\n");
                System.out.println("Nombre: "+persona.getNombre()+"\n");
                System.out.println("Servicio(s):");
                persona.mostrar();
                System.out.println("\n");
            }
        }
    }
    
    public void mostrarPersona(Persona persona){
        String nombre = persona.getNombre();
        String rut = persona.getRut();
        
        System.out.println("Nombre:"+nombre+"\n");
        System.out.println("Rut:"+rut+"\n"); 
        persona.mostrar();  
    }
    
    public void mostrarOrdenes() throws IOException{
        Persona persona = buscarPersona();
  
        persona.mostrar();
    }
    
    
    public Persona buscarPersona() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del cliente(con puntos y guion): ");
        String rut = teclado.readLine();
        return (Persona) personas.get(rut);
    }
    
    public void eliminarOrden() throws IOException{
        Persona persona = buscarPersona();
        mostrarPersona(persona);
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese el servicio que desea eliminar: ");
        String servicio = teclado.readLine();
        persona.eliminarOrden(servicio);       
    }
   
    public void modificarOrden() throws IOException{
        Orden orden;
        Persona persona = buscarPersona();
        persona.mostrar();
        
        System.out.println("Ingrese el numero de la orden que desea modificar:");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String auxTeclado = teclado.readLine();
        int i = Integer.parseInt(auxTeclado);
        orden = persona.modificarOrden((Orden)persona.getOrdenes().get(i-1));
        persona.getOrdenes().add(i, orden);
    }
    
    public void eliminarPersona() throws IOException{
        String rut;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresar rut del cliente(con puntos y guion): ");
        rut = teclado.readLine();
        personas.remove(rut);
        System.out.println("Se ha eliminado correctamente");
    }
}

