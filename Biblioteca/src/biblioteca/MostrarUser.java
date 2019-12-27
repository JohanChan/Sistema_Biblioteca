package biblioteca;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class MostrarUser extends JFrame implements ActionListener{
    JTable tabla;
    JButton regresar,mostrar;
    String[] header = {"UserName","Nombre","Apellido","Libros Prestados"};
    DefaultTableModel stm;
    String datos[][]={};
    public MostrarUser(){
        super("Mostrar Usuario");
        tabla = new JTable();    
        regresar = new JButton();
        mostrar = new JButton();
        stm = new DefaultTableModel(datos,header);
        inicializarComponentes();
        mostrarenPantalla();
    }
    public void inicializarComponentes(){
        this.setSize(490, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        tabla.setBounds(10, 10, 460, 400);
        tabla.setModel(stm); 
        
        regresar.setBounds(10, 420, 100, 30);
        regresar.setText("Regresar");
        regresar.addActionListener(this); 
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 465, 400);
        add(scrollPane);
        scrollPane.setViewportView(tabla);
        
        
        add(regresar);
        
        
    }
    public void mostrarenPantalla(){
        try{
        for (int i = 0; i < 10; i++) {
            String[] data = {AgregarUser.vectoruser[i].getUsuario(),AgregarUser.vectoruser[i].getNombre(),AgregarUser.vectoruser[i].getApellido()};
            stm.addRow(data);
            }
        }catch(Exception ae){
            
            
            System.out.println(ae.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==regresar){
            this.dispose();
            Admin admin = new Admin();
            admin.setVisible(true); 
        }
    }
}
