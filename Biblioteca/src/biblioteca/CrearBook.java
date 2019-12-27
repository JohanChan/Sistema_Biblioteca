package biblioteca;

import java.awt.Color;
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

public class CrearBook extends javax.swing.JFrame implements ActionListener {

    JButton regresar, filtro;
    public static Documento[] vectorDocumentos = new Documento[200];
    JComboBox tipo;
    JLabel compa, fecha, grado, anio;
    JLabel id, titulo, autor, tema, pagina;
    JTextField txtid, txttitulo, txtautor, txttema, txtpagina;
    JTextField txtcompa, txtfecha, txtgrado, txtanio;
    JButton modificar, nuevo, eliminar, crear, aceptar;
    JTable tabla;
    DefaultTableModel stm;
    String[] header = {"Tipo", "ID", "Titulo", "Autor", "Tema", "# de Paginas"};
    String dato[][] = {};
    JScrollPane contenedor;
    int counter = 0;
    int contador = 0;

    public CrearBook() {
        filtro = new JButton();
        regresar = new JButton();
        txtcompa = new JTextField();
        txtfecha = new JTextField();
        txtgrado = new JTextField();
        txtanio = new JTextField();
        compa = new JLabel();
        fecha = new JLabel();
        grado = new JLabel();
        anio = new JLabel();
        contenedor = new JScrollPane();
        stm = new DefaultTableModel(dato, header);
        id = new JLabel();
        titulo = new JLabel();
        autor = new JLabel();
        tema = new JLabel();
        pagina = new JLabel();
        txtid = new JTextField();
        txttitulo = new JTextField();
        txtautor = new JTextField();
        txttema = new JTextField();
        txtpagina = new JTextField();
        modificar = new JButton();
        nuevo = new JButton();
        eliminar = new JButton();
        tabla = new JTable();
        crear = new JButton();
        aceptar = new JButton();
        tipo = new JComboBox();
        inicializadorComponentes();
    }

    public void inicializadorComponentes() {
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //--------------------------------------------------
        tipo.setBounds(10, 10, 90, 20);
        tipo.addItem("Libro");
        tipo.addItem("Revista");
        tipo.addItem("Tesis");

        id.setBounds(10, 40, 90, 20);
        id.setText("Id");

        titulo.setBounds(10, 70, 90, 20);
        titulo.setText("Titulo");

        autor.setBounds(10, 100, 90, 20);
        autor.setText("Autor");

        tema.setBounds(10, 130, 90, 20);
        tema.setText("Tema");

        pagina.setBounds(10, 160, 90, 20);
        pagina.setText("# Pagina");

        compa.setBounds(10, 190, 90, 20);
        compa.setText("Compania");

        fecha.setBounds(10, 220, 90, 20);
        fecha.setText("Fecha");

        grado.setBounds(10, 250, 90, 20);
        grado.setText("Grado");

        anio.setBounds(10, 280, 90, 20);
        anio.setText("Anio");
        //--------------------------------------------------
        txtid.setBounds(110, 40, 90, 20);

        txttitulo.setBounds(110, 70, 90, 20);

        txtautor.setBounds(110, 100, 90, 20);

        txttema.setBounds(110, 130, 90, 20);

        txtpagina.setBounds(110, 160, 90, 20);

        txtcompa.setBounds(110, 190, 90, 20);

        txtfecha.setBounds(110, 220, 90, 20);

        txtgrado.setBounds(110, 250, 90, 20);

        txtanio.setBounds(110, 280, 90, 20);

        //-------------------------------------------------
        modificar.setBounds(10, 340, 90, 30);
        modificar.setText("Modificar");
        modificar.addActionListener(this);

        nuevo.setBounds(120, 340, 90, 30);
        nuevo.setText("Obtener");
        nuevo.addActionListener(this);

        eliminar.setBounds(10, 380, 90, 30);
        eliminar.setText("Eliminar");
        eliminar.addActionListener(this);

        crear.setBounds(120, 380, 90, 30);
        crear.setText("Crear");
        crear.addActionListener(this);

        aceptar.setBounds(120, 10, 100, 20);
        aceptar.setText("Aceptar");
        aceptar.addActionListener(this);

        regresar.setBounds(690, 10, 90, 30);
        regresar.setText("Regresar");
        regresar.addActionListener(this);

        filtro.setBounds(60, 420, 90, 30);
        filtro.setText("Filtros");
        filtro.addActionListener(this);
        //---------------------------------------------------

        tabla.setBounds(250, 60, 520, 380);
        tabla.setModel(stm);
        contenedor.setBounds(250, 60, 520, 380);
        add(contenedor);
        contenedor.setViewportView(tabla);
        //---------------------------------------------------
        enableFalse();

        add(filtro);
        add(id);
        add(titulo);
        add(autor);
        add(tema);
        add(pagina);
        add(tipo);
        add(compa);
        add(fecha);
        add(grado);
        add(anio);
        add(regresar);
        add(txtid);
        add(txttitulo);
        add(txtautor);
        add(txtpagina);
        add(txttema);
        add(txtcompa);
        add(txtfecha);
        add(txtgrado);
        add(txtanio);
        add(modificar);
        add(nuevo);
        add(eliminar);
        add(crear);
        add(aceptar);

        add(contenedor);
    }

