package cinenova.controller;

import cinenova.dao.EmpleadoDAO;
import cinenova.model.Empleado;
import cinenova.view.EmpleadoView;
import java.util.List;

public class EmpleadoController {
    private EmpleadoDAO dao;
    private EmpleadoView view;

    public EmpleadoController(EmpleadoDAO dao, EmpleadoView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Empleado nuevoEmpleado = view.capturarDatosEmpleado();
                    if (dao.crearEmpleado(nuevoEmpleado)) {
                        view.mostrarMensaje("Empleado creado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear el empleado.");
                    }
                    break;
                case 2:
                    List<Empleado> empleados = dao.leerEmpleados();
                    view.mostrarEmpleados(empleados);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Empleado empleadoActualizar = view.capturarDatosEmpleado();
                    empleadoActualizar.setIdEmpleado(idActualizar);
                    if (dao.actualizarEmpleado(empleadoActualizar)) {
                        view.mostrarMensaje("Empleado actualizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar el empleado.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarEmpleado(idEliminar)) {
                        view.mostrarMensaje("Empleado eliminado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar el empleado.");
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