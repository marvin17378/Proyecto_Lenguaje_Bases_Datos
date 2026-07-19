package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class VentaDAO {

    public boolean crearVenta(Venta venta) {
        String sql = "{CALL PKG_VENTA.SP_CREAR_VENTA(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, venta.getIdCliente());
            cs.setInt(2, venta.getIdEmpleado());
            cs.setTimestamp(3, Timestamp.valueOf(venta.getFechaHora()));
            cs.setDouble(4, venta.getTotalPagar());
            cs.setString(5, venta.getMetodoPago());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Venta> leerVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "{CALL PKG_VENTA.SP_LEER_VENTAS(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs.getInt("id_venta"));
                    venta.setIdCliente(rs.getInt("id_cliente"));
                    venta.setIdEmpleado(rs.getInt("id_empleado"));
                    if (rs.getTimestamp("fecha_hora") != null) {
                        venta.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                    }
                    venta.setTotalPagar(rs.getDouble("total_pagar"));
                    venta.setMetodoPago(rs.getString("metodo_pago"));
                    lista.add(venta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarVenta(Venta venta) {
        String sql = "{CALL PKG_VENTA.SP_ACTUALIZAR_VENTA(?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, venta.getIdVenta());
            cs.setInt(2, venta.getIdCliente());
            cs.setInt(3, venta.getIdEmpleado());
            cs.setTimestamp(4, Timestamp.valueOf(venta.getFechaHora()));
            cs.setDouble(5, venta.getTotalPagar());
            cs.setString(6, venta.getMetodoPago());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarVenta(int idVenta) {
        String sql = "{CALL PKG_VENTA.SP_ELIMINAR_VENTA(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idVenta);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}