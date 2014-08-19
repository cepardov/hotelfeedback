
package models.entity;

/**
 *
 * @author Luis
 */
public class Reserva {
    private int idreserva;
    private String fechareserva;
    private String fechainicio;
    private String fechatermino;
    private int idhabitacion;
    private int idcliente;
    private int rutusuario;

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(String fechareserva) {
        this.fechareserva = fechareserva;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechatermino() {
        return fechatermino;
    }

    public void setFechatermino(String fechatermino) {
        this.fechatermino = fechatermino;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getRutusuario() {
        return rutusuario;
    }

    public void setRutusuario(int rutusuario) {
        this.rutusuario = rutusuario;
    }
    
    
    
    
}
