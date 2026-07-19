package cinenova.dao;

import cinenova.conexion.Conexion;
import cinenova.model.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class ClienteDAO {

    public boolean crearCliente(Cliente cliente) {
        String sql = "{CALL PKG_CLIENTE.SP_CREAR_CLIENTE(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, cliente.getCedula());
            cs.setString(2, cliente.getNombre());
            cs.setString(3, cliente.getApellidos());
            cs.setString(4, cliente.getCorreo());
            cs.setInt(5, cliente.getPuntosAcumulados());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> leerClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "{CALL PKG_CLIENTE.SP_LEER_CLIENTES(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id_cliente"));
                    cliente.setCedula(rs.getString("cedula"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellidos(rs.getString("apellidos"));
                    cliente.setCorreo(rs.getString("correo"));
                    cliente.setPuntosAcumulados(rs.getInt("puntos_acumulados"));
                    lista.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizarCliente(Cliente cliente) {
        String sql = "{CALL PKG_CLIENTE.SP_ACTUALIZAR_CLIENTE(?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, cliente.getIdCliente());
            cs.setString(2, cliente.getCedula());
            cs.setString(3, cliente.getNombre());
            cs.setString(4, cliente.getApellidos());
            cs.setString(5, cliente.getCorreo());
            cs.setInt(6, cliente.getPuntosAcumulados());
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(int idCliente) {
        String sql = "{CALL PKG_CLIENTE.SP_ELIMINAR_CLIENTE(?)}";
        try (Connection con = Conexion.getConexion();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idCliente);
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}