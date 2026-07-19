package cinenova.model;

public class ProductoComida {
    private int idProducto;
    private String nombre;
    private int stockActual;
    private double precio;

    public ProductoComida() {
    }

    public ProductoComida(int idProducto, String nombre, int stockActual, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}