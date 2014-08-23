/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.entity.Cliente;
import utilidades.DataBaseInstance;

/**
 *
 * @author Luis
 */
public class Clientedao {
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
     public void conect(){
         this.getConnection();
     }
     public void disconec(){
         this.closeConnection();
     }
     
     public Cliente findByRut(String clienteRut) {
        ResultSet result = null;
        Cliente cliente = null;
        try {
            String query = "SELECT * FROM  WHERE  idcliente = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, clienteRut);
            result = stmt.executeQuery();
            if (!result.next()) {
                throw new SQLException();
            }
            cliente = new Cliente();
            cliente.setIdcliente(result.getString("idcliente"));
            cliente.setNombre(result.getString("nombre"));
            cliente.setPaterno(result.getString("paterno"));
            cliente.setMaterno(result.getString("materno"));
            cliente.setTelefono(result.getString("telefono"));
            cliente.setMail(result.getString("mail"));
            
            result.close();
            stmt.close();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
        return cliente;
    }

    public void save(Cliente cliente) {
        PreparedStatement saveCliente;
        try {
            saveCliente = getConnection().prepareStatement(
                    "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?)");
            saveCliente.setString(1, cliente.getIdcliente());
            saveCliente.setString(2, cliente.getNombre());
            saveCliente.setString(3, cliente.getPaterno());
            saveCliente.setString(4, cliente.getMaterno());
            saveCliente.setString(2, cliente.getTelefono());
            saveCliente.setString(3, cliente.getMail());
            
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
            saveCliente.setString(2, cliente.getTelefono());
            saveCliente.setString(3, cliente.getMail());
            saveCliente.setString(7, cliente.getIdcliente());
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
}
