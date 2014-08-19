package utilities;
import java.sql.*;
import javax.swing.JOptionPane;

public final class DataBaseInstance {

    private static Connection conn;
    private static final String basedatos = "bdhotel";//Nombre de base de datos
    private static final String usuario = "root";//Usuario de base de datos
    private static final String contraseña = "123";//Contraseña de base de datos
    private static final String port="";//Puerto de base de datos
    //Conexión con bases de datos mysql
    //private static final String url = "jdbc:mysql://localhost"+port+"/"+basedatos;//url, si no utiliza este comentar. (no modificar)
    //Conexion con base de datos apache derby
    private static final String url = "jdbc:derby://localhost"+port+"/"+basedatos;//url, si no utiliza este comentar. (no modificar)

    public static Connection getInstanceConnection() {
        if (!(conn instanceof Connection)) {
            System.out.println("Conectando a la BD.");
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection(url, usuario, contraseña);
            } catch (ClassNotFoundException se) {
                System.out.println("Error 1:" + se);
            } catch (SQLException se) {
                System.out.println("Error 2:" + se);
            }
        }
        System.out.println(conn);
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn instanceof Connection) {
                conn.close();
                conn = null;
                System.out.println("Se ha cerrado la conexion de BD con exito.");
            }

        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error al cerrar la conexion de BD.");
            System.err.println(se.getMessage());
        }
    }
}