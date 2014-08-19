package models.beans;
import java.util.List;
import models.dao.Usuariodao;
import models.entity.Usuario;
/**
 *
 * @author Luis
 */
public class Usuariobeans extends Usuario{
    private Usuariodao usuarioDao = new Usuariodao();

    public Usuario findByRut() {
        Usuario usuario = null;
        if (rutusuario != null) {
            usuario = usuarioDao.findByRut(rutusuario);
        } else {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void save() {
        usuarioDao.save(this);
    }

    public void delete() {
        usuarioDao.delete(this);
    }
    
}
