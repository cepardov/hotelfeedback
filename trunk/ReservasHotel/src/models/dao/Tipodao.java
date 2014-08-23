package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.entity.Tipo;
import utilidades.DataBaseInstance;

public class Tipodao {
    protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
     public void conect(){
         this.getConnection();
     }
     public void disconec(){
         this.closeConnection();
     }
     /*
     public Tipo findAll(String tipo) {
        ResultSet result = null;
        Tipo tipo = null;
        try {
            String query = "SELECT * FROM  WHERE  idtipo = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, tipo);
            result = stmt.executeQuery();
            if (!result.next()) {
                throw new SQLException();
            }
            tipo = new Tipo();
            tipo.setIdtipo(result.getInt("idtipo"));
            tipo.setNombre(result.getString("nombre"));
            tipo.setDescripcion(result.getString("paterno"));
            tipo.setPrecio(result.getString("materno"));
                     
            result.close();
            stmt.close();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
        return tipo;
    }
    */
    public void save(Tipo tipo) {
        PreparedStatement saveTipo;
        try {
            saveTipo = getConnection().prepareStatement(
                    "INSERT INTO tipo VALUES (?, ?, ?)");
            saveTipo.setString(1, tipo.getNombre());
            saveTipo.setString(2, tipo.getDescripcion());
            saveTipo.setString(3, tipo.getPrecio());
            
            
            saveTipo.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }
    
    public void update(Tipo tipo) {
        PreparedStatement saveTipo;
        try {
            saveTipo = getConnection().prepareStatement(
                 "UPDATE tipo SET nombre = ?, descripcion = ?, precio = ?, "
                    + "WHERE  idtipo = ?");
            saveTipo.setString(1, tipo.getNombre());
            saveTipo.setString(2, tipo.getDescripcion());
            saveTipo.setString(3, tipo.getPrecio());
            saveTipo.setInt(4, tipo.getIdtipo());
            saveTipo.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Tipo tipo) {
        PreparedStatement delTipo;
        try {
            delTipo = getConnection().prepareStatement(
                    "DELETE FROM tipo WHERE idtipo = ?");
            delTipo.setInt(1, tipo.getIdtipo());
            delTipo.executeUpdate();
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
