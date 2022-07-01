package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public interface Menu {
    
    /**
     *
     * @param usuario
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
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
        System.out.println("9.- Modificar Personas");
        System.out.println("10.- Mostrar Cliente con mayor cantidad de ordenes.");
        System.out.println("11.- Mostrar Estado de Servicios");
        System.out.println("12.- Salir");
        System.out.println("Ingresar opcion correspondiente:");
        do {
            opcion = usuario.readLine();
            seleccion = Integer.parseInt(opcion);
            if ((seleccion > 13) || (seleccion < 1)) {
                System.out.println("Opcion no valida, intente nuevamente: ");
            }
        } while ((seleccion > 13) || (seleccion < 1));
        return seleccion;
    }
    
}
