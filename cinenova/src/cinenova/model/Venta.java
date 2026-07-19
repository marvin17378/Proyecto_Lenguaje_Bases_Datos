package cinenova.model;

import java.time.LocalDateTime;

public class Venta {
    private int idVenta;
    private int idCliente;
    private int idEmpleado;
    private LocalDateTime fechaHora;
    private double totalPagar;
    private String metodoPago;

    public Venta() {
    }

    public Venta(int idVenta, int idCliente, int idEmpleado, LocalDateTime fechaHora, double totalPagar, String metodoPago) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fechaHora = fechaHora;
        this.totalPagar = totalPagar;
        this.metodoPago = metodoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}