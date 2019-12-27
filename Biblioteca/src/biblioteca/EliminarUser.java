package biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class EliminarUser extends javax.swing.JFrame implements ActionListener{
    JLabel usuario,nombre,apellido,id,contra;
    JTextField txtusuario,txtnombre,txtapet,txtidt,txtcontra;
    JButton buscar;
    JButton modificar;
    JButton cance;
    long numero;
    public EliminarUser(){
     super("Eliminar Usuario");
     usuario = new JLabel();
     nombre = new JLabel();
     apellido = new JLabel();
     id = new JLabel();
     contra = new JLabel();
     txtusuario = new JTextField();
     txtnombre = new JTextField();
     txtapet = new JTextField();
     txtidt = new JTextField();
     txtcontra = new JTextField();
     buscar = new JButton();
     cance = new JButton();
     modificar = new JButton();
     inicializarComponentes();
    }
     public void inicializarComponentes(){
        this.setSize(400,280);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        //--------------------------------------------
        id.setBounds(10, 10, 90, 30);
        id.setText("Ingrese Id");
        
        usuario.setBounds(10, 40, 90, 30);
        usuario.setText("Usuario");
        
        nombre.setBounds(10, 70, 90, 30);
        nombre.setText("Nombre");
        
        apellido.setBounds(10, 100, 90, 30);
        apellido.setText("Apellido");
        
        contra.setBounds(10, 130, 90, 30);
        contra.setText("Contrasenia");
        //-----------------------------------------------
        
        txtusuario.setBounds(130, 40, 100, 20);
        
        txtnombre.setBounds(130, 70, 100, 20);
        
        txtapet.setBounds(130, 100, 100, 20);
        
        txtidt.setBounds(130, 10, 100, 20);
        
        txtcontra.setBounds(130, 130, 100, 20);
        //------------------------------------------------
        buscar.setBounds(250, 10, 100, 30);
        buscar.setText("Buscar");
        buscar.addActionListener(this);
        
        modificar.setBounds(10, 200, 100, 30);
        modificar.setText("Eliminar");
        modificar.addActionListener(this);
        
        cance.setBounds(150, 200, 100, 30);
        cance.setText("Regresar");
        cance.addActionListener(this);
        //------------------------------------------------
        add(id);
        add(usuario);
        add(nombre);
        add(apellido);
        add(contra);
        add(txtusuario);
        add(txtnombre);
        add(txtapet);
        add(txtidt);
        add(txtcontra);
        add(buscar);
        add(modificar);
        add(cance);
    }
     public void buscar(){ 
        numero = Long.parseLong(txtidt.getText());
        try{
        for(int i=0;i<10;i++){
            if(numero==AgregarUser.vectoruser[i].getId()){
            txtnombre.setText(AgregarUser.vectoruser[i].getNombre());
            txtapet.setText(AgregarUser.vectoruser[i].getApellido());
            txtusuario.setText(AgregarUser.vectoruser[i].getUsuario());
            txtcontra.setText(AgregarUser.vectoruser[i].getPass());
            
            }
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
      public void eliminar(){
        try{
        for(int i=0;i<10;i++){
            if(numero==AgregarUser.vectoruser[i].getId()){
                AgregarUser.vectoruser[i].setPass(" ");
                AgregarUser.vectoruser[i].setApellido(" ");
                AgregarUser.vectoruser[i].setUsuario(" ");
                AgregarUser.vectoruser[i].setNombre(" ");
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            }
        }
        }catch(Exception ae){
            ae.getMessage();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==cance){
            this.dispose();
            Admin admin = new Admin();
            admin.setVisible(true);
        }
        if(e.getSource()==buscar){
            buscar();
        }
        if(e.getSource()==modificar){
            eliminar();
            txtusuario.setText(" ");
            txtnombre.setText(" ");
            txtapet.setText(" ");
            txtcontra.setText(" ");
            txtidt.setText(" ");
            txtidt.requestFocus();
        }
    }
}
