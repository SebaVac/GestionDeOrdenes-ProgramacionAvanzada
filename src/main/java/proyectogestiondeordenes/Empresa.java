package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Empresa implements EstadoOrden {

    /*Variables de instancia*/
    private HashMap <String, Cliente> clientes = new HashMap <> ();
    private HashMap <String, Empleado> empleados = new HashMap <> ();
    private ArrayList <Cliente> listaClientes = new ArrayList <> ();
    private ArrayList <Empleado> listaEmpleados = new ArrayList<> ();

    /*Metodos*/
    
    //ingresar datos iniciales

    /**
     *
     */
    public void agregarDatosIniciales(){
        //se ingresan los empleados
        Empleado empleado1 = new Empleado("20.980.419-0","Sebastian Saavedra");
        
        empleados.put(empleado1.getRut(),empleado1);
        listaEmpleados.add(empleado1);
        
        Empleado empleado2 = new Empleado("20.960.630-5","Javiera Zuniga");
        
        empleados.put(empleado2.getRut(),empleado2);
        listaEmpleados.add(empleado2);
        
        //se ingresan los clientes
        Cliente cliente1 = new Cliente("20.906.578-9","Acdiel Bombin");
        Orden orden1 = new Orden("20.906.578-9","Reparacion",true);
        
        cliente1.agregarOrden(orden1);
        clientes.put(cliente1.getRut(),cliente1);
        listaClientes.add(cliente1);
        
        
        Cliente cliente2 = new Cliente("20.844.578-2","Matias Gallardo");
        Orden orden2 = new Orden("20.844.578-2","Limpieza General",true);
        Orden orden3 = new Orden("20.844.578-2","Instalacion Software",false);
        
        cliente2.agregarOrden(orden2);
        cliente2.agregarOrden(orden3);
        clientes.put(cliente2.getRut(),cliente2);
        listaClientes.add(cliente2);
        
    }
    
    //metodos relacionados con la cliente/cliente

    /**
     *
     * @throws IOException
     */
    public void agregarPersona() throws IOException{
        Cliente cliente = new Cliente("rut","nombre");
        Empleado empleado = new Empleado("rut","nombre");
        
        Orden orden = new Orden("rut","servicio",false);
        String nombre, rut,seleccion;
        int eleccion;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
       
        System.out.println("1.-Agregar Cliente");
        System.out.println("2.-Agregar Empleado");
        seleccion = teclado.readLine();
        eleccion = Integer.parseInt(seleccion);
        
        if(eleccion == 1){     
        //ciclo para validar el rut de una cliente
        do{
            System.out.println("\nIngrese rut del cliente(con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if(rut.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }else{
                if(clientes.get(rut) != null){
                    System.out.println("Rut ya ingresado, intente nuevamente\n"); 
                }else{
                    cliente.setRut(rut);
                    orden.setRut(rut);
                    
                    //Se ingresan los datos por teclado
                    System.out.println("Ingrese nombre del cliente: ");
                    nombre = teclado.readLine();
                    cliente.setNombre(nombre);

                    clientes.put(rut,cliente);
                    listaClientes.add(cliente);
                    System.out.println("El cliente se ha ingresado correctamente");
                }
            }
        }while(rut.length() != 12);
        
        }else{
           
        //validacion rut    
        do{
            System.out.println("\nIngrese rut del empleado (con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if(rut.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }else{
                if(empleados.get(rut) != null){
                    System.out.println("Rut ya ingresado, intente nuevamente\n");  
                }else{
                    empleado = empleado.agregarNombreEmpleado(rut);
                    empleado.setRut(rut);
                }
            }
        }while(rut.length() != 12);

        //se ingresa a las colecciones de empleados
        empleados.put(empleado.getRut(), empleado);
        listaEmpleados.add(empleado);
        }  
    }

    /**
     *
     * @throws IOException
     */
    public void mostrarPersona() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int eleccion;
        String convertir;
        
        do{
        System.out.println("Mostrar lista de: ");
        System.out.println("1.-Clientes");
        System.out.println("2.-Empleados");
        System.out.println("3.-Todo");
        
        convertir = teclado.readLine();
        eleccion = Integer.parseInt(convertir);
        }while(eleccion < 1 || eleccion > 3);
        
        switch(eleccion){
            case 1:
                mostrarClientes();
                break;
                
            case 2:
                mostrarEmpleados();
                break;
                
            case 3:
                System.out.println("-------------Empleados-------------");
                mostrarEmpleados();
                System.out.println("-------------Clientes-------------");
                mostrarClientes();
                break;
        }
        
    }
    
    /**
     *
     * @throws IOException
     */
    public void mostrarClientes() throws IOException{
        Cliente cliente;
        int aux;
        
        if(clientes != null && listaClientes != null){
            for(int i = 0;i < listaClientes.size();i++){
                cliente = listaClientes.get(i);
                aux = i+1;
                System.out.println("----------------------------------");
                System.out.println(""+aux+"°:");
                cliente.mostrarCliente();
                System.out.println("----------------------------------");
            }
        }
    }
    
    /**
     *
     */
    public void mostrarEmpleados(){
        Empleado empleado;
        int aux;
        
        if(empleados != null && listaEmpleados != null){
            for(int i = 0; i < listaEmpleados.size(); i++){
                empleado = listaEmpleados.get(i);
                aux = i+1;
                System.out.println("----------------------------------");
                System.out.println(""+aux+"°:");
                empleado.mostrarEmpleado();
                System.out.println("----------------------------------");
            }
        }
    }
    
    /**
     *
     * @throws IOException
     */
    public void mostrarClienteMasOrdenesTotales()throws IOException{
        Cliente cliente;
        int cont = 0;
        int indexAux = 0;
        int max = 0;
        
        for(int i = 0; i < listaClientes.size(); i++){
            cliente = listaClientes.get(i);
            cont = cliente.contarOrdenes();
            if(max < cont){
                max = cont;
                indexAux = i;
            }
        }
        
        cliente = listaClientes.get(indexAux);
        System.out.println("----------------------------------");
        System.out.println("Datos:");
        System.out.println("Nombre: "+cliente.getNombre());
        System.out.println("Rut: "+cliente.getRut());
        System.out.println("Tiene "+max+" ordenes en total.");
        System.out.println("----------------------------------");
    }
    /**
     *
     * @throws IOException
     */
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
    
    /**
     *
     * @return
     * @throws IOException
     */
    public Cliente buscarCliente() throws IOException{
        //se ingresa un rut por teclado y se retorna el objeto "Cliente" que se encuentra en la coleccion de clientes
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del cliente(con puntos y guion): ");
        
        String rut = teclado.readLine();
        
        return (Cliente) clientes.get(rut);
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public Empleado buscarEmpleado() throws IOException{
        //se ingresa un rut por teclado y se retorna el objeto "Empleado" que se encuentra en la coleccion de empleados
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el rut del Empleado(con puntos y guion): ");

        String rut = teclado.readLine();
        
        return (Empleado) empleados.get(rut);
    }
   
    /**
     *
     * @throws IOException
     */
    public void eliminarPersona() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int eleccion;
        String convertir;
        
        do{
        System.out.println("La persona a eliminar tiene el rol de: ");
        System.out.println("1.-Cliente");
        System.out.println("2.-Empleado");
        
        convertir = teclado.readLine();
        eleccion = Integer.parseInt(convertir);
        }while(eleccion < 1 || eleccion > 2);
        
        switch(eleccion){
            case 1:
                eliminarCliente();
                break;
                
            case 2:
                eliminarEmpleado();
                break;
        }
    }
    
    /**
     *
     * @throws IOException
     */
    public void eliminarCliente() throws IOException{
        Cliente cliente = buscarCliente();
        if(listaClientes.contains(cliente) && clientes.containsKey(cliente.getRut())){
            clientes.remove(cliente.getRut());//se elimina el cliente del mapa
            listaClientes.remove(cliente);//se elimina el cliente de la lista
            System.out.println("Se ha eliminado correctamente");
        }
    }
    
    /**
     *
     * @throws IOException
     */
    public void eliminarEmpleado() throws IOException{
        Empleado empleado = buscarEmpleado();
        
        if(listaEmpleados.contains(empleado) && empleados.containsKey(empleado.getRut())){
            empleados.remove(empleado.getRut());
            listaEmpleados.remove(empleado);
            System.out.println("Se ha eliminado correctamente");
        }
    }
    
    //metodos relacionados con las ordenes

    /**
     *
     * @throws IOException
     */
    public void agregarOrden() throws IOException {
        
        String rut;
        Orden orden = new Orden("rut","servicio",false);
        String servicio;
        boolean estado = false;;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        do{
            System.out.println("\nIngrese rut de la cliente(con puntos y guion): ");
            rut = teclado.readLine();
            
            //Validacion
            if((rut.length() != 12) || (clientes.get(rut) == null)){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }else{
                Cliente cliente = clientes.get(rut);//se obtiene el objeto con clave "rut" del mapa de clientes


                System.out.println("Ingresar nuevo servicio: ");
                servicio = ingresarServicio();

                //Modificacion del servicio
                orden = cliente.agregarOrden(rut, servicio,estado);
                cliente.agregarOrden(orden);
            }
        }while((rut.length() != 12) || (clientes.get(rut) == null));
    }
    
    /**
     *
     * @throws IOException
     */
    public void mostrarOrdenes() throws IOException{
        Cliente cliente;
        String seleccion;
        int i;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        do{
            System.out.println("----------------------------------");
            System.out.println("1.- Cliente en especifico");
            System.out.println("2.- Todos los clientes");
            System.out.println("----------------------------------");
            System.out.println("Seleccionar una opcion:");
            seleccion = teclado.readLine();
            i = Integer.parseInt(seleccion);
            if(i == 1){
                do{
                    cliente = (Cliente) buscarCliente();
                    if(cliente == null){
                        System.out.println("Rut no encontrado, ingrese nuevamente\n");
                    }
                }while(cliente == null);
                cliente.mostrarOrdenes();
                break;
            }else{
                for(i = 0; i < listaClientes.size(); i++){
                    cliente = listaClientes.get(i);
                    cliente.mostrarCliente();
                    System.out.println("----------------------------------");
                }
            }
        }while((i < 1) || (i > 2));
    }
    
    /**
     *
     * @throws IOException
     */
    public void eliminarOrden() throws IOException{//en proceso

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        Cliente cliente = buscarCliente();
        cliente.mostrarCliente();//se muestran las ordenes de la persona

        System.out.println("Ingrese el numero de la orden que desea eliminar: ");
        String seleccion = teclado.readLine();
        int i = Integer.parseInt(seleccion);
        cliente.eliminarOrden(i-1);
    }
   
    /**
     *
     * @throws IOException
     */
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
    /**
     *
     * @return
     * @throws IOException
     */
    public String ingresarServicio() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String servicio,convertir;
        int eleccion;
        
        //se escoge por teclado el servicio que requirio la cliente
        do{
        System.out.println("1.-Instalacion Software");
        System.out.println("2.-Limpieza General");
        System.out.println("3.-Reparacion");
        System.out.println("\nIngrese una opcion: ");
        convertir = teclado.readLine(); 
        eleccion = Integer.parseInt(convertir); 
        }while(eleccion < 1 || eleccion > 3);
 
        servicio = estado(eleccion);
        
        return servicio;
    }
    
    /**
     *
     * @param eleccion
     * @return
     */
    @Override
    public String estado(int eleccion) {
        
        switch(eleccion){
            case 1:
                return EstadoOrden.estado2;
                
            case 2:
                return EstadoOrden.estado3;
                
            case 3:
                return EstadoOrden.estado4;
                
        }

        return null;
    }
    
    /**
     *
     * @throws IOException
     */
    public void modificarPersona() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int eleccion;
        String convertir;
        
        do{
        System.out.println("La persona a modificar tiene el rol de: ");
        System.out.println("1.-Cliente");
        System.out.println("2.-Empleado");
        
        convertir = teclado.readLine();
        eleccion = Integer.parseInt(convertir);
        }while(eleccion < 1 || eleccion > 2);
        
        switch(eleccion){
            case 1:
                modificarCliente();
                break;
                
            case 2:
                modificarEmpleado();
                break;
        }
    }
    
    /**
     *
     * @throws IOException
     */
    public void modificarCliente() throws IOException {
        Cliente cliente;
        Cliente clienteAux;
        String aux;
        int num;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        mostrarClientes();

        //se le solicita al usuario el numero del cliente para poder modificar sus datos
        System.out.println("Ingresar numero de cliente");
        aux = teclado.readLine();
        num = Integer.parseInt(aux);
        num = num-1;
        
        cliente = listaClientes.get(num);
        clienteAux = clientes.get(cliente.getRut());
        
        //se modifican los datos de la persona
        System.out.println("Ingrese nombre del cliente:");
        aux = teclado.readLine();
        cliente.setNombre(aux);
        
        
        do{
            System.out.println("Ingrese rut del cliente con puntos y guion:");
            aux = teclado.readLine();
            
            //validacion
            if(aux.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente\n");
            }
        }while(aux.length() != 12);
        cliente.setRut(aux);
        
        cliente.modificarOrden(cliente);
        
        listaClientes.remove(num);//se borra el contenido en la casilla "num"
        listaClientes.add(num, cliente);//se ingresa el cliente con las modificaciones realizadas y se inserta en el indice "num" del arrayList
        
        clientes.remove(clienteAux.getRut());//se remueve el contenido de la casilla
        clientes.put(cliente.getRut(), cliente);//se reemplaza por el nuevo cliente
    }
    
    /**
     *
     * @throws IOException
     */
    public void modificarEmpleado() throws IOException{
        Empleado empleado;
        Empleado empleadoAux;
        String aux;
        int num;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        mostrarEmpleados();
        
        //se le solicita al usuario el numero del Empleado para poder modificar sus datos;
        System.out.println("Ingresar numero del empleado: ");
        aux = teclado.readLine();
        num = Integer.parseInt(aux);
        num = num-1;
        
        empleado = listaEmpleados.get(num);
        empleadoAux = empleados.get(empleado.getRut());
        
        //se modifican los datos de la persona
        System.out.println("Ingrese nombre del empleado:");
        aux = teclado.readLine();
        empleado.setNombre(aux);
        
        do{
            System.out.println("Ingrese el rut del Empleado con putnos y guion: ");
            aux = teclado.readLine();
            
            //validacion
            if(aux.length() != 12){
                System.out.println("Rut incorrecto, intente nuevamente.\n");
            }
        }while(aux.length() != 12);
        empleado.setRut(aux);

        listaEmpleados.remove(num); //se borra el contenido en la casilla "num"
        listaEmpleados.add(num,empleado); //se ingresa el empleado con las modificaciones realizadas y se inserta en el indice "num" del arrayList
        
        empleados.remove(empleadoAux.getRut());
        empleados.put(empleado.getRut(), empleado);
    }
}