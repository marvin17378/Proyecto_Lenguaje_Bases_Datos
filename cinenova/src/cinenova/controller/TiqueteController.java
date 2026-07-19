package cinenova.controller;

import cinenova.dao.TiqueteDAO;
import cinenova.model.Tiquete;
import cinenova.view.TiqueteView;
import java.util.List;

public class TiqueteController {
    private TiqueteDAO dao;
    private TiqueteView view;

    public TiqueteController(TiqueteDAO dao, TiqueteView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Tiquete nuevoTiquete = view.capturarDatosTiquete();
                    if (dao.crearTiquete(nuevoTiquete)) {
                        view.mostrarMensaje("Tiquete creado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear el tiquete.");
                    }
                    break;
                case 2:
                    List<Tiquete> tiquetes = dao.leerTiquetes();
                    view.mostrarTiquetes(tiquetes);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Tiquete tiqueteActualizar = view.capturarDatosTiquete();
                    tiqueteActualizar.setIdTiquete(idActualizar);
                    if (dao.actualizarTiquete(tiqueteActualizar)) {
                        view.mostrarMensaje("Tiquete actualizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar el tiquete.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarTiquete(idEliminar)) {
                        view.mostrarMensaje("Tiquete eliminado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar el tiquete.");
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