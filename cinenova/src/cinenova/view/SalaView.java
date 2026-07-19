package cinenova.view;

import cinenova.model.Sala;
import java.util.List;
import java.util.Scanner;

public class SalaView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE SALAS ---");
        System.out.println("1. Crear Sala");
        System.out.println("2. Leer Salas");
        System.out.println("3. Actualizar Sala");
        System.out.println("4. Eliminar Sala");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Sala capturarDatosSala() {
        Sala sala = new Sala();
        System.out.print("Número de Sala: ");
        sala.setNumeroSala(scanner.nextInt());
        System.out.print("Capacidad Total: ");
        sala.setCapacidadTotal(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Tipo de Sala (2D/3D/VIP): ");
        sala.setTipoSala(scanner.nextLine());
        return sala;
    }

    public void mostrarSalas(List<Sala> salas) {
        for (Sala s : salas) {
            System.out.println("ID: " + s.getIdSala() + " | Número: " + s.getNumeroSala() + 
                               " | Capacidad: " + s.getCapacidadTotal() + " | Tipo: " + s.getTipoSala());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID de la Sala: ");
        return scanner.nextInt();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}