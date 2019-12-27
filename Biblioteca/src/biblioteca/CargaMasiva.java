package biblioteca;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CargaMasiva extends javax.swing.JFrame implements ActionListener{
    JTextArea texto;
    JButton atras;
    JButton aceptar;
    String textoingresado;
    static UsuarioMasivo[] vectormasivo = new UsuarioMasivo[10];
    static Documento[] vectormasivoDoc = new Documento[10];
    int indice=0;
    public CargaMasiva(){
        super("Carga Masiva");
        texto = new JTextArea();
        atras = new JButton();
        aceptar = new JButton();
        inicializarComponentes();
        
    }
    public void inicializarComponentes(){
        this.setSize(500, 430);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        
        texto.setBounds(10, 10, 460, 300);
        texto.setBackground(Color.BLACK);
        texto.setForeground(Color.WHITE); 
        
        atras.setBounds(10, 330, 100, 40);
        atras.setText("Atrás");
        atras.addActionListener(this);
        
        aceptar.setBounds(370, 330, 100, 40);
        aceptar.setText("Cargar");
        aceptar.addActionListener(this);
        
        add(texto);
        add(atras);
        add(aceptar);
    } 
    public void cargaMasiva(int counter){
        System.out.println("\n"+"\n"+"\n"+counter);
        textoingresado = texto.getText();
        String[] ayudante = textoingresado.split("\\|");
        System.out.println("Tam vector: "+ayudante.length);
        System.out.println("Dentro del vector"+ayudante[counter]);
        if(counter>=ayudante.length){
            System.out.println("Se paso jajaja");
        }else{
            int con = Integer.parseInt(ayudante[counter]);
            switch(con){
            case 0:
                System.out.println("Soy un Libro");
                
                
                cargaMasiva(counter);
                break;
            case 1:
                System.out.println("Soy una Revista");
                counter+=2;
                cargaMasiva(counter);
                break;
            case 2:
                System.out.println("Soy una Tesis");
                cargaMasiva(counter);
                break;
            case 3:
                System.out.println("Index "+indice);
                vectormasivo[indice]= new UsuarioMasivo(ayudante[counter+=1],ayudante[counter+=1],ayudante[counter+=1],ayudante[counter+=1]);
                System.out.println("Posicion "+indice+" Usuario "+vectormasivo[indice].getUsuario()+" Pass "+vectormasivo[indice].getPass());
                indice++;
                counter++;
                System.out.println("Index final "+counter);                
                cargaMasiva(counter);
                break;
        }
        }
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==atras){
           this.dispose();
           Admin admin = new Admin();
           admin.setVisible(true);
       }
       if(e.getSource()==aceptar){
           cargaMasiva(0);
       }
    }
    
}
