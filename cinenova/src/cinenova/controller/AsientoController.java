package cinenova.controller;

import cinenova.dao.AsientoDAO;
import cinenova.model.Asiento;
import cinenova.view.AsientoView;
import java.util.List;

public class AsientoController {
    private AsientoDAO dao;
    private AsientoView view;

    public AsientoController(AsientoDAO dao, AsientoView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Asiento nuevoAsiento = view.capturarDatosAsiento();
                    if (dao.crearAsiento(nuevoAsiento)) {
                        view.mostrarMensaje("Asiento creado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear el asiento.");
                    }
                    break;
                case 2:
                    List<Asiento> asientos = dao.leerAsientos();
                    view.mostrarAsientos(asientos);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Asiento asientoActualizar = view.capturarDatosAsiento();
                    asientoActualizar.setIdAsiento(idActualizar);
                    if (dao.actualizarAsiento(asientoActualizar)) {
                        view.mostrarMensaje("Asiento actualizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar el asiento.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarAsiento(idEliminar)) {
                        view.mostrarMensaje("Asiento eliminado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar el asiento.");
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