package cinenova.view;

import cinenova.model.Empleado;
import java.util.List;
import java.util.Scanner;

public class EmpleadoView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE EMPLEADOS ---");
        System.out.println("1. Crear Empleado");
        System.out.println("2. Leer Empleados");
        System.out.println("3. Actualizar Empleado");
        System.out.println("4. Eliminar Empleado");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Empleado capturarDatosEmpleado() {
        Empleado emp = new Empleado();
        scanner.nextLine();
        System.out.print("Cédula: ");
        emp.setCedula(scanner.nextLine());
        System.out.print("Nombre: ");
        emp.setNombre(scanner.nextLine());
        System.out.print("Apellidos: ");
        emp.setApellidos(scanner.nextLine());
        System.out.print("Cargo: ");
        emp.setCargo(scanner.nextLine());
        System.out.print("Área de Trabajo: ");
        emp.setAreaTrabajo(scanner.nextLine());
        System.out.print("Turno/Horario: ");
        emp.setTurnoHorario(scanner.nextLine());
        return emp;
    }

    public void mostrarEmpleados(List<Empleado> empleados) {
        for (Empleado e : empleados) {
            System.out.println("ID: " + e.getIdEmpleado() + " | Cédula: " + e.getCedula() + 
                               " | Nombre: " + e.getNombre() + " " + e.getApellidos() + 
                               " | Cargo: " + e.getCargo());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID del Empleado: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}