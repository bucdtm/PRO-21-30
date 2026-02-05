public class Coche {
    String marca;
    String modelo;
    int anyo;
    String anyoString;

    public Coche(String marca, String modelo, int anyo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }

    public Coche(String marca, String modelo, String anyoString) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = Integer.parseInt(anyoString);
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", anyo: " + anyo;
    }

    public String mostrarCoche() {
        return this.toString();
    }

    public String claxon(){
        return "piiiiii, piiiiii";
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return anyo;
    }

    public boolean setAnyo(int anyo) {
        if (anyo < 1900){
            return false;
        }else{
            this.anyo = anyo;
            return true;
        }
    }

    public boolean setAnyoString(String anyoString) {
        if (anyo < 1900){
            return false;
        }else{
            this.anyo = Integer.parseInt(anyoString);
            return true;
        }
    }
}
