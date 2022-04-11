package proyectoremasterizado;

import java.io.*;
import java.util.ArrayList;

public class Orden {
    
        /*Variables iniciales*/
        private String nombre;
        private String rut;
        private String servicio;
        public ArrayList<Orden> listaOrdenes;
        
        /*Constructores*/
        public Orden(String nombre, String rut, String servicio) {
            this.nombre = nombre;
            this.rut = rut;
            this.servicio = servicio;
            this.listaOrdenes = new ArrayList<>();
        }
        
        public void mostrarOrden(){
        System.out.println("El RUT "+this.rut+" es de la persona "+this.nombre+", el cual necesita un servicio de "+this.servicio+".");
    }
        
        public void agregarOrden(Orden o){
        this.listaOrdenes.add(o);
        System.out.println("Orden Agregada");
    }
       public void mostrarOrdenes(){
        for(int i = 0; i<this.listaOrdenes.size(); i++){
            this.listaOrdenes.get(i).mostrarOrden();
        }
    }
        public void mostrarServicios(String nombre){                            //para la busqueda
        for(int i = 0; i<this.listaOrdenes.size(); i++){
            if (this.listaOrdenes.get(i).getNombre().equals(nombre)){
                this.listaOrdenes.get(i).mostrarOrden();
            }
        }
    }
       
        /*Getter*/
        public String getNombre() {
            return nombre;
        }

        public String getRut() {
            return rut;
        }

        public String getServicio() {
            return servicio;
        }


        /*Setter*/
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setRut(String rut) {
            this.rut = rut;
        }

        public void setServicio(String servicio) {
            this.servicio = servicio;
        }
        
        public ArrayList<Orden> getListaOrdenes() {
        return listaOrdenes;
    }

        public void setListaProductos(ArrayList<Orden> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }
        
   

    }
    
