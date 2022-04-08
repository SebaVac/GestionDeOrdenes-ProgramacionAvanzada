package proyectogestiondeordenes;

import java.io.*;
import java.util.*;
   
public class ProyectoGestionDeOrdenes {

    public static void main (String[] arg) throws FileNotFoundException, IOException {
        
        int seleccion;
        BufferedReader usuario = new BufferedReader(new InputStreamReader(System.in));
        
    /*Menu de opciones*/
    do{
        seleccion = mostrarMenu(usuario);

    switch(seleccion){
        case 1:
           
            break;
            
        case 2:
            System.out.println("Ingresar nombre del archivo: ");
            break;
            
        case 3:
            //funcion que tiene como parametro el rut y el identificador para buscar la orden a eliminar
            break;
            
        case 4:
            System.out.println("Ingresar Rut de la persona");
            //opcion = usuario.readLine();
            //funcion que tiene como parametro el rut de la persona y busca la orden correspondiente
            break;
          
       case 5:
          //Se muestran TODAS las ordenes
          break;
    }
    
    }while(seleccion != 6);
    
    }
    
    /*
    *   FUNCIONES
    */
    
    public static int mostrarMenu(BufferedReader usuario) throws FileNotFoundException, IOException {
        
        String opcion;
        int seleccion;
        
        System.out.println("Menu\n");
        System.out.println("1.- Ingresar Datos Manualmente\n");
        System.out.println("2.- Ingresar Archivo\n");
        System.out.println("3.- Eliminar Orden\n");
        System.out.println("4.- Buscar Orden\n");
        System.out.println("5.- Mostrar Ordenes\n");
        System.out.println("6.- Salir");
        System.out.println("Ingresar opcion correspondiente:");

    /*se verifica que la opcion sea valida*/
    do{
        opcion = usuario.readLine();
        seleccion = Integer.parseInt(opcion);
        if((seleccion > 7) || (seleccion < 1)){
            System.out.println("Opcion no valida, intente nuevamente: ");
        }
    }while((seleccion > 7) || (seleccion < 1));
    
    return seleccion;
    
    }

    
    @SuppressWarnings("null")
    public static void agregarPersona(BufferedReader usuario) throws FileNotFoundException, IOException{
        
        Orden orden = null;
        Persona persona = null;
        
        String nombreUsuario;
        int rutUsuario;
        String servicio;

        String opcion;
        
        System.out.println("Ingresar Nombre del usuario: ");
        nombreUsuario = usuario.readLine();
        
        /*se ingresan a las clases*/
        orden.setNombre(nombreUsuario);
        persona.setNombre(nombreUsuario);

        System.out.println("\nIngresar Rut del usuario(sin puntos ni digito verificador): ");
        opcion = usuario.readLine();
        rutUsuario = Integer.parseInt(opcion);
        
        /*se ingresan a las clases*/
        orden.setRut(rutUsuario);
        persona.setRut(rutUsuario);

        System.out.println("\nIngresar Servicio: ");
        servicio = usuario.readLine();
        
        /*se ingresa a la clase orden*/
        orden.setServicio(servicio);
        
        /*agregar al mapa*/
        
        
    }
}
