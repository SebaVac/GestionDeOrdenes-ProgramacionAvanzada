package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {

    /*Variables de instancia*/
    private HashMap <String, Persona> personas = new HashMap <> ();
    private ArrayList <Persona> listaPersonas = new ArrayList <> ();

    /*Metodos*/
    //metodos relacionados con la persona/cliente
    public void agregarPersona() throws IOException{
        Persona persona = new Persona("rut","nombre");
        
        Orden orden = new Orden("rut","servicio");
        String nombre, rut;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        //Se ingresan los datos por teclado
        System.out.println("Ingrese nombre de la persona: ");
        nombre = teclado.readLine();
        persona.setNombre(nombre);

        //ciclo para validar el rut de una persona
        do{
            System.out.println("\nIngrese rut de la persona(con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if(rut.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }else{
                persona.setRut(rut);
                orden.setRut(rut); 
            }
        }while(rut.length() != 12);
        
        //se ingresa servicio
        orden.setServicio(ingresarServicio());
        
        persona.agregarOrden(orden);
        personas.put(rut,persona);
        listaPersonas.add(persona);
    }
    
    public void mostrarPersonas(){//En proceso
        Persona persona;
        
        if(personas != null){
            for(int i = 0;i < listaPersonas.size();i++){
                persona = listaPersonas.get(i);
                mostrarPersona(persona);
                System.out.println();
            }
        }
    }
    
    public void mostrarPersona(Persona persona){//En proceso
        String nombre = persona.getNombre();
        String rut = persona.getRut();
        
        System.out.println("Nombre:"+nombre);
        System.out.println("Rut:"+rut); 
        persona.mostrarOrdenes();  
    }
    
    public Persona buscarPersona() throws IOException{
        //se ingresa un rut por teclado y se retorna el objeto "Persona" que se encuentra en la coleccion de personas
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del cliente(con puntos y guion): ");
        String rut = teclado.readLine();
        
        return (Persona) personas.get(rut);
    }
   
    public void eliminarPersona() throws IOException{
        String rut;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingresar rut del cliente(con puntos y guion): ");
        rut = teclado.readLine();
        
        personas.remove(rut);//se elimina la persona de el mapa
        System.out.println("Se ha eliminado correctamente");
    }
    
    //metodos relacionados con las ordenes
    public void agregarOrden() throws IOException {
        
        String rut;
        Orden orden;
        String servicio;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        do{
            System.out.println("\nIngrese rut de la persona(con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if(rut.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }
        }while(rut.length() != 12);
        
        Persona persona = personas.get(rut);//se obtiene el objeto con clave "rut" del mapa de personas
        

        System.out.println("Ingresar nuevo servicio: ");
        servicio = teclado.readLine();
        
        //Modificacion del servicio
        orden = persona.agregarOrden(rut, servicio);
        persona.agregarOrden(orden);
    }
    
    public void mostrarOrdenes() throws IOException{
        Persona persona;
        
        do{//Se valida si la persona existe o "no es nulo"
            persona = buscarPersona();        
            if(persona == null){
                System.out.println("Rut no encontrado, ingrese nuevamente");
            }else{
                persona.mostrarOrdenes();
                break;
            }

        }while(persona != null);
    }
    
    public void eliminarOrden() throws IOException{//en proceso
        
        Persona persona = buscarPersona();
        mostrarPersona(persona);
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese el servicio que desea eliminar: ");
        String servicio = teclado.readLine();
        persona.eliminarOrden(servicio);       
    }
   
    public void modificarOrden() throws IOException{
        //inicializacion de variables
        Orden orden;
        Persona persona = buscarPersona();
        persona.mostrarOrdenes();
        
        System.out.println("Ingrese el numero de la orden que desea modificar:");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        String auxTeclado = teclado.readLine();
        int i = Integer.parseInt(auxTeclado);
        
        i=i-1;//se adapta el valor de i para que este en la escala de un arreglo
        
        //se obtiene y modifica la orden
        orden = persona.buscarOrden(i);
        persona.modificarOrden(orden);
    }
    
    //metodos relacionados con el servicio
    public String ingresarServicio() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String servicio,convertir;
        int eleccion;
        
        System.out.println("¿Ingresar Servicio?");
       do{
            System.out.println("1.- Si");
            System.out.println("2.- No");
            convertir = teclado.readLine();
            eleccion = Integer.parseInt(convertir);
            
            //Validacion
            if((eleccion != 1) && (eleccion != 2)){
                System.out.println("Eleccion no valida, intente nuevamente");
            }
       }while((eleccion != 1) && (eleccion != 2));
        
        if(eleccion == 1){
        //se ingresa por teclado el servicio que requirio la persona
        System.out.println("\nIngrese servicio ofrecido: ");
        servicio = teclado.readLine(); 
        
        return servicio;
        }
        
        return "Pendiente";
    }
}