    public void guardarDocumentos() {
        String estado = "Disponible";
        String tip = tipo.getSelectedItem().toString();
        String ident = txtid.getText();
        String tit = txttitulo.getText();
        String aut = txtautor.getText();
        String tem = txttema.getText();
        String page = txtpagina.getText();
        String compan = txtcompa.getText();
        String date = txtfecha.getText();
        String grade = txtgrado.getText();
        String an = txtanio.getText();
        vectorDocumentos[counter] = new Documento(ident, tit, tem, page, compan, date,
                grade, an, aut, tip,estado);
        counter += 1;
        JOptionPane.showMessageDialog(null, tip + " Guarda Exitosamente");
        txtid.setText("");
        txttitulo.setText("");
        txtautor.setText("");
        txttema.setText("");
        txtpagina.setText("");
        txtcompa.setText("");
        txtfecha.setText("");
        txtgrado.setText("");
        txtanio.setText("");
        txtid.requestFocus();
    }

    public void tipo() {
        int eleccion = tipo.getSelectedIndex();
        System.out.println(eleccion);
        switch (eleccion) {
            case 0:
                txtid.setEnabled(true);
                txttitulo.setEnabled(true);
                txtautor.setEnabled(true);
                txttema.setEnabled(true);
                txtpagina.setEnabled(true);

                txtcompa.setEnabled(false);
                txtfecha.setEnabled(false);
                txtanio.setEnabled(false);
                txtgrado.setEnabled(false);
                break;
            case 1:
                txtid.setEnabled(true);
                txttitulo.setEnabled(true);
                txttema.setEnabled(true);
                txtcompa.setEnabled(true);
                txtfecha.setEnabled(true);

                txtautor.setEnabled(false);
                txtpagina.setEnabled(false);
                txtanio.setEnabled(false);
                txtgrado.setEnabled(false);
                break;
            case 2:
                txtid.setEnabled(true);
                txttitulo.setEnabled(true);
                txtautor.setEnabled(true);
                txttema.setEnabled(true);
                txtgrado.setEnabled(true);
                txtanio.setEnabled(true);

                txtcompa.setEnabled(false);
                txtfecha.setEnabled(false);
                txtpagina.setEnabled(false);
                break;
        }
    }

    public void enableFalse() {
        txtid.setEnabled(false);

        txttitulo.setEnabled(false);

        txtautor.setEnabled(false);

        txttema.setEnabled(false);

        txtpagina.setEnabled(false);

        txtcompa.setEnabled(false);

        txtfecha.setEnabled(false);

        txtgrado.setEnabled(false);

        txtanio.setEnabled(false);
    }

    public void enableTrue() {
        txtid.setEnabled(true);

        txttitulo.setEnabled(true);

        txtautor.setEnabled(true);

        txttema.setEnabled(true);

        txtpagina.setEnabled(true);

        txtcompa.setEnabled(true);

        txtfecha.setEnabled(true);

        txtgrado.setEnabled(true);

        txtanio.setEnabled(true);
    }

