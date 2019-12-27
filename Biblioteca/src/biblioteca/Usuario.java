package biblioteca;

public class Usuario {
    String nombre;
    long id;
    String pass;
    String usuario;
    String apellido;
    public Usuario(String nombre,String apellido ,long id, String pass,String usuario){
        this.nombre=nombre;
        this.id=id;
        this.pass=pass;
        this.usuario=usuario;
        this.apellido=apellido;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
