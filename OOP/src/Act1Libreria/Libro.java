package Act1Libreria;

public class Libro {

    private String codigo, titulo, autor;
    private int paginas;

    public Libro(String codigo, String titulo){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = "No Name";
        this.paginas = 0;
    }
    public Libro(String codigo, String titulo, String autor){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = 0;
    }
    public Libro(String codigo, String titulo, String autor, int paginas){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;

        if (paginas < 0){
            paginas = 0;
        }
    }
}
