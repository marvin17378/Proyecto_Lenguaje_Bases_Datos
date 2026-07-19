package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class EmpleadoDAO {

    public boolean crearEmpleado(Empleado empleado) {
        String sql = "{CALL PKG_EMPLEADO.SP_CREAR_EMP(?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, empleado.getCedula());
            cs.setString(2, empleado.getNombre());
            cs.setString(3, empleado.getApellidos());
            cs.setString(4, empleado.getCargo());
            cs.setString(5, empleado.getAreaTrabajo());
            cs.setString(6, empleado.getTurnoHorario());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Empleado> leerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "{CALL PKG_EMPLEADO.SP_LEER_EMP(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("id_empleado"));
                    empleado.setCedula(rs.getString("cedula"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellidos(rs.getString("apellidos"));
                    empleado.setCargo(rs.getString("cargo"));
                    empleado.setAreaTrabajo(rs.getString("area_trabajo"));
                    empleado.setTurnoHorario(rs.getString("turno_horario"));
                    lista.add(empleado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        String sql = "{CALL PKG_EMPLEADO.SP_ACTUALIZAR_EMP(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, empleado.getIdEmpleado());
            cs.setString(2, empleado.getCedula());
            cs.setString(3, empleado.getNombre());
            cs.setString(4, empleado.getApellidos());
            cs.setString(5, empleado.getCargo());
            cs.setString(6, empleado.getAreaTrabajo());
            cs.setString(7, empleado.getTurnoHorario());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEmpleado(int idEmpleado) {
        String sql = "{CALL PKG_EMPLEADO.SP_ELIMINAR_EMP(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idEmpleado);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}