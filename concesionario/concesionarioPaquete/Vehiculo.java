package concesionarioPaquete;

class Vehiculo {
    String marca,modelo,color,matricula,descripcion;
    int km,precio;

    public Vehiculo(String marca, String modelo, String color, String matricula, int km, int precio, String descripcion) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
        this.km = km;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getMarca() {return marca;}

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {return color;}

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {return matricula;}

    public void setMatricula(String matricula) {
       this.matricula = matricula;
    }

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getKm() {return km;}

    public void setKm(int km) {
        this.km = km;
    }

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Matricula: " + matricula + ", Km: " + km + ", Precio: " + precio;
    }





}
