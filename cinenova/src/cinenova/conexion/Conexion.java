package cinenova.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class Conexion {
    
    private static final String RUTA_PROYECTO = System.getProperty("user.dir");
    private static final String RUTA_WALLET = (RUTA_PROYECTO + File.separator + "Wallet_CineNova").replace('\\', '/');
    
    // ¡Ojo! Le quitamos el ?TNS_ADMIN=... de aquí al final
    private static final String URL = "jdbc:oracle:thin:@cinenova_high"; 
    private static final String USUARIO = "ADMIN"; 
    private static final String CONTRASENA = "Contrasena2026*";

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // Le pasamos la ruta de la Wallet directamente al sistema de Java
            System.setProperty("oracle.net.tns_admin", RUTA_WALLET);
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("¡Conexión a Oracle exitosa!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver de Oracle no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}