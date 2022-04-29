package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {

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
    
    public void eliminarPersona() throws IOException{
        Persona persona;
        String rut;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingresar rut del cliente(con puntos y guion): ");
        rut = teclado.readLine();
        
        persona = buscarPersona();
    }
    
    public void mostrarPersonas(){
        Persona persona;
        
        if(personas != null){
            for(int i = 0;i < personas.size();i++){
                persona = personas.get(i);
                System.out.println("Rut: " + persona.getRut()+"\n");
                System.out.println("Nombre: "+persona.getNombre()+"\n");
                System.out.println("Servicio(s):");
                persona.mostrarOrdenes();
                System.out.println("\n");
            }
        }
    }
    
    public void mostrarPersona(Persona persona){
        String nombre = persona.getNombre();
        String rut = persona.getRut();
        
        System.out.println("Nombre:"+nombre+"\n");
        System.out.println("Rut:"+rut+"\n"); 
        persona.mostrarOrdenes();  
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
        persona.mostrarOrdenes();
        
        System.out.println("Ingrese el numero de la orden que desea modificar:");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String auxTeclado = teclado.readLine();
        int i = Integer.parseInt(auxTeclado);
        orden = persona.modificarOrden((Orden)persona.getOrdenes().get(i-1));
        persona.getOrdenes().add(i, orden);
    }
    
    
    
    public void mostrarMenu(BufferedReader usuario) throws FileNotFoundException, IOException {
        Empresa empresa = new Empresa();
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
                empresa.agregarPersona();
                break;
                
            case 2:
                empresa.agregarOrden();
                break;
                
            case 3:
                //eliminarOrden();
                break;
                
            case 4:
                eliminarPersona();
                break;
                
            case 5:
                //buscarOrden();
                break;
                
            case 6:
                //buscarPersona();
                break;
                
            case 7:
                //mostrarOrdenes();
                break;
                
            case 8:
                mostrarPersonas();
                break;
                
        }
    }

    public void rellenarPersonas(String rut) throws IOException{
        CSV lineas = new CSV("Empresa.csv");
        String linea = lineas.firstLine();
        linea = lineas.nextLine();
        
        HashMap <String,Persona> auxPersonas = new HashMap();
        ArrayList <Orden> auxOrdenes = new ArrayList<>();
        
        while(linea != null){
        Persona auxpersona = new Persona("rut","nombre");
            
            if((lineas.get_csvField(linea, 1).equals(rut))){
                auxpersona.setRut(lineas.get_csvField(linea,0));
                auxpersona.setNombre(lineas.get_csvField(linea,2));
                ImportarCSV(auxOrdenes);
                auxpersona.setOrdenes(auxOrdenes);
                auxPersonas.put(lineas.get_csvField(linea,0), auxpersona);
            }
        }
    }
    
        public static void ImportarCSV(ArrayList<Orden> ordenes) throws IOException {
            
            CSV lineas = new CSV("Empresa.csv");
            String linea = lineas.firstLine();
            linea = lineas.nextLine();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(linea != null) {
                String rut = lineas.get_csvField(linea,1);
                String servicio = lineas.get_csvField(linea,2);
                
                Orden orden = new Orden("rut","servicio");
                orden.setRut(rut);
                orden.setServicio(servicio);
                ordenes.add(orden); // Añade la informacion a la lista
            }
            
            lineas.close(); // Cierra el archivo

        }
}
