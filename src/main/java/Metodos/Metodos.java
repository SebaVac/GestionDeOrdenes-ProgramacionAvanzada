
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


public class Metodos {
    
    Cliente cliente = new Cliente("rut","nombre");
    Orden orden = new Orden("rut","servicio",false);
    private HashMap <String, Cliente> clientes = new HashMap <> ();
    private HashMap <String, Empleado> empleados = new HashMap <> ();
    private ArrayList <Cliente> listaClientes = new ArrayList <> ();
    private ArrayList <Empleado> listaEmpleados = new ArrayList<> ();
    Vector vPrincipal = new Vector();
    
    public void guardar(Cliente unCliente){
        vPrincipal.addElement(unCliente);
    }
    
    public void guardarArchivo(Cliente cliente){
        try{
            FileWriter fw = new FileWriter("Clientes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(cliente.getNombre());
            pw.println("|"+cliente.getRut());
            pw.close();             
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public DefaultTableModel listaClientes(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("NOMBRE");
        cabeceras.addElement("RUT");

        
        
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras,0);
        
        try{
            FileReader fr = new FileReader("Clientes.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while((d= br.readLine())!= null){
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return mdlTabla;
    }
        
}
