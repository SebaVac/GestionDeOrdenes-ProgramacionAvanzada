package proyectogestiondeordenes;

import java.io.*;
import java.util.*;
   
public class ProyectoGestionDeOrdenes {

    public static void main (String[] arg) throws FileNotFoundException, IOException {
    
        String opcion;
        int seleccion;
        BufferedReader usuario = new BufferedReader(new InputStreamReader(System.in));
        
    /*Menu de opciones*/
    System.out.println("Menu\n");
    System.out.println("1.- Ingresar Archivo\n");
    System.out.println("2.- Eliminar Orden\n");
    System.out.println("3.- Buscar Orden\n");
    System.out.println("4.- Mostrar Ordenes\n");
    System.out.println("Ingresar opcion correspondiente:");
    
    /*se verifica que la opcion sea valida*/
    do{
        opcion = usuario.readLine();
        seleccion = Integer.parseInt(opcion);
        if((seleccion > 5) || (seleccion < 1)){
            System.out.println("Opcion no valida, intente nuevamente: ");
        }
    }while((seleccion > 5) || (seleccion < 1));
    
    /*se llama la funcion segun corresponda*/
    switch(seleccion){
        case 1:
            System.out.println("Ingresar nombre del archivo: ");
            
            break;
            
        case 2:
            //funcion que tiene como parametro el rut y el identificador para buscar la orden a eliminar
            break;
            
        case 3:
            System.out.println("Ingresar Rut de la persona");
            opcion = usuario.readLine();
            //funcion que tiene como parametro el rut de la persona y busca la orden correspondiente
            break;
            
        case 4:
            //Se muestran TODAS las ordenes
            break;
    }
    
    }
}

