package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona implements EstadoOrden {

    private ArrayList<Orden> ordenes;

    /**
     *
     * @param rut
     * @param nombre
     */
    public Cliente(String rut, String nombre) {
        setRut(rut);
        setNombre(nombre);
        this.ordenes = new ArrayList<>();
    }
    
    /*Setters*/

    /**
     *
     * @param rut
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*Getters*/

    /**
     *
     * @return
     */
    public String getRut() {
        return rut;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /*Metodos*/

    /**
     *
     * @param rut
     * @param servicio
     * @param estado
     * @return
     */

    
    public Orden agregarOrden(String rut,String servicio,boolean estado){
        Orden orden = new Orden("rut","servicio",false);
        
        orden.setRut(rut);
        orden.setServicio(servicio);
        orden.setEstado(estado);
        
        return orden;
    }
    
    /**
     *
     * @param orden
     */
    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
        System.out.println("\nLa orden se ha ingresado correctamente.\n");
    }
    
    /**
     *
     * @param persona
     */
    public void paresEimpares(Persona persona){
        
        int aux=ordenes.size();  
        int cont=0;
        
        //Se evalua si el numero total de arreglos es par o impar
        if(aux % 2 == 0){
           
            String nombre2 = persona.getNombre();
            String rut2 = persona.getRut();
            System.out.println("");
            System.out.println("El cliente "+nombre2+" con rut "+rut2);
            System.out.println("Posee una cantidad de ordenes totales pares ");
            System.out.println("");
            
            cont=1+cont;
            
        }else{
        //Si el numero no es par, se entiende que es impar
            String nombre2 = persona.getNombre();
            String rut2 = persona.getRut();
            System.out.println("");
            System.out.println("El cliente "+nombre2+" con rut "+rut2);
            System.out.println("Posee una cantidad de ordenes totales impares ");
            System.out.println("");
            cont=1+cont;
        }
        //Se evalua con un contador si es que existen personas
        if(cont == 0){
        System.out.println("No existen usuarios que evaluar"); 
        }

    
    }

    /**
     *
     * @param i
     */
    public void eliminarOrden(int i) {
        Orden orden = ordenes.get(i);//se inicializa la variable "orden" con el contenido de la casilla i de la lista "ordenes" 
        orden = buscarOrden(orden.getServicio());
        ordenes.remove(orden);
        System.out.println("\nLa orden se ha eliminado correctamente.\n");
    }

    /**
     *
     * @param servicio
     * @return
     */
    public Orden buscarOrden(String servicio) {
        Orden orden;
        for (int i = 0; i < ordenes.size(); i++) {//ciclo que recorre la lista de ordenes en busca de un servicio en especifico
            orden = (Orden) ordenes.get(i);
            if (orden.getServicio().equals(servicio)) {
                return orden;
            }
        }
        return null;//si no se encuentra la orden, se retorna null
    }
    
    /**
     *
     * @param index
     * @return
     */
    public Orden buscarOrden(int index){
        
        Orden orden = ordenes.get(index); //se retorna el objeto "orden" que se encuentra en el lugar "i" del arreglo de ordenes
        
        return orden;
    }

    /**
     *
     */
    public void mostrarCliente(){
        System.out.println("Nombre:"+this.nombre);
        System.out.println("Rut:"+this.rut); 
        mostrarOrdenes();  
    }
    
    /**
     *
     */
    public void mostrarOrdenes(){
        Orden orden;
        int aux;
        for (int i = 0; i < ordenes.size(); i++) {//se recorre la lista de ordenes y se muestran los datos
            orden = (Orden) ordenes.get(i);
            aux = i+1;
            System.out.println("\nDatos orden n°" + aux + ":");
            System.out.println("Rut cliente: " + orden.getRut());
            System.out.println("Servicio: " + orden.getServicio());
            if(orden.isEstado() == true){
                System.out.println("Estado de orden: Lista");
            }else{
                System.out.println("Estado de orden: Pendiente");
            }
        }
    }
    
    /**
     *
     * @return
     */
    public int contarOrdenes(){
        int cont = ordenes.size();
        return cont;
    }

    /**
     *
     */
    public void mostrarOrdenesPendientes(){
        Orden orden;
        int cont=0;
        
        for (int i = 0; i < ordenes.size(); i++) {//se recorre la lista de ordenes y se muestran los datos
        orden = (Orden) ordenes.get(i);
            if(orden.estado == false){
            System.out.println("----------------------------------");
            System.out.println("Rut cliente: " + orden.getRut());
            System.out.println("Servicio: " + orden.getServicio());
            System.out.println("Estado de orden: Pendiente");
            System.out.println("----------------------------------");
            cont=cont+1; //contador para saber cuantas ordenes pendientes tiene el cliente
            }
        }
        System.out.println("");
        System.out.println("Se ecuentra(n) "+cont+" orden(es) pendiente(s)");
        System.out.println("");
    }
    
    //sobrecarga de metodos

    /**
     *
     * @param orden
     * @return
     * @throws IOException
     */
    public Orden modificarOrden(Orden orden) throws IOException{
        String servicio;
        String convertir;
        int eleccion;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                
        System.out.println("Modificar Servicio");
        
        do{
        System.out.println("Seleccione el servicio ofrecido: ");
        System.out.println("1.-Instalacion Software");
        System.out.println("2.-Limpieza General");
        System.out.println("3.-Reparacion");
        System.out.println("\nIngrese una opcion: ");
        convertir = teclado.readLine(); 
        eleccion = Integer.parseInt(convertir); 
            if(eleccion < 1 || eleccion > 3){
                System.out.println("Opcion invalida, intente nuevamente.");
            }
        }while(eleccion < 1 || eleccion > 3);
        
        servicio = estado(eleccion);
        
        orden.setServicio(servicio);//se sobreescribe el servicio
        
        do{
            System.out.println("Seleccione el estado de la orden: ");
            System.out.println("1.-Listo");
            System.out.println("2.-Pendiente");
            convertir = teclado.readLine(); 
            eleccion = Integer.parseInt(convertir); 
            if(eleccion < 1 || eleccion > 2){
                System.out.println("Opcion invalida, intente nuevamente.");
            }
        }while(eleccion < 1 || eleccion > 2);
        
        switch(eleccion){
            case 1:
                orden.setEstado(true);
                break;
                
            case 2:
                orden.setEstado(false);
                break;
        }
        
        System.out.println("\nSe ha modificado correctamente.\n");
            
        return orden;
    }
    
    /**
     *
     * @param eleccion
     * @return
     */
    @Override
    public String estado(int eleccion) {
        if(eleccion == 1){
            return EstadoOrden.estado2;
        }
        if(eleccion == 2){
            return EstadoOrden.estado3;
        }
        if(eleccion == 3){
            return EstadoOrden.estado4;
        }
        return null;
    }
    
    /**
     *
     * @param cliente
     */
    public void modificarOrden(Cliente cliente){
        Orden ordenAux;
        
        for(int i = 0; i < ordenes.size(); i++){
            ordenAux = ordenes.get(i);
            ordenAux.setRut(cliente.getRut());
        }
    }
}
