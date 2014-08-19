package models.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            // Componemos la sentencia SQL para obtener los productos.
            String query = "SELECT * FROM usuario WHERE  rutusuariousuario = ?";

            // Ejecutamos la query y obtenemos el resultado.
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, usuarioRut);
            result = stmt.executeQuery();

            // Vemos si no ha devuelto ningun resultado.
            if (!result.next()) {
                throw new SQLException();
            }

            // Construimos una VO para el producto.
            usuario = new Usuario();
            usuario.setRutusuario(result.getString("rutusuariousuario"));
            usuario.setNombre(result.getString("nombre"));
            usuario.setPaterno(result.getString("apellidop"));
            usuario.setMaterno(result.getString("apellidom"));
            usuario.setTelefono(result.getString("telefono"));
            usuario.setMail(result.getString("email"));
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

    public void save(Usuario usuario) {

        PreparedStatement saveUsuario;
        try {

            if (usuario.getRutusuario() == null) {
                saveUsuario = getConnection().prepareStatement(
                        "INSERT INTO usuario (rutusuario, nombre, paterno, materno, telefono , mail, privilegio, clave) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                saveUsuario.setString(1, usuario.getRutusuario());
                saveUsuario.setString(2, usuario.getNombre());
                saveUsuario.setString(3, usuario.getPaterno());
                saveUsuario.setString(4, usuario.getMaterno());
                saveUsuario.setString(5, usuario.getTelefono());
                saveUsuario.setString(6, usuario.getMail());
                saveUsuario.setString(7, usuario.getPrivilegio());
                saveUsuario.setString(8, usuario.getClave());
                
                System.out.println("INSERT INTO ....");
            } else {
                saveUsuario = getConnection().prepareStatement(
                        "UPDATE productos SET rutusuario = ?, nombre = ?, paterno = ?,"
                        + " materno = ?, telefono = ?, email = ? WHERE  rutusuario = ?");
                saveUsuario.setString(1, usuario.getRutusuario());
                saveUsuario.setString(2, usuario.getNombre());
                saveUsuario.setString(3, usuario.getPaterno());
                saveUsuario.setString(4, usuario.getMaterno());
                saveUsuario.setString(5, usuario.getTelefono());
                saveUsuario.setString(6, usuario.getMail());
                saveUsuario.setString(7, usuario.getPrivilegio());
                saveUsuario.setString(8, usuario.getClave());
            }

            saveUsuario.executeUpdate();
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

    protected void closeConnection() {
        DataBaseInstance.closeConnection();
    }
}
