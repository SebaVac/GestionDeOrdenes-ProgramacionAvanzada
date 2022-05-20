package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class ProyectoGestionDeOrdenes {

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        int seleccion;
        BufferedReader usuario = new BufferedReader(new InputStreamReader(System.in));
        Empresa empresa = new Empresa();
        
        //ciclo para ir manejando las distintas opciones del menu
        do {
            seleccion = mostrarMenu(usuario);
            switch(seleccion) {
                case 1:
                    empresa.agregarPersona();
                    break;
                case 2:
                    
                    break;
                case 3:
                    empresa.agregarOrden();
                    break;
                case 4:
                    empresa.eliminarOrden();
                    break;
                case 5:
                    empresa.mostrarOrdenes();
                    break;
                case 6:
                    empresa.modificarOrden();
                    break;
                case 7:
                    empresa.eliminarPersona();
                    break;
                case 8:
                    empresa.mostrarPersonas();
                    break;
                case 9:
                    empresa.mostrarParesImpares();
                    break;
                case 10:
                    empresa.mostrarEstadoDeServicio();
                    break;
                case 11:
                    return;
            }
        } while (seleccion !=12 );
    }

    public static int mostrarMenu(BufferedReader usuario) throws FileNotFoundException, IOException {
        String opcion;
        int seleccion;
        System.out.println("    Menu\n");
        System.out.println("1.- Ingresar Persona Manualmente");
        System.out.println("2.- Ingresar Archivo");
        System.out.println("3.- Agregar Orden");
        System.out.println("4.- Eliminar Orden");
        System.out.println("5.- Mostrar Ordenes");
        System.out.println("6.- Modificar Orden");
        System.out.println("7.- Eliminar Persona");
        System.out.println("8.- Mostrar Personas");
        System.out.println("9.- Mostrar si el numero total de ordenes es par/impar");
        System.out.println("10.- Mostrar estado de servicios");
        System.out.println("11.- Salir");
        System.out.println("Ingresar opcion correspondiente:");
        do {
            opcion = usuario.readLine();
            seleccion = Integer.parseInt(opcion);
            if ((seleccion > 12) || (seleccion < 1)) {
                System.out.println("Opcion no valida, intente nuevamente: ");
            }
        } while ((seleccion > 12) || (seleccion < 1));
        return seleccion;
    }
}