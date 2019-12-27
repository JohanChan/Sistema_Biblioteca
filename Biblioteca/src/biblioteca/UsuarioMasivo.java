
package biblioteca;


public class UsuarioMasivo {
    String pass;
    String usuario;
    String apellido;
    String nombre;
    public UsuarioMasivo(String usuario, String apellido, String nombre, String pass){
        this.nombre=nombre;
        this.pass=pass;
        this.usuario=usuario;
        this.apellido=apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
