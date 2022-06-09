
package Metodos;

import Cliente.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {
    
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
            pw.print("|"+cliente.getRut());
            pw.println("|"+cliente.getServicio());
            pw.close();             
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public DefaultTableModel listaAlumnos(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Rut");
        cabeceras.addElement("Servicio");
        
        
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
