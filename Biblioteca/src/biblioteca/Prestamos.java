package biblioteca;

import static biblioteca.CrearBook.vectorDocumentos;
import static biblioteca.VerDocumento.vectorPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Prestamos extends javax.swing.JFrame implements ActionListener{
    JButton devolver,logout,regresar,ver;
    int filaselect;
    JTable tabla;
    DefaultTableModel stm;
    String[] header = {"ID", "Autor", "Titulo", "Tipo"};
    String dato[][] = {};
    JScrollPane contenedor;
    JLabel nombre;
    public Prestamos(){
        nombre = new JLabel();
        stm = new DefaultTableModel(dato,header);
        contenedor = new JScrollPane();
        tabla = new JTable();
        devolver = new JButton();
        logout = new JButton();
        regresar = new JButton();
        ver = new JButton();
        inicializarComponentes();
        
    }
    public void inicializarComponentes(){
        this.setSize(750, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        logout.setBounds(630, 10, 90, 30);
        logout.setText("Logout");
        logout.addActionListener(this);
        
        devolver.setBounds(630, 380, 90, 30);
        devolver.setText("Devolver"); 
        devolver.addActionListener(this); 
        
        regresar.setBounds(10, 380, 90, 30);
        regresar.setText("Regresar"); 
        regresar.addActionListener(this);
        
        tabla.setBounds(10, 70, 720, 300);
        tabla.setModel(stm);
        contenedor.setBounds(tabla.getX(), tabla.getY(), tabla.getWidth(), tabla.getHeight());
        add(contenedor);
        contenedor.setViewportView(tabla);
        
        nombre.setBounds(10, 10, 100, 20);
        
        ver.setBounds(520, 380, 90, 30);
        ver.setText("Ver Prestamos");
        ver.addActionListener(this);
        
        add(ver);
        add(nombre);
        add(regresar);
        add(devolver);
        add(logout);
        
    }
    public void prestados(){
        try{
            for (int i = 0; i < 50; i++) {
                if(vectorPrestamos[i].getIdUser().equals(nombre.getText())){
                    String[] libro = {vectorPrestamos[i].getIdDocumento() ,vectorPrestamos[i].getAutor() , vectorPrestamos[i].getTitulo(),  vectorPrestamos[i].getTipo()
                    };
                    stm.addRow(libro);
                }
            }
        }catch(Exception e){
            
        }
        
    }
    public void devolver(){
        filaselect = tabla.getSelectedRow();
        System.out.println(filaselect);
        System.out.println(tabla.getValueAt(filaselect, 0).toString());
        if (filaselect >= 0) {
            try{ 
                for (int i = 0; i < 50; i++) {
                    if(vectorDocumentos[i].getId().equals(tabla.getValueAt(filaselect, 0).toString())){
                        vectorDocumentos[i].setEstado("Disponible");
                        JOptionPane.showMessageDialog(null, "Libro Devuelto");
                    } 
                }
            }catch(Exception e){
                
            }

        }
    }
     public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
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
            }
            if(log ==1){
                JOptionPane.showMessageDialog(null, "Quedate ps");
            }
        }
        if(e.getSource()==regresar){
            this.dispose();
            InicioUser inicio = new InicioUser();
            inicio.nombre.setText(nombre.getText()); 
            inicio.setVisible(true); 
        }
        if(e.getSource()==devolver){
            devolver();
            limpiarTabla(tabla);
            prestados();
        }
        if(e.getSource()==ver){
            prestados();
        }
    }
}
