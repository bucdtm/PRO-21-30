public class Main{
    public static void main(String[] args) {

        Libro l1 = new Libro("ISBN-1234", "IT");
        Libro l2 = new Libro("ISBN-1234", "Harry Potter", "J.K. Rowling");
        Libro l3 = new Libro("ISBN-1234", "A Song Of Fire And Ice", "George R.R. Martin", 1200);
        Libro l4 = new Libro("ISBN-1234", "Desconocido", "Null", -1);

        System.out.println(l1.mostrarLibro());
        System.out.println();
        System.out.println(l2.mostrarLibro());
        System.out.println();
        System.out.println(l3.mostrarLibro());
        System.out.println();
        System.out.println(l4.mostrarLibro());

    }
}