package cinenova.view;

import cinenova.model.Cliente;
import java.util.List;
import java.util.Scanner;

public class ClienteView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
        System.out.println("1. Crear Cliente");
        System.out.println("2. Leer Clientes");
        System.out.println("3. Actualizar Cliente");
        System.out.println("4. Eliminar Cliente");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Cliente capturarDatosCliente() {
        Cliente cli = new Cliente();
        scanner.nextLine();
        System.out.print("Cédula: ");
        cli.setCedula(scanner.nextLine());
        System.out.print("Nombre: ");
        cli.setNombre(scanner.nextLine());
        System.out.print("Apellidos: ");
        cli.setApellidos(scanner.nextLine());
        System.out.print("Correo: ");
        cli.setCorreo(scanner.nextLine());
        System.out.print("Puntos Acumulados: ");
        cli.setPuntosAcumulados(scanner.nextInt());
        return cli;
    }

    public void mostrarClientes(List<Cliente> clientes) {
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getIdCliente() + " | Cédula: " + c.getCedula() + 
                               " | Nombre: " + c.getNombre() + " " + c.getApellidos() + 
                               " | Correo: " + c.getCorreo());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID del Cliente: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}