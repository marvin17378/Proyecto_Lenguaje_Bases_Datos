package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.ProductoComida;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class ProductoComidaDAO {

    public boolean crearProducto(ProductoComida producto) {
        String sql = "{CALL PKG_PRODUCTO_COMIDA.SP_CREAR_PROD(?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, producto.getNombre());
            cs.setInt(2, producto.getStockActual());
            cs.setDouble(3, producto.getPrecio());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ProductoComida> leerProductos() {
        List<ProductoComida> lista = new ArrayList<>();
        String sql = "{CALL PKG_PRODUCTO_COMIDA.SP_LEER_PROD(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    ProductoComida producto = new ProductoComida();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setStockActual(rs.getInt("stock_actual"));
                    producto.setPrecio(rs.getDouble("precio"));
                    lista.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarProducto(ProductoComida producto) {
        String sql = "{CALL PKG_PRODUCTO_COMIDA.SP_ACTUALIZAR_PROD(?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, producto.getIdProducto());
            cs.setString(2, producto.getNombre());
            cs.setInt(3, producto.getStockActual());
            cs.setDouble(4, producto.getPrecio());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String sql = "{CALL PKG_PRODUCTO_COMIDA.SP_ELIMINAR_PROD(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idProducto);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}