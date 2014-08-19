package models.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.entity.Usuario;
import utilities.DataBaseInstance;

public class UsuarioDao {
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
     public void conect(){
         this.getConnection();
     }
     public void disconec(){
         this.closeConnection();
     }
     
public List<Usuario>findPorNombre(String nombre){
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ResultSet result = null;
        try {
            String query = "SELECT * FROM usuario WHERE nombre LIKE ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1,"%"+nombre+"%");
            result = stmt.executeQuery();
            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setRut(result.getString("rut"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setPaterno(result.getString("paterno"));
                usuario.setMaterno(result.getString("materno"));
                usuario.setPrivilegio(result.getInt("privilegio"));
                usuario.setUsuario(result.getString("usuario"));
                usuario.setClave(result.getString("clave"));
                listaUsuarios.add(usuario);
            }
            result.close();
            stmt.close();
            closeConnection();
        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
        return listaUsuarios;
}    
    
    public List<Usuario> findAll() {
        List<Usuario> listaUsuarios = new LinkedList<Usuario>();
        ResultSet result = null;
        try {
            String query = "SELECT * FROM usuario";
            Statement stmt = getConnection().createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setRut(result.getString("rut"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setPaterno(result.getString("paterno"));
                usuario.setMaterno(result.getString("materno"));
                usuario.setPrivilegio(result.getInt("privilegio"));
                usuario.setUsuario(result.getString("usuario"));
                usuario.setClave(result.getString("clave"));
                listaUsuarios.add(usuario);
            }
            result.close();
            stmt.close();
            closeConnection();
        } catch (SQLException se) {
            System.out.println(se.toString());
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
        return listaUsuarios;
    }

    public Usuario findByRut(String usuarioRut) {
        ResultSet result = null;
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM usuario WHERE  rut = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, usuarioRut);
            result = stmt.executeQuery();
            if (!result.next()) {
                throw new SQLException();
            }
            usuario = new Usuario();
            usuario.setRut(result.getString("rut"));
            usuario.setNombre(result.getString("nombre"));
            usuario.setPaterno(result.getString("paterno"));
            usuario.setMaterno(result.getString("materno"));
            usuario.setPrivilegio(result.getInt("privilegio"));
            usuario.setUsuario(result.getString("usuario"));
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
            saveUsuario = getConnection().prepareStatement(
                    "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?)");
            saveUsuario.setString(1, usuario.getRut());
            saveUsuario.setString(2, usuario.getNombre());
            saveUsuario.setString(3, usuario.getPaterno());
            saveUsuario.setString(4, usuario.getMaterno());
            saveUsuario.setInt(5, usuario.getPrivilegio());
            saveUsuario.setString(6, usuario.getUsuario());
            saveUsuario.setString(7, usuario.getClave());
            saveUsuario.executeUpdate();
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
                 "UPDATE usuario SET nombre = ?, paterno = ?, materno = ?, "
                    + "privilegio = ?, usuario = ?, clave = ? WHERE  rut = ?");
            saveUsuario.setString(1, usuario.getNombre());
            saveUsuario.setString(2, usuario.getPaterno());
            saveUsuario.setString(3, usuario.getMaterno());
            saveUsuario.setInt(4, usuario.getPrivilegio());
            saveUsuario.setString(5, usuario.getUsuario());
            saveUsuario.setString(6, usuario.getClave());
            saveUsuario.setString(7, usuario.getRut());
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
            delUsuario = getConnection().prepareStatement(
                    "DELETE FROM usuario WHERE rut = ?");
            delUsuario.setString(1, usuario.getRut());
            delUsuario.executeUpdate();
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