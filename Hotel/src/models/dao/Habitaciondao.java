package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.entity.Habitacion;
import utilities.DataBaseInstance;


public class Habitaciondao {
    protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
     public void conect(){
         this.getConnection();
     }
     public void disconec(){
         this.closeConnection();
     }
     
     public Habitacion findByRut(String habitacionRut) {
        ResultSet result = null;
        Habitacion habitacion = null;
        try {
            String query = "SELECT * FROM  WHERE  idhabitacion = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, habitacionRut);
            result = stmt.executeQuery();
            if (!result.next()) {
                throw new SQLException();
            }
            habitacion = new Habitacion();
            habitacion.setIdhabitacion(result.getInt("idhabitacion"));
            habitacion.setPiso(result.getString("nombre"));
            habitacion.setIdtipo(result.getInt("piso"));
            habitacion.setDescripcion(result.getString("descripcion"));
            habitacion.setFoto(result.getString("foto"));
  
            
            result.close();
            stmt.close();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
        return habitacion;
    }

    public void save(Habitacion habitacion) {
        PreparedStatement saveHabitacion;
        try {
            saveHabitacion = getConnection().prepareStatement(
                    "INSERT INTO habitacion VALUES (?, ?, ?, ?, ?)");
            saveHabitacion.setInt(1, habitacion.getIdhabitacion());
            saveHabitacion.setString(2, habitacion.getPiso());
            saveHabitacion.setInt(3, habitacion.getIdtipo());
            saveHabitacion.setString(4, habitacion.getDescripcion());
            saveHabitacion.setString(2, habitacion.getFoto());
                       
            saveHabitacion.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }
    
    public void update(Habitacion habitacion) {
        PreparedStatement saveHabitacion;
        try {
            saveHabitacion = getConnection().prepareStatement(
                 "UPDATE habitacion SET idhabitacion = ?, piso = ?, idtipo = ?, "
                    + "descripcion = ?, foto = ? WHERE  idhabitacion = ?");
            saveHabitacion.setInt(1, habitacion.getIdhabitacion());
            saveHabitacion.setString(2, habitacion.getPiso());
            saveHabitacion.setInt(3, habitacion.getIdtipo());
            saveHabitacion.setString(4, habitacion.getDescripcion());
            saveHabitacion.setString(2, habitacion.getFoto());
            saveHabitacion.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Habitacion habitacion) {
        PreparedStatement delHabitacion;
        try {
            delHabitacion = getConnection().prepareStatement(
                    "DELETE FROM habitacion WHERE idhabitacion = ?");
            delHabitacion.setInt(1, habitacion.getIdhabitacion());
            delHabitacion.executeUpdate();
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
