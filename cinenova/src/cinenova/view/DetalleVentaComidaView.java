package cinenova.view;

import cinenova.model.DetalleVentaComida;
import java.util.List;
import java.util.Scanner;

public class DetalleVentaComidaView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE DETALLES DE COMIDA ---");
        System.out.println("1. Crear Detalle");
        System.out.println("2. Leer Detalles");
        System.out.println("3. Actualizar Detalle");
        System.out.println("4. Eliminar Detalle");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public DetalleVentaComida capturarDatosDetalle() {
        DetalleVentaComida detalle = new DetalleVentaComida();
        System.out.print("ID de Venta: ");
        detalle.setIdVenta(scanner.nextInt());
        System.out.print("ID de Producto: ");
        detalle.setIdProducto(scanner.nextInt());
        System.out.print("Cantidad: ");
        detalle.setCantidad(scanner.nextInt());
        System.out.print("Subtotal: ");
        detalle.setSubtotal(scanner.nextDouble());
        return detalle;
    }

    public void mostrarDetalles(List<DetalleVentaComida> detalles) {
        for (DetalleVentaComida d : detalles) {
            System.out.println("ID Detalle: " + d.getIdDetalleComida() + " | Venta: " + d.getIdVenta() + 
                               " | Producto: " + d.getIdProducto() + " | Cantidad: " + d.getCantidad() + 
                               " | Subtotal: ₡" + d.getSubtotal());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID del Detalle de Comida: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}