package cinenova;

import cinenova.controller.*;
import cinenova.dao.*;
import cinenova.view.*;

public class Main {
    public static void main(String[] args) {
        
        VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal();

        SalaDAO salaDAO = new SalaDAO();
        SalaView salaView = new SalaView();
        SalaController salaController = new SalaController(salaDAO, salaView);

        PeliculaDAO peliculaDAO = new PeliculaDAO();
        PeliculaView peliculaView = new PeliculaView();
        PeliculaController peliculaController = new PeliculaController(peliculaDAO, peliculaView);

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        EmpleadoView empleadoView = new EmpleadoView();
        EmpleadoController empleadoController = new EmpleadoController(empleadoDAO, empleadoView);

        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(clienteDAO, clienteView);

        ProductoComidaDAO productoDAO = new ProductoComidaDAO();
        ProductoComidaView productoView = new ProductoComidaView();
        ProductoComidaController productoController = new ProductoComidaController(productoDAO, productoView);

        AsientoDAO asientoDAO = new AsientoDAO();
        AsientoView asientoView = new AsientoView();
        AsientoController asientoController = new AsientoController(asientoDAO, asientoView);

        FuncionDAO funcionDAO = new FuncionDAO();
        FuncionView funcionView = new FuncionView();
        FuncionController funcionController = new FuncionController(funcionDAO, funcionView);

        VentaDAO ventaDAO = new VentaDAO();
        VentaView ventaView = new VentaView();
        VentaController ventaController = new VentaController(ventaDAO, ventaView);

        TiqueteDAO tiqueteDAO = new TiqueteDAO();
        TiqueteView tiqueteView = new TiqueteView();
        TiqueteController tiqueteController = new TiqueteController(tiqueteDAO, tiqueteView);

        DetalleVentaComidaDAO detalleDAO = new DetalleVentaComidaDAO();
        DetalleVentaComidaView detalleView = new DetalleVentaComidaView();
        DetalleVentaComidaController detalleController = new DetalleVentaComidaController(detalleDAO, detalleView);

        int opcion;
        do {
            opcion = menuPrincipal.mostrarMenu();
            switch (opcion) {
                case 1:
                    salaController.iniciar();
                    break;
                case 2:
                    peliculaController.iniciar();
                    break;
                case 3:
                    empleadoController.iniciar();
                    break;
                case 4:
                    clienteController.iniciar();
                    break;
                case 5:
                    productoController.iniciar();
                    break;
                case 6:
                    asientoController.iniciar();
                    break;
                case 7:
                    funcionController.iniciar();
                    break;
                case 8:
                    ventaController.iniciar();
                    break;
                case 9:
                    tiqueteController.iniciar();
                    break;
                case 10:
                    detalleController.iniciar();
                    break;
                case 0:
                    System.out.println("Cerrando el sistema de gestión CineNova... ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}