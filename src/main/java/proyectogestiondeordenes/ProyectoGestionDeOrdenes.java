package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class ProyectoGestionDeOrdenes {

    public static void main(String[] arg) throws FileNotFoundException, IOException {
        int seleccion;
        BufferedReader usuario = new BufferedReader(new InputStreamReader(System.in));
        Empresa empresa = new Empresa();
        do {
            seleccion = mostrarMenu(usuario);
            switch(seleccion) {
                case 1:
                        empresa.agregarCliente();
                    break;
                case 2:
                     /* nose que decia */
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
                    empresa.eliminarCliente();
                    break;
            }
        } while (seleccion !=8 );
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
        System.out.println("8.- Salir");
        System.out.println("Ingresar opcion correspondiente:");
        do {
            opcion = usuario.readLine();
            seleccion = Integer.parseInt(opcion);
            if ((seleccion > 6) || (seleccion < 1)) {
                System.out.println("Opcion no valida, intente nuevamente: ");
            }
        } while ((seleccion > 6) || (seleccion < 1));
        return seleccion;
    }
    

    

        /*public void ingresar() throws FileNotFoundException, IOException {
        CSV lineas = new CSV("Regiones");
        String linea = lineas.firstLine();
        linea = lineas.nextLine();
        while (linea != null) {
            Regiones auxRegion = new Regiones();
            for (int i = 0; i < 2; i++) {
                switch (i) {
                    case 0: {
                        auxRegion.setNombreRegion(lineas.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        auxRegion.setNumeroRegion(lineas.get_csvField(linea, i));
                        break;
                    }
                }
            }
            String nombreRegion = auxRegion.getNombreRegion();
            RellenarSucursales(auxRegion, nombreRegion);
            Regiones.add(auxRegion);
            linea = lineas.nextLine();
            if (linea == null){
                    break;
            }
        }
    }

    public void RellenarSucursales(Regiones auxRegion,String nombreRegion) throws FileNotFoundException, IOException{
        CSV lineas = new CSV ("Sucursales");
        String linea = lineas.firstLine();
        linea = lineas.nextLine();
        ArrayList<Sucursal> auxSucursales = new ArrayList();
        while(linea != null){
            Sucursal auxSucursal = new Sucursal();
            if((lineas.get_csvField(linea, 2)).equals(nombreRegion)){
                auxSucursal.setComuna(lineas.get_csvField(linea, 1));
                auxSucursal.setDireccion(lineas.get_csvField(linea, 0));
                RellenarPersonasSucursal(auxSucursal,lineas.get_csvField(linea, 1));
                auxSucursales.add(auxSucursal);
            }
            linea = lineas.nextLine();
            if(linea == null){
                break;
            }
        }
        auxRegion.setSucursales(auxSucursales);
    }
    
    public void RellenarPersonasSucursal(Sucursal auxSucursal, String comuna) throws IOException{
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
}
