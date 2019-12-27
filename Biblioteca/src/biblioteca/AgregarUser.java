package biblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class AgregarUser extends javax.swing.JFrame implements ActionListener{
    String us,contra,nomb,apell;
    long ident;
    int indice=0;
    static Usuario[] vectoruser = new Usuario[10];
    JLabel user,pass,id,nombre,apellido;
    JTextField usuario,password,identificador,name,txtapellido;
    JButton agregar,regresar;
    public AgregarUser(){
        agregar = new JButton();
        regresar = new JButton();
        
        user = new JLabel();
        pass = new JLabel();
        id = new JLabel();
        nombre = new JLabel();
        apellido = new JLabel();
        
        usuario = new JTextField();
        password = new JTextField();
        identificador = new JTextField();
        name = new JTextField();
        txtapellido = new JTextField();
        inicializarComponentes();
    }
    public void inicializarComponentes(){
        this.setSize(230,250);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        user.setBounds(10, 10, 80, 30);
        user.setText("Usuario:");
        
        pass.setBounds(10, 40, 80, 30);
        pass.setText("Contraseña:");
        
        id.setBounds(10, 70, 50, 30);
        id.setText("Id:");
        
        nombre.setBounds(10, 100, 80, 30);
        nombre.setText("Nombre:");
        
        apellido.setBounds(10, 130, 80, 30);
        apellido.setText("Apellido");
        
        usuario.setBounds(110, 15, 90, 20);
        
        password.setBounds(110, 40, 90, 20);
        
        identificador.setBounds(110, 70, 90, 20);
        
        name.setBounds(110, 100, 90, 20);
        
        txtapellido.setBounds(110, 130, 90, 20);
        
        agregar.setBounds(10, 170, 80, 30);
        agregar.setText("Agregar");
        agregar.addActionListener(this);
        
        regresar.setBounds(110, 170, 90, 30);
        regresar.setText("Regresar");
        regresar.addActionListener(this); 
        
        this.add(apellido);
        this.add(txtapellido);
        this.add(regresar);
        this.add(agregar);
        this.add(usuario);
        this.add(password);
        this.add(identificador);
        this.add(name);
        this.add(user);
        this.add(pass);
        this.add(id);
        this.add(nombre);
        
    }
    public void agregarUsuarios(){
        us = usuario.getText();
        contra = password.getText();
        ident = Long.parseLong(identificador.getText());
        nomb = name.getText();
        apell = txtapellido.getText();
        vectoruser[indice] = new Usuario(nomb,apell,ident,contra,us);
        System.out.println("Posicion "+"["+indice+"] "+vectoruser[indice].usuario+" Password "+vectoruser[indice].pass);
        indice++;
        usuario.setText("");
        password.setText("");
        identificador.setText("");
        name.setText("");
        usuario.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==regresar){
            this.dispose();
            Loggin log = new Loggin();
            log.setVisible(true); 
        }
        if(e.getSource()==agregar){
            this.agregarUsuarios();
            
        }
    }
    
}
