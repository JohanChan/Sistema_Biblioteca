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

public class ConsultaDocumento extends javax.swing.JFrame implements ActionListener {
    VerDocumento verdoc;
    JTable tabla;
    JComboBox filtro;
    JTextField txtbuscar;
    JButton mostrar, regresar, buscar, logout, ver, atras;
    DefaultTableModel stm;
    String[] header = {"Tipo", "ID", "Titulo", "Autor", "Estado"};
    String dato[][] = {};
    JScrollPane contenedor;
    int filaselect;
    JLabel nombre;
    
    public ConsultaDocumento() {
        super("Consulta y Prestamos de Libros");
        verdoc = new VerDocumento();
        ver = new JButton();
        atras = new JButton();
        logout = new JButton();
        mostrar = new JButton();
        filtro = new JComboBox();
        tabla = new JTable();
        buscar = new JButton();
        txtbuscar = new JTextField();
        contenedor = new JScrollPane();
        nombre = new JLabel();
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
        filtro.setBounds(10, 70, 90, 30);
        filtro.addItem("Libro");
        filtro.addItem("Revista");
        filtro.addItem("Tesis");
        //-------------------------------------------------
        txtbuscar.setBounds(600, 70, 120, 30);
        //-------------------------------------------------
        mostrar.setBounds(120, 70, 90, 30);
        mostrar.setText("Mostrar");
        mostrar.addActionListener(this);

        ver.setBounds(280, 70, 90, 30);
        ver.setText("Ver");
        ver.addActionListener(this);

        atras.setBounds(10, 430, 90, 30);
        atras.setText("Regresar");
        atras.addActionListener(this);

        logout.setBounds(630, 10, 90, 30);
        logout.setText("Logout");
        logout.addActionListener(this);

        buscar.setBounds(500, 70, 90, 30);
        buscar.setText("Buscar");
        buscar.addActionListener(this);
        //-------------------------------------------------
        nombre.setBounds(10, 10, 100, 30);
         
        //-------------------------------------------------
        tabla.setBounds(10, 120, 730, 300);
        tabla.setModel(stm);
        contenedor.setBounds(tabla.getX(), tabla.getY(), tabla.getWidth(), tabla.getHeight());
        add(contenedor);
        contenedor.setViewportView(tabla);
        //-------------------------------------------------
        add(nombre);
        add(logout);
        add(ver);
        add(atras);
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
                    
                    String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor(),
                    vectorDocumentos[i].getEstado()};
                    stm.addRow(libro);

                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void buscar() {
        limpiarTabla(tabla);
        String titulo = txtbuscar.getText();
        try {
            for (int i = 0; i < 200; i++) {
                if (vectorDocumentos[i].getTitulo().equals(titulo)) {
                    String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor(),
                    vectorDocumentos[i].getEstado()};
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
                String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor(),
                    vectorDocumentos[i].getEstado()};
                stm.addRow(libro);
            }

        } catch (Exception ae) {
            System.out.println(ae.getMessage());
        }

    }
    
    public void obtenerDocumentos() {
        filaselect = tabla.getSelectedRow();
        if (filaselect >= 0) {
            try{
                for (int i = 0; i < 50; i++) {
                    if(vectorDocumentos[i].getId().equals(tabla.getValueAt(filaselect, 1).toString())){
                        
                        verdoc.id.setText("Id: "+vectorDocumentos[i].getId());
                        verdoc.titulo.setText("Titulo: "+vectorDocumentos[i].getTitulo());
                        verdoc.autor.setText("Autor: "+vectorDocumentos[i].getAutor());
                        verdoc.paginas.setText("No. Paginas: "+vectorDocumentos[i].getPaginas());
                        verdoc.tema.setText("Tema: "+vectorDocumentos[i].getTema());
                        verdoc.estado.setText("Estado: "+vectorDocumentos[i].getEstado());
                        verdoc.nombre.setText(nombre.getText());
                        verdoc.setTipo(vectorDocumentos[i].getTipo());
                                
                    } 
                }
            }catch(Exception e){
                
            }

        }
    }
   
   
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea Salir?");
            if (opcion == 0) {
                this.dispose();
                Loggin log = new Loggin();
                log.setVisible(true);
            }
        }
        if (e.getSource() == mostrar) {
            filtro();
        }
        if (e.getSource() == buscar) {
            buscar();
        }
        if (e.getSource() == atras) {
            this.dispose();
            InicioUser inicio = new InicioUser(); 
            inicio.nombre.setText(nombre.getText());
            inicio.setVisible(true);
        }
        if (e.getSource() == ver) {
            obtenerDocumentos();
            verdoc.setVisible(true);
        }
    }
    
}

