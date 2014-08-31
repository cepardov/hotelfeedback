package utilidades;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author cepardov <cepardov@gmail.com>
 */

public class Usuario{
	private String rut,nombre,paterno,materno,privilegio,clave;

	/** Crea un nueva instancia de la clase usuario */
	public Usuario(){
        }
        public Usuario verificarUsuario(String usuario, String clave){
        Usuario u=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            cn=DataBaseInstance.getInstanceConnection();
            String sql="SELECT * FROM usuario WHERE rutusuario=? AND clave=?";
            pr=cn.prepareStatement(sql);
            pr.setString(1, usuario);
            pr.setString(2, clave);
            rs=pr.executeQuery();
            while(rs.next()){
                u=new Usuario();
                u.setRut(rs.getString("rutusuario"));
                u.setNombre(rs.getString("nombre"));
                u.setPaterno(rs.getString("paterno"));
                u.setMaterno(rs.getString("materno"));
                u.setPrivilegio(rs.getString("privilegio"));
                u.setClave(rs.getString("clave"));
                break;
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se);
            u=null;
        }finally{
            try{
                rs.close();
                pr.close();
                rs.close();
                DataBaseInstance.closeConnection();
            }catch(SQLException se){
                JOptionPane.showMessageDialog(null, se);
            }
        }
        return u;
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

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
     
}