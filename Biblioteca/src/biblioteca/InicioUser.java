package biblioteca;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InicioUser extends javax.swing.JFrame implements ActionListener {

    JLabel consulta, misPrestamos;
    JLabel fondo;
    JPanel panel;
    ImageIcon icono, consult, prestamo;
    JLabel nombre;
    public InicioUser() {
        consulta = new JLabel();
        misPrestamos = new JLabel();
        panel = new JPanel();
        fondo = new JLabel();
        nombre = new JLabel();
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        //------------------------------------------------------- 
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setLayout(null);
        //-------------------------------------------------------
        consulta.setBounds(50, 100, 180, 80);
        consult = new ImageIcon(getClass().getResource("/Imagenes/consulta.png"));
        consult = new ImageIcon(consult.getImage().getScaledInstance(consulta.getWidth(), consulta.getHeight(), Image.SCALE_DEFAULT));
        consulta.setIcon(consult);
        consulta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                ConsultaDocumento consult = new ConsultaDocumento();
                consult.nombre.setText(nombre.getText());
                consult.setVisible(true);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //-------------------------------------------------------
        misPrestamos.setBounds(260, 100, 180, 80);
        prestamo = new ImageIcon(getClass().getResource("/Imagenes/prestamos.jpg"));
        prestamo = new ImageIcon(prestamo.getImage().getScaledInstance(misPrestamos.getWidth(), misPrestamos.getHeight(), Image.SCALE_DEFAULT));
        misPrestamos.setIcon(prestamo);
        misPrestamos.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); 
                Prestamos prestamos = new Prestamos();
                prestamos.nombre.setText(nombre.getText());
                prestamos.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //-------------------------------------------------------
        nombre.setBounds(10, 10, 100, 20); 
        nombre.setForeground(Color.WHITE);
        //-------------------------------------------------------
        fondo.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        icono = new ImageIcon(getClass().getResource("/Imagenes/libros.jpg"));
        icono = new ImageIcon(icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        //-------------------------------------------------------
        panel.add(nombre);
        panel.add(misPrestamos);
        panel.add(consulta);
        panel.add(fondo);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consulta) {

        }
    }
}
