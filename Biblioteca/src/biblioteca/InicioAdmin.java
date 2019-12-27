package biblioteca;
import static biblioteca.CrearBook.vectorDocumentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class InicioAdmin extends javax.swing.JFrame implements ActionListener{
    JButton reportes,crear;
    public InicioAdmin(){
        reportes = new JButton();
        crear = new JButton();
       inicializarComponentes();
    }
    public void inicializarComponentes(){
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        
        reportes.setBounds(50, 100, 180, 80);
        reportes.setText("Reportes");
        reportes.addActionListener(this);
        
        crear.setBounds(260, 100, 180, 80);
        crear.setText("Libros/Usuarios");
        crear.addActionListener(this);
        
        add(reportes);
        add(crear);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==reportes){
            this.dispose();
            Reporte reporte = new Reporte();
            reporte.setVisible(true);
        }
        if(e.getSource()==crear){
            this.dispose();
            Admin admin = new Admin();
            admin.setVisible(true);
        }
    }
}
