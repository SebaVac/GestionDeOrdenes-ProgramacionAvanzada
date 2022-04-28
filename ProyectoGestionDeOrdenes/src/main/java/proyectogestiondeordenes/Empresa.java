package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {

    /*Variables de instancia*/
    private HashMap <String, Persona> personas = new HashMap <String, Persona> ();

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
        Persona persona = new Persona();
        Orden orden = new Orden();
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
        
        personas.put(rut,persona);  
    }
    
    public void agregarOrden(String rut) throws IOException {
        
        Persona persona = personas.get(rut);
        Orden orden;
        String servicio;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingresar nuevo servicio: ");
        servicio = teclado.readLine();
        
        orden = persona.agregarOrden(rut, servicio);
        persona.agregarOrden(orden);
    }
    
    public void eliminarPersona(){
        
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
    
    public Persona buscarPersona(String rut){
        return (Persona) personas.get(rut);
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
                //agregarOrden();
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

    public void rellenarOrdenesPersonas(Persona auxPersona, String rut) throws IOException{
        CSV lineas = new CSV("Persona");
        String linea = lineas.firstLine();
        linea = lineas.nextLine();
        
        HashMap <String,Persona> auxPersonas = new HashMap();
        ArrayList <Orden> auxOrdenes = new ArrayList();
        
        while(linea != null){
            Persona auxpersona = new Persona();
            
            if((lineas.get_csvField(linea, 1).equals(rut))){
                auxpersona.setRut(lineas.get_csvField(linea,0));
                System.out.println("Rut: "+lineas.get_csvField(linea,1));
                auxpersona.setNombre(lineas.get_csvField(linea,2));
                ImportarCSV();
                
                auxPersonas.put(lineas.get_csvField(linea,0), auxpersona);
            }
        }
    }
    
        public static void ImportarCSV() {
        try{
            ArrayList<Orden> ordenes = new ArrayList(); // Lista donde guardaremos los datos del archivo
            
            CSV lineas = new CSV("Usuarios.csv");
            String linea = lineas.firstLine();
            linea = lineas.nextLine();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(linea != null) {
                String rut = lineas.get_csvField(linea,1);
                String servicio = lineas.get_csvField(linea,2);
                
                ordenes.add(new Orden(rut,servicio)); // Añade la informacion a la lista
            }
            
            lineas.close(); // Cierra el archivo

            
            }catch(FileNotFoundException e) {
            }catch(IOException e) {
            }
        }
}
    /*public void RellenarPersonasSucursal(Sucursal auxSucursal, String comuna) throws IOException{
        CSV lineas = new CSV ("Persona");
        String linea = lineas.firstLine();
        linea = lineas.nextLine();
        HashMap<String,Persona> auxPersonas = new HashMap();
        while (linea != null) {
            Persona auxPersona = new Persona();
            if ((lineas.get_csvField(linea, 1).equals(comuna))) {
                auxPersona.setNombre(lineas.get_csvField(linea, 0));
                System.out.println("Apellido:" + lineas.get_csvField(linea, 3));
                auxPersona.setApellido(lineas.get_csvField(linea, 1));
                auxPersona.setComuna(lineas.get_csvField(linea, 2));
                auxPersona.setRut(lineas.get_csvField(linea, 3));
                auxPersonas.put(lineas.get_csvField(linea,3),auxPersona);
            }
            linea = lineas.nextLine();
            if (linea == null) {
                break;
            }
        }
        auxSucursal.setPersonas(auxPersonas);
    }*/
