package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class Empresa {

    /*Variables de instancia*/
    private HashMap <String, Cliente> clientes = new HashMap <> ();
    private ArrayList <Cliente> listaClientes = new ArrayList <> ();

    /*Metodos*/
    
    //ingresar datos iniciales
    public void agregarDatosIniciales(){
        Cliente cliente1 = new Cliente("20.980.419-0","Sebastian Saavedra");
        Orden orden1 = new Orden("20.980.419-0","Pendiente");
        
        cliente1.agregarOrden(orden1);
        clientes.put(cliente1.getRut(),cliente1);
        listaClientes.add(cliente1);
        
        Cliente cliente2 = new Cliente("20.906.578-9","Acdiel Bombin");
        Orden orden2 = new Orden("20.906.578-9","Arreglo de pantalla");

        
        cliente2.agregarOrden(orden2);
        clientes.put(cliente2.getRut(),cliente2);
        listaClientes.add(cliente2);
        
        Cliente cliente3 = new Cliente("20.844.578-2","Matias Gallardo");
        Orden orden3 = new Orden("20.844.578-2","Instalacion de software");
  
        cliente3.agregarOrden(orden3);
        clientes.put(cliente3.getRut(),cliente3);
        listaClientes.add(cliente3);
    }
    
    //metodos relacionados con la cliente/cliente
    public void agregarCliente() throws IOException{
        Cliente cliente = new Cliente("rut","nombre");
        
        Orden orden = new Orden("rut","servicio");
        String nombre, rut;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        //Se ingresan los datos por teclado
        System.out.println("Ingrese nombre de la cliente: ");
        nombre = teclado.readLine();
        cliente.setNombre(nombre);

        //ciclo para validar el rut de una cliente
        do{
            System.out.println("\nIngrese rut de la cliente(con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if(rut.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }else{
                cliente.setRut(rut);
                orden.setRut(rut); 
            }
        }while(rut.length() != 12);
        
        //se ingresa servicio
        orden.setServicio(ingresarServicio());
        cliente.agregarOrden(orden);
        clientes.put(rut,cliente);
        listaClientes.add(cliente);
    }
    //SobrecargaMostrarCliente
    public void mostrarClientes(){
        Cliente cliente;
        
        if(clientes != null){
            for(int i = 0;i < listaClientes.size();i++){
                cliente = listaClientes.get(i);
                mostrarCliente(cliente);
                System.out.println("    ----------  ");
            }
        }
    }
    public void mostrarParesImpares()throws IOException{
        Cliente cliente;
        if(clientes != null){
            for(int i = 0;i < listaClientes.size();i++){
                cliente = listaClientes.get(i);
                cliente.paresEimpares(cliente);
            }
        }
    }
     
    
    public void mostrarEstadoDeServicio() throws IOException{
            Cliente cliente;
        
        do{//Se valida si la cliente existe o "no es nulo"
            cliente = buscarCliente();        
            if(cliente == null){
                System.out.println("Rut no encontrado, ingrese nuevamente");
            }else{
                cliente.mostrarOrdenesPendientes();
                break;
            }

        }while(cliente != null);
    
    }
    
    public void mostrarCliente(Cliente cliente){
        String nombre = cliente.getNombre();
        String rut = cliente.getRut();
        System.out.println("Nombre:"+nombre);
        System.out.println("Rut:"+rut); 
        cliente.mostrarOrdenes();  
    }
    
    public Cliente buscarCliente() throws IOException{
        //se ingresa un rut por teclado y se retorna el objeto "Cliente" que se encuentra en la coleccion de clientes
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del cliente(con puntos y guion): ");
        String rut = teclado.readLine();
        
        return (Cliente) clientes.get(rut);
    }
   
    public void eliminarCliente() throws IOException{
        Cliente cliente = buscarCliente();
        if(listaClientes.remove(cliente)){
            clientes.remove(cliente.getRut());//se elimina la persona de el mapa
            System.out.println("Se ha eliminado correctamente");
        }
    }
    
    //metodos relacionados con las ordenes
    public void agregarOrden() throws IOException {
        
        String rut;
        Orden orden;
        String servicio;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        do{
            System.out.println("\nIngrese rut de la cliente(con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if(rut.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }
        }while(rut.length() != 12);
        
        Cliente cliente = clientes.get(rut);//se obtiene el objeto con clave "rut" del mapa de clientes
        

        System.out.println("Ingresar nuevo servicio: ");
        servicio = teclado.readLine();
        
        //Modificacion del servicio
        orden = cliente.agregarOrden(rut, servicio);
        cliente.agregarOrden(orden);
    }
    
    public void mostrarOrdenes() throws IOException{
        Cliente cliente;
        
        do{//Se valida si la cliente existe o "no es nulo"
            cliente = (Cliente) buscarCliente();        
            if(cliente == null){
                System.out.println("Rut no encontrado, ingrese nuevamente");
            }else{
                cliente.mostrarOrdenes();
                break;
            }

        }while(cliente != null);
    }
    
    public void eliminarOrden() throws IOException{//en proceso

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        Cliente cliente = buscarCliente();
        mostrarCliente(cliente);//se muestran las ordenes de la persona

        System.out.println("Ingrese el numero de la orden que desea eliminar: ");
        String seleccion = teclado.readLine();
        int i = Integer.parseInt(seleccion);
        cliente.eliminarOrden(i-1);
    }
   
    public void modificarOrden() throws IOException{
        //inicializacion de variables
        Orden orden;
        Cliente cliente = buscarCliente();
        cliente.mostrarOrdenes();
        
        System.out.println("Ingrese el numero de la orden que desea modificar:");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        String auxTeclado = teclado.readLine();
        int i = Integer.parseInt(auxTeclado);
        
        i=i-1;//se adapta el valor de i para que este en la escala de un arreglo
        
        //se obtiene y modifica la orden
        orden = cliente.buscarOrden(i);
        cliente.modificarOrden(orden);
    }
    
    //metodos relacionados con el servicio
    public String ingresarServicio() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String servicio,convertir;
        int eleccion;
        
        System.out.println("¿Ingresar Servicio?");
       do{
            System.out.println("1.- Si");
            System.out.println("2.- No");
            convertir = teclado.readLine();
            eleccion = Integer.parseInt(convertir);
            
            //Validacion
            if((eleccion != 1) && (eleccion != 2)){
                System.out.println("Eleccion no valida, intente nuevamente");
            }
       }while((eleccion != 1) && (eleccion != 2));
        
        if(eleccion == 1){
        //se ingresa por teclado el servicio que requirio la cliente
        System.out.println("\nIngrese servicio ofrecido: ");
        servicio = teclado.readLine(); 
        
        return servicio;
        }
        
        return "Pendiente";
    }
}