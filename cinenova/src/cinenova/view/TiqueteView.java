package cinenova.view;

import cinenova.model.Tiquete;
import java.util.List;
import java.util.Scanner;

public class TiqueteView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE TIQUETES ---");
        System.out.println("1. Crear Tiquete");
        System.out.println("2. Leer Tiquetes");
        System.out.println("3. Actualizar Tiquete");
        System.out.println("4. Eliminar Tiquete");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Tiquete capturarDatosTiquete() {
        Tiquete tiquete = new Tiquete();
        System.out.print("ID de Venta: ");
        tiquete.setIdVenta(scanner.nextInt());
        System.out.print("ID de Función: ");
        tiquete.setIdFuncion(scanner.nextInt());
        System.out.print("ID de Asiento: ");
        tiquete.setIdAsiento(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Tipo de Tiquete (Adulto, Niño, etc.): ");
        tiquete.setTipoTiquete(scanner.nextLine());
        System.out.print("Precio: ");
        tiquete.setPrecio(scanner.nextDouble());
        return tiquete;
    }

    public void mostrarTiquetes(List<Tiquete> tiquetes) {
        for (Tiquete t : tiquetes) {
            System.out.println("ID: " + t.getIdTiquete() + " | Venta: " + t.getIdVenta() + 
                               " | Función: " + t.getIdFuncion() + " | Asiento: " + t.getIdAsiento() + 
                               " | Precio: ₡" + t.getPrecio());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID del Tiquete: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}