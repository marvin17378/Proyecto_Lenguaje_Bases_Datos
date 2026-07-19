package cinenova.view;

import cinenova.model.Asiento;
import java.util.List;
import java.util.Scanner;

public class AsientoView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE ASIENTOS ---");
        System.out.println("1. Crear Asiento");
        System.out.println("2. Leer Asientos");
        System.out.println("3. Actualizar Asiento");
        System.out.println("4. Eliminar Asiento");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Asiento capturarDatosAsiento() {
        Asiento asiento = new Asiento();
        System.out.print("ID de la Sala: ");
        asiento.setIdSala(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Fila (Ej. A, B, C): ");
        asiento.setFila(scanner.nextLine());
        System.out.print("Número: ");
        asiento.setNumero(scanner.nextInt());
        return asiento;
    }

    public void mostrarAsientos(List<Asiento> asientos) {
        for (Asiento a : asientos) {
            System.out.println("ID: " + a.getIdAsiento() + " | ID Sala: " + a.getIdSala() + 
                               " | Fila: " + a.getFila() + " | Número: " + a.getNumero());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID del Asiento: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}