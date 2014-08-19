
package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.entity.Reserva;
import utilities.DataBaseInstance;

public class Reservadao {
     protected Connection getConnection() {
        return DataBaseInstance.getInstanceConnection();
    }
    
     public void conect(){
         this.getConnection();
     }
     public void disconec(){
         this.closeConnection();
     }
     
     public Reserva buscar(String reservaRut) {
        ResultSet result = null;
        Reserva reserva = null;
        try {
            String query = "SELECT * FROM  WHERE  idreserva = ?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, reservaRut);
            result = stmt.executeQuery();
            if (!result.next()) {
                throw new SQLException();
            }
            reserva = new Reserva();
            reserva.setIdreserva(result.getInt("idreserva"));
            reserva.setFechareserva(result.getString("fechareserva"));
            reserva.setFechainicio(result.getString("fechainicio"));
            reserva.setFechatermino(result.getString("fechatermino"));
            reserva.setIdhabitacion(result.getInt("idhabitacion"));
            reserva.setIdcliente(result.getInt("idcliente"));
            reserva.setRutusuario(result.getInt("rutusuario"));
            
            result.close();
            stmt.close();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
        return reserva;
    }

    public void save(Reserva reserva) {
        PreparedStatement saveReserva;
        try {
            saveReserva = getConnection().prepareStatement(
                    "INSERT INTO reserva VALUES (?, ?, ?, ?, ?, ?)");
            saveReserva.setString(1, reserva.getFechareserva());
            saveReserva.setString(2, reserva.getFechainicio());
            saveReserva.setString(3, reserva.getFechatermino());
            saveReserva.setInt(4, reserva.getIdhabitacion());
            saveReserva.setInt(5, reserva.getIdcliente());
            saveReserva.setInt(6, reserva.getRutusuario());
            
            saveReserva.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }
    
    public void update(Reserva reserva) {
        PreparedStatement saveReserva;
        try {
            saveReserva = getConnection().prepareStatement(
                 "UPDATE reserva SET fechareserva = ?, fechainicio = ?, fechatermino = ?, "
                    + "idhabitacion = ?, idcliente = ? , rutusuario = ? WHERE  idreserva = ?");
            saveReserva.setString(1, reserva.getFechareserva());
            saveReserva.setString(2, reserva.getFechainicio());
            saveReserva.setString(3, reserva.getFechatermino());
            saveReserva.setInt(4, reserva.getIdhabitacion());
            saveReserva.setInt(5, reserva.getIdcliente());
            saveReserva.setInt(6, reserva.getRutusuario());
            saveReserva.setInt(7, reserva.getIdreserva());
            saveReserva.executeUpdate();
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }

    public void delete(Reserva reserva) {
        PreparedStatement delReserva;
        try {
            delReserva = getConnection().prepareStatement(
                    "DELETE FROM reserva WHERE idreserva = ?");
            delReserva.setInt(1, reserva.getIdreserva());
            delReserva.executeUpdate();
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
