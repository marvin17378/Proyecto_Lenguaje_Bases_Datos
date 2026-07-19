package cinenova.view;

import cinenova.model.Funcion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class FuncionView {
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE FUNCIONES ---");
        System.out.println("1. Crear Función");
        System.out.println("2. Leer Funciones");
        System.out.println("3. Actualizar Función");
        System.out.println("4. Eliminar Función");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Funcion capturarDatosFuncion() {
        Funcion funcion = new Funcion();
        System.out.print("ID de Película: ");
        funcion.setIdPelicula(scanner.nextInt());
        System.out.print("ID de Sala: ");
        funcion.setIdSala(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Fecha (yyyy-MM-dd): ");
        funcion.setFecha(LocalDate.parse(scanner.nextLine(), dateFormatter));
        System.out.print("Hora de Inicio (yyyy-MM-dd HH:mm:ss): ");
        funcion.setHoraInicio(LocalDateTime.parse(scanner.nextLine(), timeFormatter));
        return funcion;
    }

    public void mostrarFunciones(List<Funcion> funciones) {
        for (Funcion f : funciones) {
            System.out.println("ID: " + f.getIdFuncion() + " | Película: " + f.getIdPelicula() + 
                               " | Sala: " + f.getIdSala() + " | Fecha: " + f.getFecha() + 
                               " | Hora: " + f.getHoraInicio());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID de la Función: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}