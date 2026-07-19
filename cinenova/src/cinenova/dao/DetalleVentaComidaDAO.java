package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.DetalleVentaComida;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class DetalleVentaComidaDAO {

    public boolean crearDetalle(DetalleVentaComida detalle) {
        String sql = "{CALL PKG_DETALLE_COMIDA.SP_CREAR_DETALLE(?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, detalle.getIdVenta());
            cs.setInt(2, detalle.getIdProducto());
            cs.setInt(3, detalle.getCantidad());
            cs.setDouble(4, detalle.getSubtotal());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DetalleVentaComida> leerDetalles() {
        List<DetalleVentaComida> lista = new ArrayList<>();
        String sql = "{CALL PKG_DETALLE_COMIDA.SP_LEER_DETALLES(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    DetalleVentaComida detalle = new DetalleVentaComida();
                    detalle.setIdDetalleComida(rs.getInt("id_detalle_comida"));
                    detalle.setIdVenta(rs.getInt("id_venta"));
                    detalle.setIdProducto(rs.getInt("id_producto"));
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setSubtotal(rs.getDouble("subtotal"));
                    lista.add(detalle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarDetalle(DetalleVentaComida detalle) {
        String sql = "{CALL PKG_DETALLE_COMIDA.SP_ACTUALIZAR_DETALLE(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, detalle.getIdDetalleComida());
            cs.setInt(2, detalle.getIdVenta());
            cs.setInt(3, detalle.getIdProducto());
            cs.setInt(4, detalle.getCantidad());
            cs.setDouble(5, detalle.getSubtotal());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarDetalle(int idDetalleComida) {
        String sql = "{CALL PKG_DETALLE_COMIDA.SP_ELIMINAR_DETALLE(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idDetalleComida);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}