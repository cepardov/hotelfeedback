package models.dao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import models.entity.Habitacion;
import utilidades.CustomImageIcon;
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
     
     public void pisomaximo(Habitacion habitacion){   
         try{
            PreparedStatement pstm = getConnection().prepareStatement("select max(idhabitacion), max(piso) from HABITACION");
          
            ResultSet res = pstm.executeQuery();
            res.next();
            habitacion.setIdhabitacion(res.getInt("1"));
            habitacion.setPiso(res.getInt("2"));
            res.close();
            
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
            }
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
            PreparedStatement pstm = getConnection().prepareStatement("select idhabitacion, piso,idtipo, descripcion, foto from HABITACION ORDER BY idhabitacion");
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
     
     public static CustomImageIcon getFoto(int id){
         CustomImageIcon ii = null;
         InputStream is = null;
         try {
            Connection conexion = DataBaseInstance.getInstanceConnection();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT foto FROM habitacion WHERE idhabitacion = "+id);
            if(rs.next()){
               is = rs.getBinaryStream(1);
               if(is != null){
                   BufferedImage bi = ImageIO.read(is);
                   ii = new CustomImageIcon(bi);
               }
               
           }
            rs.close();
            DataBaseInstance.closeConnection();
        } catch (SQLException ex) {
             System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(Habitaciondao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ii;
    }

    public void save(Habitacion habitacion) {
        PreparedStatement saveHabitacion;
        try {
            saveHabitacion = getConnection().prepareStatement(
                    "INSERT INTO habitacion(numerohabitacion,piso,idtipo,descripcion,foto) VALUES (?, ?, ?, ?, ?)");
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
            saveHabitacion.setBlob(5, habitacion.getFoto());
            saveHabitacion.setInt(6, habitacion.getIdhabitacion());
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