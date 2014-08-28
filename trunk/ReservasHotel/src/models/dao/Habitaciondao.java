package models.dao;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.entity.Habitacion;
import utilidades.DataBaseInstance;


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
     
     public Object [][] getHabitaciones(){
        int posid = 0;
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT count(1) as total FROM habitacion");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
        Object[][] data = new String[posid][5];
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT idhabitacion, piso, idtipo, descripcion, foto FROM habitacion ORDER BY idhabitacion");
            ResultSet res = pstm.executeQuery();
            int increment = 0;
            while(res.next()){
                String estIdhabitacion = res.getString("idhabitacion");
                String estPiso = res.getString("piso");
                String estIdtipo = res.getString("idtipo");
                String estDescripcion = res.getString("descripcion");
                String estFoto = res.getString("foto");
                data[increment][0] = estIdhabitacion;
                data[increment][1] = estPiso;
                data[increment][2] = estIdtipo;
                data[increment][3] = estDescripcion;
                data[increment][4] = estFoto;
                increment++;
            }
            res.close();
            closeConnection();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
        return data;
    }
     
     public Object [][] getFotoHabitacion(int idhabitacion){
        int posid = 0;
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT count(1) as total FROM habitacion");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
        Object[][] data = new String[posid][1];
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT foto FROM habitacion WHERE idhabitacion="+idhabitacion);
            ResultSet res = pstm.executeQuery();
            int increment = 0;
            while(res.next()){
                String estFoto = res.getString("foto");
                data[increment][0] = estFoto;
                increment++;
            }
            res.close();
            closeConnection();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
        return data;
    }

    public void save(Habitacion habitacion) {
        PreparedStatement saveHabitacion;
        try {
            saveHabitacion = getConnection().prepareStatement(
                    "INSERT INTO habitacion VALUES (?, ?, ?, ?, ?)");
            saveHabitacion.setInt(1, habitacion.getIdhabitacion());
            saveHabitacion.setInt(2, habitacion.getPiso());
            saveHabitacion.setInt(3, habitacion.getIdtipo());
            saveHabitacion.setString(4, habitacion.getDescripcion());
            saveHabitacion.setBlob(5, habitacion.getFoto());
                       
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
            saveHabitacion.setInt(2, habitacion.getPiso());
            saveHabitacion.setInt(3, habitacion.getIdtipo());
            saveHabitacion.setString(4, habitacion.getDescripcion());
            saveHabitacion.setBlob(2, habitacion.getFoto());
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