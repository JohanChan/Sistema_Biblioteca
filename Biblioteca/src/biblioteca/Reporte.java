package biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static biblioteca.CrearBook.vectorDocumentos;
import static biblioteca.AgregarUser.vectoruser;

public class Reporte extends javax.swing.JFrame implements ActionListener{
    JButton reporte1,reporte2,reporte3,logout;
    public Reporte(){
        reporte1 = new JButton();
        reporte2 = new JButton();
        reporte3 = new JButton();
        logout = new JButton();
        componentes();
    }
    public void componentes(){
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        reporte1.setBounds(40, 40, 180, 80);
        reporte1.setText("Reporte 1");
        reporte1.addActionListener(this);
        
        reporte2.setBounds(40, 140, 180, 80);
        reporte2.setText("Reporte 2");
        reporte2.addActionListener(this);
        
        reporte3.setBounds(250, 100, 180, 80);
        reporte3.setText("Reporte 3");
        reporte3.addActionListener(this);
        
        logout.setBounds(400, 10, 90, 30);
        logout.setText("Logout");
        logout.addActionListener(this);
        
        add(reporte1);
        add(reporte2);
        add(reporte3); 
        add(logout);
    }
    public void reporteOne(){
        File archivo = new File("Reporte1.html");
        try{
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
                pw.write("<!Doctype>");
                pw.write("<html>");
                pw.write("<head>");
                    pw.write("<title>"+"Libros Disponibles"+"</title>");
                pw.write("</head>"); 
                pw.write("<body>");
                    pw.write("<table border = "+"2px"+" >");
                        pw.write("<thead>");
                        pw.write("<tr>");
                            pw.write("<td>"+"ID"+"</td>");
                            pw.write("<td>"+"AUTOR"+"</td>");
                            pw.write("<td>"+"ESTADO"+"</td>");
                        pw.write("</tr>");
                        pw.write("</thead>");
                        
                        try{
                        for (int i = 0; i < 200; i++) {
                            if(vectorDocumentos[i].getEstado().equals("Disponible")){
                            pw.write("<tr>");
                            pw.append("<td>"+vectorDocumentos[i].getId()+"</td>");
                            pw.append("<td>"+vectorDocumentos[i].getAutor()+"</td>");
                            pw.append("<td>"+vectorDocumentos[i].getEstado()+"</td>");
                            }
                        }
                        }catch(Exception ae){
                            
                        }
                        
                        
                        pw.write("</tr>");
                    pw.write("</table>");
                pw.write("</body>");
            pw.write("</html>");
            pw.close();
            bw.close();
            
            
        }catch(IOException e){
            
        }
            
        
        }
    public void reporteTwo(){
        File archivo = new File("Reporte2.html");
        try{
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
                pw.write("<!Doctype>");
                pw.write("<html>");
                pw.write("<head>");
                    pw.write("<title>"+"Listado de Usuarios"+"</title>");
                pw.write("</head>"); 
                pw.write("<body>");
                    pw.write("<table border = "+"2px"+" >");
                        pw.write("<thead>");
                        pw.write("<tr>");
                            pw.write("<td>"+"Usuario"+"</td>");
                            pw.write("<td>"+"ID"+"</td>");
                            pw.write("<td>"+"Nombre"+"</td>");
                            pw.write("<td>"+"Apellido"+"</td>");
                            
                        pw.write("</tr>");
                        pw.write("</thead>");
                        
                        try{
                        for (int i = 0; i < 200; i++) {
                            
                            pw.write("<tr>");
                            pw.append("<td>"+vectoruser[i].getUsuario()+"</td>");
                            pw.append("<td>"+vectorDocumentos[i].getId()+"</td>");
                            pw.append("<td>"+vectoruser[i].getNombre()+"</td>");
                            pw.append("<td>"+vectoruser[i].getApellido()+"</td>");
                            
                        }
                        }catch(Exception ae){
                            
                        }
                        
                        
                        pw.write("</tr>");
                    pw.write("</table>");
                pw.write("</body>");
            pw.write("</html>");
            pw.close();
            bw.close();
            
            
        }catch(IOException e){
            
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logout){
            int log = JOptionPane.showConfirmDialog(null, "Seguro que desea Salir?");
            if(log==0){
                this.dispose();
                Loggin loggin = new Loggin();
                loggin.setVisible(true);
                InicioAdmin start = new InicioAdmin();
                start.setVisible(false);
            }
            if(log ==1){
                JOptionPane.showMessageDialog(null, "Quedate ps");
            }
        }
        if(e.getSource()==reporte1){
            reporteOne();
        }
        if(e.getSource()==reporte2){
            reporteTwo();
        }
        if(e.getSource()==reporte3){
            
        }
        
    }
}
