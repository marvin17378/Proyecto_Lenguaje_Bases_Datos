package cinenova.controller;

import cinenova.dao.ClienteDAO;
import cinenova.model.Cliente;
import cinenova.view.ClienteView;
import java.util.List;

public class ClienteController {
    private ClienteDAO dao;
    private ClienteView view;

    public ClienteController(ClienteDAO dao, ClienteView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    Cliente nuevoCliente = view.capturarDatosCliente();
                    if (dao.crearCliente(nuevoCliente)) {
                        view.mostrarMensaje("Cliente creado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear el cliente.");
                    }
                    break;
                case 2:
                    List<Cliente> clientes = dao.leerClientes();
                    view.mostrarClientes(clientes);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    Cliente clienteActualizar = view.capturarDatosCliente();
                    clienteActualizar.setIdCliente(idActualizar);
                    if (dao.actualizarCliente(clienteActualizar)) {
                        view.mostrarMensaje("Cliente actualizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar el cliente.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarCliente(idEliminar)) {
                        view.mostrarMensaje("Cliente eliminado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar el cliente.");
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