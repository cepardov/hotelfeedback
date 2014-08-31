package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.entity.Tipo;
import utilidades.DataBaseInstance;
/***
 * 
 * @author cepardov
 */
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
      public Object[][] buscarnombre(Tipo tipo){
               
         int posid = 0;
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT count(1) as total FROM tipo");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        Object[][] data = new String[posid][1];
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT nombre FROM tipo");
            ResultSet res = pstm.executeQuery();
            int increment = 0;
            while(res.next()){
                String estNombre = res.getString("nombre");
                data[increment][0] = estNombre;
               
                increment++;
            }
            res.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }
     public Object [][] getTipo(){
        int posid = 0;
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT count(1) as total FROM tipo");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        Object[][] data = new String[posid][6];
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT idtipo, nombre, descripcion, precio FROM tipo ORDER BY idtipo");
            ResultSet res = pstm.executeQuery();
            int increment = 0;
            while(res.next()){
                String estIdtipo = Integer.toString(res.getInt("idtipo"));
                String estNombre = res.getString("nombre");
                String estDescripcion = res.getString("descripcion");
                String estPrecio = Integer.toString(res.getInt("precio"));
                data[increment][0] = estIdtipo;
                data[increment][1] = estNombre;
                data[increment][2] = estDescripcion;
                data[increment][3] = estPrecio;
                increment++;
            }
            res.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }

    public void save(Tipo tipo) {
        PreparedStatement saveTipo;
        try {
            saveTipo = getConnection().prepareStatement(
                    "INSERT INTO tipo(nombre,descripcion,precio) VALUES (?, ?, ?)");
            saveTipo.setString(1, tipo.getNombre());
            saveTipo.setString(2, tipo.getDescripcion());
            saveTipo.setInt(3, tipo.getPrecio());
            
            
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
                 "UPDATE tipo SET nombre = ?, descripcion = ?, precio = ? WHERE  idtipo = ?");
            saveTipo.setString(1, tipo.getNombre());
            saveTipo.setString(2, tipo.getDescripcion());
            saveTipo.setInt(3, tipo.getPrecio());
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
