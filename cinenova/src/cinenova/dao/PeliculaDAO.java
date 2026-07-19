package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Pelicula;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class PeliculaDAO {

    public boolean crearPelicula(Pelicula pelicula) {
        String sql = "{CALL PKG_PELICULA.SP_CREAR_PELI(?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, pelicula.getTitulo());
            cs.setString(2, pelicula.getGenero());
            cs.setInt(3, pelicula.getDuracionMinutos());
            cs.setString(4, pelicula.getClasificacion());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Pelicula> leerPeliculas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "{CALL PKG_PELICULA.SP_LEER_PELI(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setIdPelicula(rs.getInt("id_pelicula"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setGenero(rs.getString("genero"));
                    pelicula.setDuracionMinutos(rs.getInt("duracion_minutos"));
                    pelicula.setClasificacion(rs.getString("clasificacion"));
                    lista.add(pelicula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarPelicula(Pelicula pelicula) {
        String sql = "{CALL PKG_PELICULA.SP_ACTUALIZAR_PELI(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, pelicula.getIdPelicula());
            cs.setString(2, pelicula.getTitulo());
            cs.setString(3, pelicula.getGenero());
            cs.setInt(4, pelicula.getDuracionMinutos());
            cs.setString(5, pelicula.getClasificacion());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPelicula(int idPelicula) {
        String sql = "{CALL PKG_PELICULA.SP_ELIMINAR_PELI(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idPelicula);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}