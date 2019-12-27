package biblioteca;

import static biblioteca.CrearBook.vectorDocumentos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VerDocumento extends javax.swing.JFrame implements  ActionListener{
    JButton prestar,logout;
    JLabel id,titulo,autor,paginas,tema,estado;
    int filaseleccionada;
    static PrestamoUser [] vectorPrestamos=new PrestamoUser[100];
    int counter=0;
    JLabel nombre;
    String tipo;
    public VerDocumento(){
        super("Vista de Libro");
        prestar = new JButton();
        logout = new JButton();
        id = new JLabel();
        titulo = new JLabel();
        autor = new JLabel();
        paginas = new JLabel();
        nombre = new JLabel();
        tema = new JLabel();
        estado = new JLabel();
        nombre = new JLabel();
        inicializarComponentes();
        
    }
    public void inicializarComponentes(){
        this.setSize(400,400); 
        this.setLayout(null);
        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        //--------------------------------------------------------------
        logout.setBounds(280, 10, 90, 20);
        logout.setText("Logout");
        logout.addActionListener(this);
        //--------------------------------------------------------------
        prestar.setText("Prestar");
        prestar.setBounds(280, 300, 90, 20);
        prestar.addActionListener(this);
        //--------------------------------------------------------------
        nombre.setBounds(10, 10, 100, 30); 
        
        id.setBounds(10, 50, 200, 50);
        id.setFont(new java.awt.Font("Bradley Hand ITC",Font.BOLD,20));
        
        
        titulo.setBounds(10, 80, 200, 50);
        titulo.setFont(new java.awt.Font("Bradley Hand ITC",Font.BOLD,20));
        
        
        autor.setBounds(10, 110, 200, 50);
        autor.setFont(new java.awt.Font("Bradley Hand ITC",Font.BOLD,20));
       
        
        paginas.setBounds(10, 140, 200, 50);
        paginas.setFont(new java.awt.Font("Bradley Hand ITC",Font.BOLD,20));
        
        
        tema.setBounds(10, 170, 130, 50);
        tema.setFont(new java.awt.Font("Bradley Hand ITC",Font.BOLD,20));
        
        
        estado.setBounds(10, 200, 200, 50);
        estado.setFont(new java.awt.Font("Bradley Hand ITC",Font.BOLD,20));
       
        //--------------------------------------------------------------
        
        add(nombre);
        add(id);
        add(logout);
        add(prestar);
        add(titulo);
        add(autor);
        add(paginas);
        add(tema);
        add(estado);
    } 
    public void prestar(){
        String auxiliar = id.getText();
        String Titulo = titulo.getText();
        String Autor = autor.getText();
        String[] Id = auxiliar.split(": ");
        String[] tit = Titulo.split(": ");
        String[] aut = Autor.split(": ");
        String name = nombre.getText();
        System.out.println("Counter "+counter);
        counter++;
        System.out.println("Id "+Id+" titulo "+tit+" aut "+ autor);
        vectorPrestamos[counter] = new PrestamoUser(name,Id[1],aut[1],getTipo(),tit[1]);
        System.out.println("Se guardo");
        System.out.println("id "+vectorPrestamos[counter].getIdUser()+"idLibro "+vectorPrestamos[counter].getIdDocumento()+"tipo "+vectorPrestamos[counter].getTipo());
        counter++;
        try{
            for (int i = 0; i < 10; i++) { 
                if(vectorDocumentos[i].getId().equals(Id[1])){
                    vectorDocumentos[i].setEstado("Prestado");
                    estado.setText("Estado: "+vectorDocumentos[i].getEstado());
                    
                }
            }
            
            
        }catch(Exception e){
            
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==prestar){
            prestar();
            ConsultaDocumento consulta = new ConsultaDocumento();
            consulta.mostrarEnTabla();
            
        }
        if(e.getSource()==logout){
            int log = JOptionPane.showConfirmDialog(null, "Seguro que desea Salir?");
            if(log==0){
                this.dispose();
                Loggin loggin = new Loggin();
                loggin.setVisible(true);
            }
            if(log ==1){
                JOptionPane.showMessageDialog(null, "Quedate ps");
            }
        }
    }
}
