package biblioteca;

public class Documento {

    //----------------------------------------------------------
    String id, titulo, autor, tema, paginas, compa, date, grado, year, tipo, estado;

    //----------------------------------------------------------
    public Documento(String id, String titulo, String tema, String paginas, String compa, String date,
            String grado, String year, String autor, String tipo, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
        this.paginas = paginas;
        this.compa = compa;
        this.date = date;
        this.grado = grado;
        this.year = year;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getCompa() {
        return compa;
    }

    public void setCompa(String compa) {
        this.compa = compa;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
