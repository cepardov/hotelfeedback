package utilidades;
import java.sql.*;
import javax.swing.JOptionPane;
import models.view.ComunicacionTest;

public final class DataBaseInstance {

    private static Connection conn;
    private static final String basedatos = "reservashotel";//Nombre de base de datos
    private static final String usuario = "root";//Usuario de base de datos
    private static final String contraseña = "1234";//Contraseña de base de datos
    private static final String port="1527";//Puerto de base de datos
    //Drivers disponibles
    //Mysql com.mysql.jdbc.Driver puerto 3306
    //Apache derby org.apache.derby.jdbc.ClientDriver puerto 1527
    private static final String driver="org.apache.derby.jdbc.ClientDriver";//Driver
    //Conexión con bases de datos mysql
    //private static final String url = "jdbc:mysql://localhost"+port+"/"+basedatos;//url, si no utiliza este comentar. (no modificar)
    //Conexion con base de datos apache derby
    private static final String url = "jdbc:derby://localhost:"+port+"/"+basedatos;//url, si no utiliza este comentar. (no modificar)

    public static Connection getInstanceConnection() {
        if (!(conn instanceof Connection)) {
            System.out.println("Conectando a la BD.");
            try {
                Class.forName(""+driver+"");
                conn = DriverManager.getConnection(url, usuario, contraseña);
            } catch (ClassNotFoundException se) {
                System.out.println("Error 1:" + se);
                JOptionPane.showMessageDialog(null,"Error de controlador durante la comunicacion con base de datos "+basedatos+"\n\n\tDriver Instalado:\n\t"+driver+"\nCodigo de error:\n"+se, "¡ups! Algo inesperado ha pasado", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException se) {
                System.out.println("Error 2:" + se);
                JOptionPane.showMessageDialog(null,"Error de lectura/escritura durante la comunicacion con base de datos "+basedatos+"\nCodigo de error:\n"+se, "¡ups! Algo inesperado ha pasado", JOptionPane.ERROR_MESSAGE);
            }
        }
        System.out.println(conn);
        return conn;
    }
    
    public static void resultadoConexion(){
        JOptionPane.showMessageDialog(null,"Datos de la conexión:\n"
                + "URL:"+url+"\n"
                + "Puerto:"+port+"\n"
                + "Usuario:"+usuario+"\n"
                + "Codigo:\n"+conn,"Resultado de Pruebas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void resultadoDesconexion(){
        if(conn!=null){
            JOptionPane.showMessageDialog(null,"La conexion no ha terminado correctamente\n"
                    + "aun conectado con codigo:\n"
                    + conn+ "\n"
                    + "ha base de datos"+basedatos,"Resultado de Pruebas", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"La conexion ha terminado con exito","Resultado de Pruebas", JOptionPane.ERROR_MESSAGE);
        }
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
            JOptionPane.showMessageDialog(null,"Error se terminaba la comunicación con base de datos "+basedatos+"\nCodigo de error:\n"+se, "¡ups! Algo inesperado ha pasado", JOptionPane.WARNING_MESSAGE);
            System.err.println(se.getMessage());
        }
    }
}