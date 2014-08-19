package utilidades;
import java.sql.*;
import javax.swing.JOptionPane;

public class DataBaseInstance {
   private static final String basedatos = "bdhotel";//Nombre de base de datos
   private static final String usuario = "root";//Usuario de base de datos
   private static final String contraseña = "123";//Contraseña de base de datos
   private static final String port="";//Puerto de base de datos
   //Drivers disponibles
   //Mysql com.mysql.jdbc.Driver
   //Apache derby org.apache.derby.jdbc.ClientDriver
   private static final String driver="org.apache.derby.jdbc.ClientDriver";//Driver
   //Conexión con bases de datos mysql
   //private static final String url = "jdbc:mysql://localhost"+port+"/"+basedatos;//url, si no utiliza este comentar. (no modificar)
   //Conexion con base de datos apache derby
   private static final String url = "jdbc:derby://localhost"+port+"/"+basedatos;//url, si no utiliza este comentar. (no modificar)
   Connection conn = null;

   public DataBaseInstance() {
      try{
         Class.forName(driver);
         conn = DriverManager.getConnection(url,usuario,contraseña);
         if (conn!=null){
             System.out.println("Usted se ha conectado a la base de datos "+basedatos+".");
             System.out.println("Como usuario: "+usuario);
         }
      }catch(SQLException se){
          JOptionPane.showMessageDialog(null,"Error de lectura/escritura con base de datos"+basedatos+":\n\n\tCodigo de excepción:\n"+ se, "¡ups! Algo inesperado ha pasado", JOptionPane.ERROR_MESSAGE);
          System.exit(0);
      }catch(ClassNotFoundException se){
          JOptionPane.showMessageDialog(null,"Error de controlador mientras de intentaba una conexion con base de datos"+basedatos+":\n\n\tCodigo de excepción:\n\tControlador usado: "+driver+"\n"+ se, "¡ups! Algo inesperado ha pasado", JOptionPane.ERROR_MESSAGE);
          System.exit(0);
      }
   }
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+basedatos+" a terminado");
   }
}
