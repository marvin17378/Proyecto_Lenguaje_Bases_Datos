package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Asiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class AsientoDAO {

    public boolean crearAsiento(Asiento asiento) {
        String sql = "{CALL PKG_ASIENTO.SP_CREAR_ASIENTO(?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, asiento.getIdSala());
            cs.setString(2, asiento.getFila());
            cs.setInt(3, asiento.getNumero());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Asiento> leerAsientos() {
        List<Asiento> lista = new ArrayList<>();
        String sql = "{CALL PKG_ASIENTO.SP_LEER_ASIENTOS(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Asiento asiento = new Asiento();
                    asiento.setIdAsiento(rs.getInt("id_asiento"));
                    asiento.setIdSala(rs.getInt("id_sala"));
                    asiento.setFila(rs.getString("fila"));
                    asiento.setNumero(rs.getInt("numero"));
                    lista.add(asiento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarAsiento(Asiento asiento) {
        String sql = "{CALL PKG_ASIENTO.SP_ACTUALIZAR_ASIENTO(?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, asiento.getIdAsiento());
            cs.setInt(2, asiento.getIdSala());
            cs.setString(3, asiento.getFila());
            cs.setInt(4, asiento.getNumero());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAsiento(int idAsiento) {
        String sql = "{CALL PKG_ASIENTO.SP_ELIMINAR_ASIENTO(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idAsiento);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}