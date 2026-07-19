package cinenova.controller;

import cinenova.dao.FuncionDAO;
import cinenova.model.Funcion;
import cinenova.view.FuncionView;
import java.util.List;

public class FuncionController {
    private FuncionDAO dao;
    private FuncionView view;

    public FuncionController(FuncionDAO dao, FuncionView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Funcion nuevaFuncion = view.capturarDatosFuncion();
                    if (dao.crearFuncion(nuevaFuncion)) {
                        view.mostrarMensaje("Función creada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear la función.");
                    }
                    break;
                case 2:
                    List<Funcion> funciones = dao.leerFunciones();
                    view.mostrarFunciones(funciones);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Funcion funcionActualizar = view.capturarDatosFuncion();
                    funcionActualizar.setIdFuncion(idActualizar);
                    if (dao.actualizarFuncion(funcionActualizar)) {
                        view.mostrarMensaje("Función actualizada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar la función.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarFuncion(idEliminar)) {
                        view.mostrarMensaje("Función eliminada exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar la función.");
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