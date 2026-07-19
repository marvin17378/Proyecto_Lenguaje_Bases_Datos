package cinenova.view;

import java.util.Scanner;

public class VistaMenuPrincipal {
    private Scanner scanner;

    public VistaMenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- SISTEMA CIONENOVA - MENÚ PRINCIPAL ---");
        System.out.println("1. Gestionar Salas");
        System.out.println("2. Gestionar Películas");
        System.out.println("3. Gestionar Empleados");
        System.out.println("4. Gestionar Clientes");
        System.out.println("5. Gestionar Productos de Comida");
        System.out.println("6. Gestionar Asientos");
        System.out.println("7. Gestionar Funciones");
        System.out.println("8. Gestionar Ventas");
        System.out.println("9. Gestionar Tiquetes");
        System.out.println("10. Gestionar Detalles de Comida");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
}