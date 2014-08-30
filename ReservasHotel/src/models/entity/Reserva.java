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
    private String idcliente;
    private String rutusuario;

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

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getRutusuario() {
        return rutusuario;
    }

    public void setRutusuario(String rutusuario) {
        this.rutusuario = rutusuario;
    }
    
    
    
    
}
