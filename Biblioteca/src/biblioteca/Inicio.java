package biblioteca;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame implements ActionListener{
    JPanel panel,panellogo;
    JButton loggin,about;
    JLabel logo,lologin;
    ImageIcon usac,login;
    public Inicio(){
        super("IPC PROYECTO 1");
        panel = new JPanel();
        loggin = new JButton();
        about = new JButton();
        logo = new JLabel();
        panellogo = new JPanel();
        lologin = new JLabel();
        this.inicializarComponentes();
    }
    public void inicializarComponentes(){
        //Ventana Inicio
        this.setSize(800,420);
        this.setLocationRelativeTo(null); 
        this.setLayout(null); 
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        //Panel para Ventana de Inicio
        panel.setBounds(20,10,760,80);
        panel.setBackground(new Color( 99, 143, 237 )); 
        panel.setLayout(null);
        panellogo.setBounds(20, 110, 380, 200);
        panellogo.setBackground(new Color( 99, 143, 237 )); 
        panellogo.setLayout(null);
               
        //label para agregar Logo Usac
        logo.setBounds(10, 10, 360, 170);
        usac = new ImageIcon(getClass().getResource("/Imagenes/logoUsac.png"));
        usac = new ImageIcon(usac.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(usac);
        
        //label para agregar Logo de loggin
        lologin.setBounds(10, 10, 120, 60);
        login = new ImageIcon(getClass().getResource("/Imagenes/loggin.png"));
        login = new ImageIcon(login.getImage().getScaledInstance(lologin.getWidth(), lologin.getHeight(), Image.SCALE_DEFAULT));
        lologin.setIcon(login);
        
        //botones loggin y about
        loggin.setBounds(650, 20, 90, 40);
        loggin.setText("Loggin"); 
        about.setBounds(50, 330, 90, 40);
        about.setText("About"); 
        loggin.addActionListener(this);
        //agregar componentes a la Ventana
        panel.add(lologin);
        panel.add(loggin);
        panellogo.add(logo);
        this.add(about);
        this.add(panellogo);
        this.add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==loggin){
            this.dispose();
            Loggin log = new Loggin();
            log.setVisible(true);
        }
    }
}
