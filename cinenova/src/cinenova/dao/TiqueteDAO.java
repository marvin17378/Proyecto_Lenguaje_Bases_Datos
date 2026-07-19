package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Tiquete;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class TiqueteDAO {

    public boolean crearTiquete(Tiquete tiquete) {
        String sql = "{CALL PKG_TIQUETE.SP_CREAR_TIQUETE(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, tiquete.getIdVenta());
            cs.setInt(2, tiquete.getIdFuncion());
            cs.setInt(3, tiquete.getIdAsiento());
            cs.setString(4, tiquete.getTipoTiquete());
            cs.setDouble(5, tiquete.getPrecio());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Tiquete> leerTiquetes() {
        List<Tiquete> lista = new ArrayList<>();
        String sql = "{CALL PKG_TIQUETE.SP_LEER_TIQUETES(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Tiquete tiquete = new Tiquete();
                    tiquete.setIdTiquete(rs.getInt("id_tiquete"));
                    tiquete.setIdVenta(rs.getInt("id_venta"));
                    tiquete.setIdFuncion(rs.getInt("id_funcion"));
                    tiquete.setIdAsiento(rs.getInt("id_asiento"));
                    tiquete.setTipoTiquete(rs.getString("tipo_tiquete"));
                    tiquete.setPrecio(rs.getDouble("precio"));
                    lista.add(tiquete);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarTiquete(Tiquete tiquete) {
        String sql = "{CALL PKG_TIQUETE.SP_ACTUALIZAR_TIQUETE(?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, tiquete.getIdTiquete());
            cs.setInt(2, tiquete.getIdVenta());
            cs.setInt(3, tiquete.getIdFuncion());
            cs.setInt(4, tiquete.getIdAsiento());
            cs.setString(5, tiquete.getTipoTiquete());
            cs.setDouble(6, tiquete.getPrecio());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarTiquete(int idTiquete) {
        String sql = "{CALL PKG_TIQUETE.SP_ELIMINAR_TIQUETE(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idTiquete);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}