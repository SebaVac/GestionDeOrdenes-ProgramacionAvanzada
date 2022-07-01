package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class ProyectoGestionDeOrdenes {

    /**
     *
     * @param arg
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] arg) throws FileNotFoundException, IOException {
        int seleccion;
        BufferedReader usuario = new BufferedReader(new InputStreamReader(System.in));
        Empresa empresa = new Empresa();
        
        empresa.agregarDatosIniciales();
        
        //ciclo para ir manejando las distintas opciones del menu
        do {
            seleccion = MenuPrincipal.mostrarMenu(usuario);
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
                    empresa.mostrarPersona();
                    break;
                    
                case 9:
                    empresa.modificarPersona();
                    break;
                case 10:
                    empresa.mostrarClienteMasOrdenesTotales();
                    break;
                case 11:
                    empresa.mostrarEstadoDeServicio();
                    break;
                case 12:
                    return;
            }
        } while (seleccion !=13 );
    }
}
