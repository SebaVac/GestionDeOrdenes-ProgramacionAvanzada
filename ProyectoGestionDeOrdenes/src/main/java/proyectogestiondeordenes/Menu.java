package proyectoremasterizado;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Menu{
     public void metodMenu(int opcion){
        Scanner input = new Scanner(System.in);
        Map<Integer,Orden> mapaOrdenes = new HashMap();
        
        Orden ordenNueva = new Orden("Nombre","Rut","Servicio");
       
        boolean exiting = false;
        while(!exiting){
            System.out.println("1. Ingresar Orden  .- ");
            System.out.println("2. Mostrar Ordenes .- ");
            System.out.println("3. Mostrar servicios .- ");
            System.out.println("9. Finalizar programa.  ");
                System.out.println("Elige una opción");
                String option = input.nextLine();
                opcion = Integer.parseInt(option);
                switch(opcion){
                    case 1: //agregar servicio
                        System.out.println("Ingrese su RUT: ");
                        String rut = input.nextLine();
                        System.out.println("Ingrese su Nombre: ");
                        String nombre = input.nextLine();
                        System.out.println("Indique el servicio: ");
                        String servicio = input.nextLine();
                        ordenNueva.agregarOrden(new Orden(nombre,rut,servicio));
                        break;
                        case 2:
                        System.out.println("Aquí se muestran las Ordenes guardadas : ");
                        ordenNueva.mostrarOrdenes();
                        break;  

            }
        }

     }
}