package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Sala;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class SalaDAO {

    public boolean crearSala(Sala sala) {
        String sql = "{CALL PKG_SALA.SP_CREAR_SALA(?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, sala.getNumeroSala());
            cs.setInt(2, sala.getCapacidadTotal());
            cs.setString(3, sala.getTipoSala());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sala> leerSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "{CALL PKG_SALA.SP_LEER_SALAS(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Sala sala = new Sala();
                    sala.setIdSala(rs.getInt("id_sala"));
                    sala.setNumeroSala(rs.getInt("numero_sala"));
                    sala.setCapacidadTotal(rs.getInt("capacidad_total"));
                    sala.setTipoSala(rs.getString("tipo_sala"));
                    lista.add(sala);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarSala(Sala sala) {
        String sql = "{CALL PKG_SALA.SP_ACTUALIZAR_SALA(?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, sala.getIdSala());
            cs.setInt(2, sala.getNumeroSala());
            cs.setInt(3, sala.getCapacidadTotal());
            cs.setString(4, sala.getTipoSala());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarSala(int idSala) {
        String sql = "{CALL PKG_SALA.SP_ELIMINAR_SALA(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idSala);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}