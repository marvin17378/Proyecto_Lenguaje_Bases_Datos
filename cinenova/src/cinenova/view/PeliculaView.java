package cinenova.view;

import cinenova.model.Pelicula;
import java.util.List;
import java.util.Scanner;

public class PeliculaView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE PELÍCULAS ---");
        System.out.println("1. Crear Película");
        System.out.println("2. Leer Películas");
        System.out.println("3. Actualizar Película");
        System.out.println("4. Eliminar Película");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public Pelicula capturarDatosPelicula() {
        Pelicula pelicula = new Pelicula();
        scanner.nextLine();
        System.out.print("Título: ");
        pelicula.setTitulo(scanner.nextLine());
        System.out.print("Género: ");
        pelicula.setGenero(scanner.nextLine());
        System.out.print("Duración (minutos): ");
        pelicula.setDuracionMinutos(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Clasificación: ");
        pelicula.setClasificacion(scanner.nextLine());
        return pelicula;
    }

    public void mostrarPeliculas(List<Pelicula> peliculas) {
        for (Pelicula p : peliculas) {
            System.out.println("ID: " + p.getIdPelicula() + " | Título: " + p.getTitulo() + 
                               " | Género: " + p.getGenero() + " | Duración: " + p.getDuracionMinutos() + 
                               " | Clasificación: " + p.getClasificacion());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID de la Película: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}