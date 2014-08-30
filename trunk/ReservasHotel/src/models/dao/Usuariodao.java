package models.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.entity.Usuario;
import models.entity.Usuario;
import utilidades.DataBaseInstance;
/**
 *
 * @author Luis
 */
public class Usuariodao {
    protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
    public Usuario findByRut(String usuarioRut) {
        ResultSet result = null;
        Usuario usuario = null;

        try {
            // Componemos la sentencia SQL para obtener los USUARIO.
            String query = "SELECT * FROM usuario WHERE  rutusuario = ?";

            // Ejecutamos la query y obtenemos el resultado.
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, usuarioRut);
            result = stmt.executeQuery();

            // Vemos si no ha devuelto ningun resultado.
            if (!result.next()) {
                throw new SQLException();
            }

            // Construimos una VO para el usuario.
            usuario = new Usuario();
            usuario.setRutusuario(result.getString("rutusuario"));
            usuario.setNombre(result.getString("nombre"));
            usuario.setPaterno(result.getString("paterno"));
            usuario.setMaterno(result.getString("materno"));
            usuario.setTelefono(result.getString("telefono"));
            usuario.setMail(result.getString("mail"));
            usuario.setPrivilegio(result.getString("privilegio"));
            usuario.setClave(result.getString("clave"));

            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }

        return usuario;
    }
    
    public int getUserCount() {
        int posid = 0;
        try {
            PreparedStatement pstm = DataBaseInstance.getInstanceConnection().prepareStatement("SELECT count(1) as total FROM usuario");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            DataBaseInstance.closeConnection();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se);
        }
        return posid;
    }
    
    public Object [][] getUsuario(){
        int posid = 0;
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT count(1) as total FROM usuario");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
        Object[][] data = new String[posid][8];
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT rutusuario, nombre, paterno,"
                    + " materno, telefono, mail, privilegio, clave FROM usuario ORDER BY paterno");
            ResultSet res = pstm.executeQuery();
            int increment = 0;
            while(res.next()){
                String estRut = res.getString("rutusuario");
                String estNombre = res.getString("nombre");
                String estPaterno = res.getString("paterno");
                String estMaterno = res.getString("materno");
                String estTelefono = res.getString("telefono");
                String estMail = res.getString("mail");
                String estPrivilegio = res.getString("privilegio");
                String estClave = res.getString("clave");
                data[increment][0] = estRut;
                data[increment][1] = estNombre;
                data[increment][2] = estPaterno;
                data[increment][3] = estMaterno;
                data[increment][4] = estTelefono;
                data[increment][5] = estMail;
                data[increment][6] = estPrivilegio;
                data[increment][7] = estClave;
                increment++;
            }
            res.close();
            closeConnection();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
        return data;
    }

    public void save(Usuario usuario) {
        PreparedStatement saveUsuario;
        try {
            saveUsuario = getConnection().prepareStatement(
                    "INSERT INTO usuario (rutusuario, nombre, paterno, materno, telefono , mail, privilegio, clave) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            saveUsuario.setString(1, usuario.getRutusuario());
            saveUsuario.setString(2, usuario.getNombre());
            saveUsuario.setString(3, usuario.getPaterno());
            saveUsuario.setString(4, usuario.getMaterno());
            saveUsuario.setString(5, usuario.getTelefono());
            saveUsuario.setString(6, usuario.getMail());
            saveUsuario.setString(7, usuario.getPrivilegio());
            saveUsuario.setString(8, usuario.getClave());
                
            System.out.println("Escribiendo en base de datos");
            saveUsuario.executeUpdate();
            System.out.println("[i] Nuevo registro ok");
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }
    
    public void update(Usuario usuario) {
        PreparedStatement saveUsuario;
        try {
            saveUsuario = getConnection().prepareStatement(
                    "UPDATE usuario SET rutusuario=?, nombre=?, paterno=?, materno=?, telefono=?, mail=?, privilegio=?, clave=? WHERE  rutusuario=?");
            saveUsuario.setString(1, usuario.getRutusuario());
            saveUsuario.setString(2, usuario.getNombre());
            saveUsuario.setString(3, usuario.getPaterno());
            saveUsuario.setString(4, usuario.getMaterno());
            saveUsuario.setString(5, usuario.getTelefono());
            saveUsuario.setString(6, usuario.getMail());
            saveUsuario.setString(7, usuario.getPrivilegio());
            saveUsuario.setString(8, usuario.getClave());
            saveUsuario.setString(9, usuario.getRutusuario());
            saveUsuario.executeUpdate();
            System.out.println("[i] Actualización de registro ok");
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Usuario usuario) {
        PreparedStatement delUsuario;
        try {

            if (usuario.getRutusuario() != null) {
                delUsuario = getConnection().prepareStatement(
                        "DELETE FROM usuario WHERE rutusuario = ?");

                delUsuario.setString(1, usuario.getRutusuario());
                delUsuario.executeUpdate();
            }


            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void closeConnection() {
        DataBaseInstance.closeConnection();
    }
}
