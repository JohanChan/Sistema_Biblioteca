package biblioteca;

import static biblioteca.CrearBook.vectorDocumentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MostrarLibro extends JFrame implements ActionListener {

    JTable tabla;
    JComboBox filtro;
    JTextField txtbuscar;
    JButton mostrar, regresar, buscar;
    DefaultTableModel stm;
    String[] header = {"Tipo", "ID", "Titulo", "Autor", "Estado"};
    String dato[][] = {};
    JScrollPane contenedor;
    JLabel nombre;
    public MostrarLibro() {
        nombre = new JLabel();
        mostrar = new JButton();
        regresar = new JButton();
        filtro = new JComboBox();
        tabla = new JTable();
        buscar = new JButton();
        txtbuscar = new JTextField();
        contenedor = new JScrollPane();
        stm = new DefaultTableModel(dato, header);
        inicializarComponentes();
        mostrarEnTabla();
    }

    public void inicializarComponentes() {
        this.setSize(750, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //-------------------------------------------------
        filtro.setBounds(10, 10, 90, 30);
        filtro.addItem("Libro");
        filtro.addItem("Revista");
        filtro.addItem("Tesis");
        //-------------------------------------------------
        txtbuscar.setBounds(600, 10, 120, 30);
        //-------------------------------------------------
        mostrar.setBounds(130, 10, 90, 30);
        mostrar.setText("Mostrar");
        mostrar.addActionListener(this);

        regresar.setBounds(10, 375, 90, 30);
        regresar.setText("Regresar");
        regresar.addActionListener(this);

        buscar.setBounds(500, 10, 90, 30);
        buscar.setText("Buscar");
        buscar.addActionListener(this);
        //-------------------------------------------------
        tabla.setBounds(10, 70, 730, 300);
        tabla.setModel(stm);
        contenedor.setBounds(10, 70, tabla.getWidth(), tabla.getHeight());
        add(contenedor);
        contenedor.setViewportView(tabla);
        
        nombre.setBounds(10, 10, 100, 20); 
        //-------------------------------------------------
        
        add(nombre);
        add(regresar);
        add(buscar);
        add(txtbuscar);
        add(mostrar);
        add(filtro);

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

    public void filtro() {
        limpiarTabla(tabla);
        String eleccion = filtro.getSelectedItem().toString();
        System.out.println(eleccion);
        try {
            for (int i = 0; i < 200; i++) {
                if (vectorDocumentos[i].getTipo().equals(eleccion)) {
                    
                    String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor()};
                    stm.addRow(libro);

                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void buscarPorTitulo() {
        limpiarTabla(tabla);
        String titulo = txtbuscar.getText();
        try {
            for (int i = 0; i < 200; i++) {
                if (vectorDocumentos[i].getTitulo().equals(titulo)) {
                    String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor()};
                    stm.addRow(libro);

                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void mostrarEnTabla() {
        limpiarTabla(tabla);
        try {
            for (int i = 0; i < 200; i++) {
                String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor()};
                stm.addRow(libro);
            }

        } catch (Exception ae) {
            System.out.println(ae.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regresar) {
            this.dispose();
            CrearBook crear = new CrearBook();
            crear.setVisible(true);
        }
        if (e.getSource() == mostrar) {
            filtro();
        }
        if (e.getSource() == buscar) {
            buscarPorTitulo();
        }
    }
}
