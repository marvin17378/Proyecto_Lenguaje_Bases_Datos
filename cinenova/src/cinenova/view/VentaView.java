package cinenova.view;

import cinenova.model.Venta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VentaView {
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE VENTAS ---");
        System.out.println("1. Crear Venta");
        System.out.println("2. Leer Ventas");
        System.out.println("3. Actualizar Venta");
        System.out.println("4. Eliminar Venta");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Venta capturarDatosVenta() {
        Venta venta = new Venta();
        System.out.print("ID de Cliente: ");
        venta.setIdCliente(scanner.nextInt());
        System.out.print("ID de Empleado: ");
        venta.setIdEmpleado(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Fecha y Hora (yyyy-MM-dd HH:mm:ss): ");
        venta.setFechaHora(LocalDateTime.parse(scanner.nextLine(), timeFormatter));
        System.out.print("Total a Pagar: ");
        venta.setTotalPagar(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Método de Pago: ");
        venta.setMetodoPago(scanner.nextLine());
        return venta;
    }

    public void mostrarVentas(List<Venta> ventas) {
        for (Venta v : ventas) {
            System.out.println("ID: " + v.getIdVenta() + " | Cliente: " + v.getIdCliente() + 
                               " | Empleado: " + v.getIdEmpleado() + " | Total: ₡" + v.getTotalPagar());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID de la Venta: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}