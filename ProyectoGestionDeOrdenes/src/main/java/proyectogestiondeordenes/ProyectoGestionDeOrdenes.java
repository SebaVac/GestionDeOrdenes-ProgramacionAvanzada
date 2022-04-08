package proyectogestiondeordenes;

import java.io.*;
import java.util.*;
   
public class ProyectoGestionDeOrdenes {

    public static void main (String[] arg) throws FileNotFoundException, IOException {
        
        int seleccion;
        Empresa empresa = null;
        
    /*Menu de opciones*/
    do{
        seleccion = mostrarMenu();
    /*se llama la funcion segun corresponda*/
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
    
    public static int mostrarMenu() throws FileNotFoundException, IOException {
        
        String opcion;
        int seleccion;
        BufferedReader usuario = new BufferedReader(new InputStreamReader(System.in));
        
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

}