    public void mostrarEnTabla() {
        limpiarTabla(tabla);
        try {
            for (int i = 0; i < 200; i++) {
                String[] libro = {vectorDocumentos[i].getTipo(), vectorDocumentos[i].getId(), vectorDocumentos[i].getTitulo(), vectorDocumentos[i].getAutor(),
                     vectorDocumentos[i].getTema(), vectorDocumentos[i].getPaginas()};
                stm.addRow(libro);
            }

        } catch (Exception ae) {
            System.out.println(ae.getMessage());
        }

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

    public void obtenerDocumentos() {
        int filaseleccionada = tabla.getSelectedRow();
        if (filaseleccionada >= 0) {
            txtid.setText(tabla.getValueAt(filaseleccionada, 1).toString());
            txttitulo.setText(tabla.getValueAt(filaseleccionada, 2).toString());
            txtautor.setText(tabla.getValueAt(filaseleccionada, 3).toString());
            txttema.setText(tabla.getValueAt(filaseleccionada, 4).toString());
            txtpagina.setText(tabla.getValueAt(filaseleccionada, 5).toString());
            //txtautor.setText(tabla.getValueAt(filaseleccionada, 6).toString());
            stm.removeRow(filaseleccionada);

        }
    }

    public void modificarDocumentos() {
        String tip = tipo.getSelectedItem().toString();
        String ident = txtid.getText();
        String tit = txttitulo.getText();
        String aut = txtautor.getText();
        String tem = txttema.getText();
        String page = txtpagina.getText();
        String compan = txtcompa.getText();
        String date = txtfecha.getText();
        String grade = txtgrado.getText();
        String an = txtanio.getText();
        System.out.println(ident);
        try {
            for (int i = 0; i < 200; i++) {
                if (vectorDocumentos[i].getId().equals(ident)) {
                    System.out.println(i);
                    vectorDocumentos[i].setId(ident);
                    vectorDocumentos[i].setTipo(tip);
                    vectorDocumentos[i].setTitulo(tit);
                    vectorDocumentos[i].setAutor(aut);
                    vectorDocumentos[i].setTema(tem);
                    vectorDocumentos[i].setPaginas(page);
                    vectorDocumentos[i].setCompa(compan);
                    vectorDocumentos[i].setDate(date);
                    vectorDocumentos[i].setGrado(grade);
                    vectorDocumentos[i].setYear(an);
                    JOptionPane.showMessageDialog(null, "Documento Modificado Correctamente");
                    txtid.setText("");
                    txttitulo.setText("");
                    txtautor.setText("");
                    txttema.setText("");
                    txtpagina.setText("");
                    txtcompa.setText("");
                    txtfecha.setText("");
                    txtgrado.setText("");
                    txtanio.setText("");
                    txtid.requestFocus();
                    mostrarEnTabla();
                }

            }
        } catch (Exception ae) {
            ae.getMessage();
        }
    }

    public void eliminarDocumentos() {
        String tip = tipo.getSelectedItem().toString();
        String ident = txtid.getText();
        String tit = txttitulo.getText();
        String aut = txtautor.getText();
        String tem = txttema.getText();
        String page = txtpagina.getText();
        String compan = txtcompa.getText();
        String date = txtfecha.getText();
        String grade = txtgrado.getText();
        String an = txtanio.getText();
        System.out.println(ident);
        try {
            for (int i = 0; i < 200; i++) {
                if (vectorDocumentos[i].getId().equals(ident)) {
                    System.out.println(i);
                    vectorDocumentos[i].setId(" ");
                    vectorDocumentos[i].setTipo(" ");
                    vectorDocumentos[i].setTitulo(" ");
                    vectorDocumentos[i].setAutor(" ");
                    vectorDocumentos[i].setTema(" ");
                    vectorDocumentos[i].setPaginas(" ");
                    vectorDocumentos[i].setCompa(" ");
                    vectorDocumentos[i].setDate(" ");
                    vectorDocumentos[i].setGrado(" ");
                    vectorDocumentos[i].setYear(" ");
                    JOptionPane.showMessageDialog(null, "Documento Eliminado Correctamente");
                    txtid.setText("");
                    txttitulo.setText("");
                    txtautor.setText("");
                    txttema.setText("");
                    txtpagina.setText("");
                    txtcompa.setText("");
                    txtfecha.setText("");
                    txtgrado.setText("");
                    txtanio.setText("");
                    txtid.requestFocus();
                    mostrarEnTabla();
                }

            }
        } catch (Exception ae) {
            ae.getMessage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            tipo();
        }
        if (e.getSource() == crear) {
            guardarDocumentos();
            mostrarEnTabla();
        }
        if (e.getSource() == nuevo) {
            enableTrue();
            txtid.setEnabled(false);
            obtenerDocumentos();
        }
        if (e.getSource() == modificar) {
            modificarDocumentos();
        }
        if (e.getSource() == eliminar) {
            eliminarDocumentos();
        }
        if (e.getSource() == regresar) {
            this.dispose();
            Admin admin = new Admin();
            admin.setVisible(true);
        }
        if (e.getSource() == filtro) {
            this.dispose();
            MostrarLibro mostrar = new MostrarLibro();
            mostrar.setVisible(true);
        }
    }
}
