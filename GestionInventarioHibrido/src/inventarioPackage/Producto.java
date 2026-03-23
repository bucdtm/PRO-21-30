package inventarioPackage;

public class Producto implements Vendible{
    String nombre;
    int stock;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    @Override
    public void realizarVenta(){
        if (stock > 0) {
            stock = stock-1;
        } else if (stock == 0) {
            System.err.println("Error: Stock agotado para "+this.nombre);
        }
    }

    @Override
    public boolean estaDisponible() {
        if(stock > 0){
            return true;
        }
        else {
            return false;
        }
    }
    public String toString() {
        return "Producto: "+nombre+" (stock: "+ stock +")";
    }
}
