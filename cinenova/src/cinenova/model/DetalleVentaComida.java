package cinenova.model;

public class DetalleVentaComida {
    private int idDetalleComida;
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double subtotal;

    public DetalleVentaComida() {
    }

    public DetalleVentaComida(int idDetalleComida, int idVenta, int idProducto, int cantidad, double subtotal) {
        this.idDetalleComida = idDetalleComida;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalleComida() {
        return idDetalleComida;
    }

    public void setIdDetalleComida(int idDetalleComida) {
        this.idDetalleComida = idDetalleComida;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}