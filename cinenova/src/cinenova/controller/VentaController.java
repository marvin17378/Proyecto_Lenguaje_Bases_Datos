package cinenova.controller;

import cinenova.dao.VentaDAO;
import cinenova.model.Venta;
import cinenova.view.VentaView;
import java.util.List;

public class VentaController {
    private VentaDAO dao;
    private VentaView view;

    public VentaController(VentaDAO dao, VentaView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Venta nuevaVenta = view.capturarDatosVenta();
                    if (dao.crearVenta(nuevaVenta)) {
                        view.mostrarMensaje("Venta creada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear la venta.");
                    }
                    break;
                case 2:
                    List<Venta> ventas = dao.leerVentas();
                    view.mostrarVentas(ventas);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Venta ventaActualizar = view.capturarDatosVenta();
                    ventaActualizar.setIdVenta(idActualizar);
                    if (dao.actualizarVenta(ventaActualizar)) {
                        view.mostrarMensaje("Venta actualizada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar la venta.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarVenta(idEliminar)) {
                        view.mostrarMensaje("Venta eliminada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar la venta.");
                    }
                    break;
                case 0:
                    break;
                default:
                    view.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }
}