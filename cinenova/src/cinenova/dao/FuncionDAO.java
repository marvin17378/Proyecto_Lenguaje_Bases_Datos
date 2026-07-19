package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Funcion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class FuncionDAO {

    public boolean crearFuncion(Funcion funcion) {
        String sql = "{CALL PKG_FUNCION.SP_CREAR_FUNCION(?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, funcion.getIdPelicula());
            cs.setInt(2, funcion.getIdSala());
            cs.setDate(3, Date.valueOf(funcion.getFecha()));
            cs.setTimestamp(4, Timestamp.valueOf(funcion.getHoraInicio()));
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Funcion> leerFunciones() {
        List<Funcion> lista = new ArrayList<>();
        String sql = "{CALL PKG_FUNCION.SP_LEER_FUNCIONES(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Funcion funcion = new Funcion();
                    funcion.setIdFuncion(rs.getInt("id_funcion"));
                    funcion.setIdPelicula(rs.getInt("id_pelicula"));
                    funcion.setIdSala(rs.getInt("id_sala"));
                    if (rs.getDate("fecha") != null) {
                        funcion.setFecha(rs.getDate("fecha").toLocalDate());
                    }
                    if (rs.getTimestamp("hora_inicio") != null) {
                        funcion.setHoraInicio(rs.getTimestamp("hora_inicio").toLocalDateTime());
                    }
                    lista.add(funcion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarFuncion(Funcion funcion) {
        String sql = "{CALL PKG_FUNCION.SP_ACTUALIZAR_FUNCION(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, funcion.getIdFuncion());
            cs.setInt(2, funcion.getIdPelicula());
            cs.setInt(3, funcion.getIdSala());
            cs.setDate(4, Date.valueOf(funcion.getFecha()));
            cs.setTimestamp(5, Timestamp.valueOf(funcion.getHoraInicio()));
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarFuncion(int idFuncion) {
        String sql = "{CALL PKG_FUNCION.SP_ELIMINAR_FUNCION(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idFuncion);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}