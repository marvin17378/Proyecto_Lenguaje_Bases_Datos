package cinenova.model;

public class Tiquete {
    private int idTiquete;
    private int idVenta;
    private int idFuncion;
    private int idAsiento;
    private String tipoTiquete;
    private double precio;

    public Tiquete() {
    }

    public Tiquete(int idTiquete, int idVenta, int idFuncion, int idAsiento, String tipoTiquete, double precio) {
        this.idTiquete = idTiquete;
        this.idVenta = idVenta;
        this.idFuncion = idFuncion;
        this.idAsiento = idAsiento;
        this.tipoTiquete = tipoTiquete;
        this.precio = precio;
    }

    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getTipoTiquete() {
        return tipoTiquete;
    }

    public void setTipoTiquete(String tipoTiquete) {
        this.tipoTiquete = tipoTiquete;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}