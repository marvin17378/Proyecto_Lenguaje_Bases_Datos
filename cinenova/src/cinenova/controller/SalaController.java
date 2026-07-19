package cinenova.controller;

import cinenova.dao.SalaDAO;
import cinenova.model.Sala;
import cinenova.view.SalaView;
import java.util.List;

public class SalaController {
    private SalaDAO dao;
    private SalaView view;

    public SalaController(SalaDAO dao, SalaView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Sala nuevaSala = view.capturarDatosSala();
                    if (dao.crearSala(nuevaSala)) {
                        view.mostrarMensaje("Sala creada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear la sala.");
                    }
                    break;
                case 2:
                    List<Sala> salas = dao.leerSalas();
                    view.mostrarSalas(salas);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Sala salaActualizar = view.capturarDatosSala();
                    salaActualizar.setIdSala(idActualizar);
                    if (dao.actualizarSala(salaActualizar)) {
                        view.mostrarMensaje("Sala actualizada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar la sala.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarSala(idEliminar)) {
                        view.mostrarMensaje("Sala eliminada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar la sala.");
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