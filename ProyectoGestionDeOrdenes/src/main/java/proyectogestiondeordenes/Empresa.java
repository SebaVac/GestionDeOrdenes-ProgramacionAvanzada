package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {

    /*Variables de instancia*/
    private HashMap personas;

    /*Constructor*/
    public Empresa(HashMap personas) {
        this.personas = personas;
    }

    /*Setters*/
    public void setPersonas(HashMap personas) {
        this.personas = personas;
    }

    /*Getters*/
    public HashMap getPersonas() {
        return personas;
    }

    /*Metodos*/
    public void agregarPersona() throws IOException{
        Persona persona = null;
        Orden orden = null;
        String nombre,rut,servicio;
        
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
        
        //personas.put(rut,persona);
        
    }
    
    public void agregarOrden(){
        
    }
    
    public void eliminarOrden(){
        
    }
    
    public void eliminarPersona(){
        
    }
    
    public void mostrarPersonas(){
        
    }
    
    public void mostrarOrdenes(){
        
    }
    
    public void buscarPersona(){
        
    }
    
    public void buscarOrden(){
        
    }
    
    public void modificarOrden(){
        
    }
    
    public void mostrarMenu(BufferedReader usuario) throws FileNotFoundException, IOException {
        String opcion;
        int seleccion;
        System.out.println("Menu\n");
        System.out.println("1.- Ingresar Datos Manualmente\n");
        System.out.println("2.- Ingresar nueva orden\n");
        System.out.println("3.- Eliminar Orden\n");
        System.out.println("4.- Eliminar Persona\n");
        System.out.println("5.- Buscar Orden\n");
        System.out.println("6.- Buscar Persona\n");
        System.out.println("7.- Mostrar Ordenes\n");
        System.out.println("8.- Mostrar Personas\n");
        System.out.println("9.- Salir");
        System.out.println("Ingresar opcion correspondiente:");
        do {
            opcion = usuario.readLine();
            seleccion = Integer.parseInt(opcion);
            if ((seleccion > 10) || (seleccion < 1)) {
                System.out.println("Opcion no valida, intente nuevamente: ");
            }
        } while ((seleccion > 10) || (seleccion < 1));

        switch(seleccion){
            case 1:
                agregarPersona();
                break;
                
            case 2:
                agregarOrden();
                break;
                
            case 3:
                eliminarOrden();
                break;
                
            case 4:
                eliminarPersona();
                break;
                
            case 5:
                buscarOrden();
                break;
                
            case 6:
                buscarPersona();
                break;
                
            case 7:
                mostrarOrdenes();
                break;
                
            case 8:
                mostrarPersonas();
                break;
                
        }
    }
}
