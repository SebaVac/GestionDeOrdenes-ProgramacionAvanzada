package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {

    /*Variables de instancia*/
    private HashMap <String, Empleado> empleados = new HashMap <> ();

    /*Setters*/
    public void setEmpleados(HashMap<String, Empleado> empleados) {
        this.empleados = empleados;
    }

    /*Getters*/
    public HashMap<String, Empleado> getEmpleados() {
        return empleados;
    }


    /*Metodos*/
    public void agregarEmpleado() throws IOException{
        Empleado empleado = new Empleado("rut","nombre");
        
        Orden orden = new Orden("rut","servicio");
        String nombre, rut, servicio;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese nombre de la empleado: ");
        nombre = teclado.readLine();
        empleado.setNombre(nombre);
        
        
        System.out.println("\nIngrese rut de la empleado: ");
        rut = teclado.readLine();
        empleado.setRut(rut);
        orden.setRut(rut);
        
        System.out.println("\nIngrese servicio ofrecido: ");
        servicio = teclado.readLine();
        orden.setServicio(servicio);
        
        empleado.agregarOrden(orden);
        
        empleados.put(rut,empleado);  
    }
    
    public void agregarOrden() throws IOException {
        
        String rut;
        Orden orden;
        String servicio;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese el rut del empleado(con puntos y guion): ");
        rut = teclado.readLine();
        
        Empleado empleado = empleados.get(rut);
        
        System.out.println("Ingresar nuevo servicio: ");
        servicio = teclado.readLine();
        
        orden = empleado.agregarOrden(rut, servicio);
        empleado.agregarOrden(orden);
    }
    
    
    public void mostrarEmpleados(){
        Empleado empleado;
        
        if(empleados != null){
            for(int i = 0;i < empleados.size();i++){
                empleado = empleados.get(i);
                System.out.println("Rut: " + empleado.getRut()+"\n");
                System.out.println("Nombre: "+empleado.getNombre()+"\n");
                System.out.println("Servicio(s):");
                empleado.mostrarOrdenes();
                System.out.println("\n");
            }
        }
    }
    
    public void mostrarEmpleado(Empleado empleado){
        String nombre = empleado.getNombre();
        String rut = empleado.getRut();
        
        System.out.println("Nombre:"+nombre+"\n");
        System.out.println("Rut:"+rut+"\n"); 
        empleado.mostrarOrdenes();  
    }
    
    public Empleado buscarEmpleado() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del empleado(con puntos y guion): ");
        String rut = teclado.readLine();
        return (Empleado) empleados.get(rut);
    }
    
    public void mostrarOrdenes (){
        /*empleados.forEach((key, value) -> System.out.println(key + " : " + value));*/
        System.out.println(empleados.values());
        System.out.println("aaaa");
        System.out.println(empleados.keySet());
       /*for (Map.Entry<String,Empleado> entry : empleados.entrySet()) {
		    System.out.println(entry.getKey()+" = "+entry.getValue());
                    
		}*/
    }
    public void eliminarOrden() throws IOException{
        Empleado empleado = buscarEmpleado();
        mostrarEmpleado(empleado);
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Ingrese el servicio que desea eliminar: ");
        String servicio = teclado.readLine();
        empleado.eliminarOrden(servicio);       
    }
   
    public void modificarOrden() throws IOException{
        Orden orden;
        Empleado empleado = buscarEmpleado();
        empleado.mostrarOrdenes();
        
        System.out.println("Ingrese el numero de la orden que desea modificar:");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String auxTeclado = teclado.readLine();
        int i = Integer.parseInt(auxTeclado);
        orden = empleado.modificarOrden((Orden)empleado.getOrdenes().get(i-1));
        empleado.getOrdenes().add(i, orden);
    }
    
    public void eliminarEmpleado() throws IOException{
        String rut;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresar rut del empleado(con puntos y guion): ");
        rut = teclado.readLine();
        empleados.remove(rut);
        System.out.println("Se ha eliminado correctamente");
    }


    public void rellenarEmpleados(String rut) throws IOException{
        CSV lineas = new CSV("Empresa.csv");
        String linea = lineas.firstLine();
        linea = lineas.nextLine();
        
        HashMap <String,Empleado> auxEmpleados = new HashMap();
        ArrayList <Orden> auxOrdenes = new ArrayList<>();
        
        while(linea != null){
        Empleado auxempleado = new Empleado("rut","nombre");
            
            if((lineas.get_csvField(linea, 1).equals(rut))){
                auxempleado.setRut(lineas.get_csvField(linea,0));
                auxempleado.setNombre(lineas.get_csvField(linea,2));
                ImportarCSV(auxOrdenes);
                auxempleado.setOrdenes(auxOrdenes);
                auxEmpleados.put(lineas.get_csvField(linea,0), auxempleado);
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
                ordenes.add(orden); // AÃ±ade la informacion a la lista
            }
            
            lineas.close(); // Cierra el archivo

        }
}