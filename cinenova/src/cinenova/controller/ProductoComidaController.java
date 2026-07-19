package cinenova.controller;

import cinenova.dao.ProductoComidaDAO;
import cinenova.model.ProductoComida;
import cinenova.view.ProductoComidaView;
import java.util.List;

public class ProductoComidaController {
    private ProductoComidaDAO dao;
    private ProductoComidaView view;

    public ProductoComidaController(ProductoComidaDAO dao, ProductoComidaView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    ProductoComida nuevoProducto = view.capturarDatosProducto();
                    if (dao.crearProducto(nuevoProducto)) {
                        view.mostrarMensaje("Producto creado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al crear el producto.");
                    }
                    break;
                case 2:
                    List<ProductoComida> productos = dao.leerProductos();
                    view.mostrarProductos(productos);
                    break;
                case 3:
                    int idActualizar = view.capturarId();
                    ProductoComida productoActualizar = view.capturarDatosProducto();
                    productoActualizar.setIdProducto(idActualizar);
                    if (dao.actualizarProducto(productoActualizar)) {
                        view.mostrarMensaje("Producto actualizado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al actualizar el producto.");
                    }
                    break;
                case 4:
                    int idEliminar = view.capturarId();
                    if (dao.eliminarProducto(idEliminar)) {
                        view.mostrarMensaje("Producto eliminado exitosamente.");
                    } else {
                        view.mostrarMensaje("Error al eliminar el producto.");
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