package proyectogestiondeordenes;

import java.io.*;

    public class Orden {
        /*Variables iniciales*/
        private String nombre;
        private int rut;
        private String servicio;
        
        /*Constructores*/
        public Orden(String nombre, int rut, String servicio) {
            this.nombre = nombre;
            this.rut = rut;
            this.servicio = servicio;
        }
        
        
        //Metodos

        /*Getter*/
        public String getNombre() {
            return nombre;
        }

        public int getRut() {
            return rut;
        }

        public String getServicio() {
            return servicio;
        }


        /*Setter*/
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setRut(int rut) {
            this.rut = rut;
        }

        public void setServicio(String servicio) {
            this.servicio = servicio;
        }
        
        public void mostrarMapa(HashMap Map){
            
        Map<Integer,Orden> map=new HashMap<Integer,Orden>();  
         
        Orden o1 = new Orden("Acdiel", 20906578, "Arreglo Pantalla");
        Orden o2 = new Orden("Seba", 20957841, "Cargador");
        
        map.put(1,o1);
        map.put(2,o2);  
        
        //Traversing map  
        for(Map.Entry<Integer, Orden> entry:map.entrySet()){    
        int key=entry.getKey();  
        Orden o=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(o.nombre+" "+o.rut+" "+o.servicio); 
        
        }
        }
        
        
        public void mostrarOrdenes(String nombre){    
       
        }
        public void eliminarMapa(){
            
            
            
        }
        
        public void eliminarOrden(int rut){
        System.out.println(rut);
    }
    
        public void eliminarOrden(String nombre){
        System.out.println(nombre);
    }

    }
