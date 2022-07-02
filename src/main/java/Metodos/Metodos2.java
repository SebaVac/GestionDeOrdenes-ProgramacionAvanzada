package Metodos;

import Cliente2.Cliente2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectogestiondeordenes.Cliente;
import proyectogestiondeordenes.ProyectoGestionDeOrdenes;
import proyectogestiondeordenes.Empresa;
import proyectogestiondeordenes.Persona;
import proyectogestiondeordenes.Orden;
import proyectogestiondeordenes.Empleado;
import proyectogestiondeordenes.EstadoOrden;
import proyectogestiondeordenes.Menu;


public class Metodos2 {
    
    Orden orden = new Orden("rut","servicio",false);
    private HashMap <String, Cliente> clientes = new HashMap <> ();
    private HashMap <String, Empleado> empleados = new HashMap <> ();
    private ArrayList <Cliente> listaClientes = new ArrayList <> ();
    private ArrayList <Empleado> listaEmpleados = new ArrayList<> ();
    Vector vPrincipal2 = new Vector();
    
     
        
    
        public void guardar2(Orden unOrden){
        vPrincipal2.addElement(unOrden);
    }
    
    public void guardarArchivo2(Orden orden){
        try{
            FileWriter fw2 = new FileWriter("Ordenes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw2);
            PrintWriter pw2 = new PrintWriter(bw);
            pw2.print(orden.getRut());
            pw2.println("|"+orden.getServicio());
            pw2.close();             
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public DefaultTableModel ordenes(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("RUT");
        cabeceras.addElement("SERVICIO");

        
        
        DefaultTableModel mdlTabla2 = new DefaultTableModel(cabeceras,0);
        
        try{
            FileReader fr2 = new FileReader("Ordenes.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            String d;
            while((d= br2.readLine())!= null){
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTabla2.addRow(x);
            }
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return mdlTabla2;
    }
    

}
