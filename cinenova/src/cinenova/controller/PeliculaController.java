package cinenova.controller;

import cinenova.dao.PeliculaDAO;
import cinenova.model.Pelicula;
import cinenova.view.PeliculaView;
import java.util.List;

public class PeliculaController {
    private PeliculaDAO dao;
    private PeliculaView view;

    public PeliculaController(PeliculaDAO dao, PeliculaView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Pelicula nuevaPelicula = view.capturarDatosPelicula();
                    if (dao.crearPelicula(nuevaPelicula)) {
                        view.mostrarMensaje("Película creada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear la película.");
                    }
                    break;
                case 2:
                    List<Pelicula> peliculas = dao.leerPeliculas();
                    view.mostrarPeliculas(peliculas);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Pelicula peliculaActualizar = view.capturarDatosPelicula();
                    peliculaActualizar.setIdPelicula(idActualizar);
                    if (dao.actualizarPelicula(peliculaActualizar)) {
                        view.mostrarMensaje("Película actualizada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar la película.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarPelicula(idEliminar)) {
                        view.mostrarMensaje("Película eliminada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar la película.");
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