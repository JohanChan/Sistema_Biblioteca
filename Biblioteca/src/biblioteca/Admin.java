package biblioteca;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class Admin extends javax.swing.JFrame implements ActionListener{
    JLabel logo;
    ImageIcon icono;
    JButton logout;
    JButton moduser,deluser,mostuser;
    JButton cargaIndividual,cargaMasiva;
    JPanel biblio,user;
    public Admin(){
        super("Administrador");
        logout = new JButton();
        moduser = new JButton();
        deluser = new JButton();
        mostuser = new JButton();
        cargaIndividual = new JButton();
        cargaMasiva = new JButton();
        logo = new JLabel();
        user = new JPanel();
        biblio = new JPanel();
        
        this.inicializarComponentes();
    }
    public void inicializarComponentes(){
        
        this.setSize(680,400);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);  
        this.setResizable(false); 
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        logo.setBounds(20, 10, 150, 130);
        icono = new ImageIcon(getClass().getResource("/Imagenes/logoUsac.png"));
        icono = new ImageIcon(icono.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(icono);
        
        user.setBounds(20, 180, 300, 180);
        user.setBackground(new Color( 247, 113, 113 ));
        user.setLayout(null);
        user.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(255, 255, 255)));
                 
        biblio.setBounds(350, 180, 300, 180);
        biblio.setBackground(new Color( 247, 113, 113 ));
        biblio.setLayout(null);
        biblio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bibliografia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(255, 255, 255)));
        
        logout.setBounds(560, 10, 90, 30);
        logout.setText("Logout");
        logout.addActionListener(this);
        //**************************************
        moduser.setBounds(30, 50, 90, 30);
        moduser.setText("Modificar");
        moduser.addActionListener(this);
        
        deluser.setBounds(170, 50, 90, 30);
        deluser.setText("Eliminar");
        deluser.addActionListener(this);
        
        mostuser.setBounds(100, 100, 90, 30);
        mostuser.setText("Mostrar");
        mostuser.addActionListener(this); 
      //*************************************
                
        cargaMasiva.setBounds(10, 70, 120, 30);
        cargaMasiva.setText("Carga Masiva"); 
        cargaMasiva.addActionListener(this);
        
        cargaIndividual.setBounds(160, 70, 130, 30);
        cargaIndividual.setText("Carga Individual");
        cargaIndividual.addActionListener(this);
        
        biblio.add(cargaMasiva);
        biblio.add(cargaIndividual);
        user.add(mostuser);
        user.add(deluser);
        user.add(moduser);
        this.add(logout);
        this.add(biblio);
        this.add(user);
        this.add(logo);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if(e.getSource()==moduser){
            this.dispose();
            ModificarUser modificar = new ModificarUser();
            modificar.setVisible(true);
        }
        if(e.getSource()==deluser){
            this.dispose();
            EliminarUser delete = new EliminarUser();
            delete.setVisible(true);
        }
        if(e.getSource()==mostuser){
            this.dispose();
            MostrarUser mostrar = new MostrarUser();
            mostrar.setVisible(true);
        }
        if(e.getSource()==cargaIndividual){
            this.dispose();
            CrearBook crear = new CrearBook(); 
            crear.setVisible(true);
        }
        if(e.getSource()==cargaMasiva){
            this.dispose();
            CargaMasiva carga = new CargaMasiva();
            carga.setVisible(true);
        } 
    }
}
