package biblioteca;


public class PrestamoUser {
    String User;
    String idDocumento,autor,tipo,titulo;
    public PrestamoUser(String User, String idDocumento,String autor,String tipo,String titulo){
        this.User=User;
        this.idDocumento=idDocumento;
        this.autor=autor;
        this.tipo=tipo;
        this.titulo=titulo;
    }

    public String getIdUser() {
        return User;
    }

    public void setIdUser(String idUser) {
        this.User = idUser;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
