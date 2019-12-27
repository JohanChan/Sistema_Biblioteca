package biblioteca;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import biblioteca.AgregarUser;
import static biblioteca.CargaMasiva.vectormasivo;

public class Loggin extends javax.swing.JFrame implements ActionListener {
   
    JLabel user, contra;
    JTextField usuario;
    JPasswordField pass;
    JPanel panel;
    JButton loggin, registro;
    AgregarUser add;
    int indice = 0;
    
    public Loggin() {
        super("Loggin");
        add = new AgregarUser();
        user = new JLabel();
        contra = new JLabel();
        usuario = new JTextField();
        pass = new JPasswordField();
        panel = new JPanel();
        loggin = new JButton();
        registro = new JButton();
        this.inicializarComponentes();

    }

    public void inicializarComponentes() {
        this.setSize(400, 280);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setBackground(new Color(133, 245, 133));
        panel.setLayout(null);

        usuario.setBounds(110, 40, 100, 30);
        pass.setBounds(110, 120, 100, 30);

        user.setBounds(30, 30, 90, 50);
        user.setText("Usuario:");
        contra.setBounds(30, 110, 90, 50);
        contra.setText("Contrasenia:");

        loggin.setBounds(60, 180, 90, 30);
        loggin.setText("Ingresar");
        loggin.addActionListener(this);

        registro.setBounds(200, 180, 90, 30);
        registro.setText("Registro");
        registro.addActionListener(this);

        panel.add(usuario);
        panel.add(pass);
        panel.add(user);
        panel.add(loggin);
        panel.add(registro);
        panel.add(contra);
        this.add(panel);

    }

    public void admin() { 
        InicioUser consulta = new InicioUser();
        String us = usuario.getText();
        String pas = pass.getText();
        try {
            
            if (usuario.getText().equals("b")) {
                if (pass.getText().equals("b")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    this.dispose();
                    InicioAdmin start = new InicioAdmin();
                    start.setVisible(true);
                }
                
            
            } else if (AgregarUser.vectoruser[0].getUsuario().equals(us) && AgregarUser.vectoruser[0].getPass().equals(pas)) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+AgregarUser.vectoruser[0].getNombre());
                consulta.nombre.setText(us); 
                this.dispose();
                consulta.setVisible(true);  
            } else if (AgregarUser.vectoruser[1].getUsuario().equals(us) && AgregarUser.vectoruser[1].getPass().equals(pas)) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+AgregarUser.vectoruser[1].getNombre());
                consulta.setVisible(true);
                consulta.nombre.setText(us);
                this.dispose();
            } else if (AgregarUser.vectoruser[2].getUsuario().equals(us) && AgregarUser.vectoruser[2].getPass().equals(pas)) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+AgregarUser.vectoruser[2].getNombre());
                consulta.setVisible(true);
                consulta.nombre.setText(us);
                this.dispose();
            } else if (AgregarUser.vectoruser[3].getUsuario().equals(usuario.getText()) && AgregarUser.vectoruser[3].getPass().equals(pass.getText())) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+AgregarUser.vectoruser[3].getNombre());
                consulta.setVisible(true);
                consulta.nombre.setText(us);
                this.dispose();
            } else if (AgregarUser.vectoruser[4].getUsuario().equals(usuario.getText()) && AgregarUser.vectoruser[4].getPass().equals(pass.getText())) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+AgregarUser.vectoruser[4].getNombre());
                consulta.setVisible(true);
                consulta.nombre.setText(us);
                this.dispose();
            } else if (AgregarUser.vectoruser[5].getUsuario().equals(usuario.getText()) && AgregarUser.vectoruser[5].getPass().equals(pass.getText())) {
                JOptionPane.showMessageDialog(null, "Bienvenido "+AgregarUser.vectoruser[5].getNombre());
                consulta.setVisible(true);
                consulta.nombre.setText(us);
                this.dispose();
            }else if(vectormasivo[0].getUsuario().equals(us) ){
                JOptionPane.showMessageDialog(null, "Bienvenido "+vectormasivo[0].getNombre());
                consulta.setVisible(true);
                consulta.nombre.setText(us);
                this.dispose();
            
            }else{
                JOptionPane.showMessageDialog(null, "Incorrecto");
            }
        } catch (Exception e) {
            System.out.println(us+" "+pas);
            System.out.println(vectormasivo[0].getUsuario()+"   "+vectormasivo[0].getPass());
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void registro() {
        this.dispose();
        AgregarUser add = new AgregarUser();
        add.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == loggin) {
            admin();
        }
        if (e.getSource() == registro) {
            registro();

        }
    }
}
