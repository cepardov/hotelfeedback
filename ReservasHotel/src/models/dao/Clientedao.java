/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.entity.Cliente;
import utilidades.DataBaseInstance;

/**
 *
 * @author Luis
 */
public class Clientedao {
    String idcliente, nombre, paterno,materno;
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
     public void conect(){
         this.getConnection();
     }
     public void disconec(){
         this.closeConnection();
     }
     
     public void getClienteByRut(String rutcliente){
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT idcliente, nombre, paterno, materno, telefono, mail FROM cliente WHERE idcliente='"+rutcliente+"'");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                this.setIdcliente(res.getString("idcliente"));
                this.setNombre(res.getString("nombre"));
                this.setPaterno(res.getString("paterno"));
                this.setMaterno(res.getString("materno"));
            }
            res.close();
            this.closeConnection();
            
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
        }
    }
     
    public Object [][] getCliente(){
        int posid = 0;
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT count(1) as total FROM cliente");
            ResultSet res = pstm.executeQuery();
            res.next();
            posid = res.getInt("total");
            res.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        Object[][] data = new String[posid][6];
        try{
            PreparedStatement pstm = getConnection().prepareStatement("SELECT idcliente, nombre, paterno, materno, telefono, mail FROM cliente");
            ResultSet res = pstm.executeQuery();
            int increment = 0;
            while(res.next()){
                String estIdcliente = res.getString("idcliente");
                String estNombre = res.getString("nombre");
                String estPaterno = res.getString("paterno");
                String estMaterno = res.getString("materno");
                String estTelefono = res.getString("telefono");
                String estMail = res.getString("mail");
                data[increment][0] = estIdcliente;
                data[increment][1] = estNombre;
                data[increment][2] = estPaterno;
                data[increment][3] = estMaterno;
                data[increment][4] = estTelefono;
                data[increment][5] = estMail;
                increment++;
            }
            res.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }
    public void save(Cliente cliente) {
        PreparedStatement saveCliente;
        try {
            saveCliente = getConnection().prepareStatement(
                    "INSERT INTO cliente (idcliente, nombre, paterno, materno, telefono, mail) VALUES (?, ?, ?, ?, ?, ?)");
            saveCliente.setString(1, cliente.getIdcliente());
            saveCliente.setString(2, cliente.getNombre());
            saveCliente.setString(3, cliente.getPaterno());
            saveCliente.setString(4, cliente.getMaterno());
            saveCliente.setString(5, cliente.getTelefono());
            saveCliente.setString(6, cliente.getMail());
            
            saveCliente.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }
    
    public void update(Cliente cliente) {
        PreparedStatement saveCliente;
        try {
            saveCliente = getConnection().prepareStatement(
                 "UPDATE cliente SET nombre = ?, paterno = ?, materno = ?, "
                    + "telefono = ?, mail = ? WHERE  idcliente = ?");
            saveCliente.setString(1, cliente.getNombre());
            saveCliente.setString(2, cliente.getPaterno());
            saveCliente.setString(3, cliente.getMaterno());
            saveCliente.setString(4, cliente.getTelefono());
            saveCliente.setString(5, cliente.getMail());
            saveCliente.setString(6, cliente.getIdcliente());
            saveCliente.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Cliente cliente) {
        PreparedStatement delCliente;
        try {
            delCliente = getConnection().prepareStatement(
                    "DELETE FROM cliente WHERE idcliente = ?");
            delCliente.setString(1, cliente.getIdcliente());
            delCliente.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    protected void closeConnection() {
        DataBaseInstance.closeConnection();
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    
}
