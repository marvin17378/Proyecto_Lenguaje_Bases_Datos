package cinenova.controller;

import cinenova.dao.DetalleVentaComidaDAO;
import cinenova.model.DetalleVentaComida;
import cinenova.view.DetalleVentaComidaView;
import java.util.List;

public class DetalleVentaComidaController {
    private DetalleVentaComidaDAO dao;
    private DetalleVentaComidaView view;

    public DetalleVentaComidaController(DetalleVentaComidaDAO dao, DetalleVentaComidaView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    DetalleVentaComida nuevoDetalle = view.capturarDatosDetalle();
                    if (dao.crearDetalle(nuevoDetalle)) {
                        view.mostrarMensaje("Detalle creado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear el detalle.");
                    }
                    break;
                case 2:
                    List<DetalleVentaComida> detalles = dao.leerDetalles();
                    view.mostrarDetalles(detalles);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    DetalleVentaComida detalleActualizar = view.capturarDatosDetalle();
                    detalleActualizar.setIdDetalleComida(idActualizar);
                    if (dao.actualizarDetalle(detalleActualizar)) {
                        view.mostrarMensaje("Detalle actualizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar el detalle.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarDetalle(idEliminar)) {
                        view.mostrarMensaje("Detalle eliminado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar el detalle.");
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