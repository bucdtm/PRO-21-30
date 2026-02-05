public class Libro {
    String codigo;
    String titulo;
    String autor;
    int numeroPag;


    public Libro(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = "No name";
        this.numeroPag = 0;
    }
    public Libro(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPag = 0;
    }

    public Libro(String codigo, String titulo, String autor, int numeroPag) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPag = numeroPag;
        if (numeroPag < 0) numeroPag = 0;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo + "\nAutor: " + this.autor + "\nCódigo: " + this.codigo;
    }

    public String mostrarLibro() {
        return this.toString();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }
}
