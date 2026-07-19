package cinenova.view;

import cinenova.model.ProductoComida;
import java.util.List;
import java.util.Scanner;

public class ProductoComidaView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE PRODUCTOS DE COMIDA ---");
        System.out.println("1. Crear Producto");
        System.out.println("2. Leer Productos");
        System.out.println("3. Actualizar Producto");
        System.out.println("4. Eliminar Producto");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public ProductoComida capturarDatosProducto() {
        ProductoComida prod = new ProductoComida();
        scanner.nextLine();
        System.out.print("Nombre del Producto: ");
        prod.setNombre(scanner.nextLine());
        System.out.print("Stock Actual: ");
        prod.setStockActual(scanner.nextInt());
        System.out.print("Precio: ");
        prod.setPrecio(scanner.nextDouble());
        return prod;
    }

    public void mostrarProductos(List<ProductoComida> productos) {
        for (ProductoComida p : productos) {
            System.out.println("ID: " + p.getIdProducto() + " | Nombre: " + p.getNombre() + 
                               " | Stock: " + p.getStockActual() + " | Precio: ₡" + p.getPrecio());
        }
    }

    public int capturarId() {
        System.out.print("Ingrese el ID del Producto: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}