package models.beans;
import java.util.List;
import models.dao.UsuarioDao;
import models.entity.Usuario;

public class UsuarioBean extends Usuario {
    
     private UsuarioDao usuarioDao = new UsuarioDao();
    
    public String findrutNombre() {
        usuarioDao.findByRut(rut);
        return rut;
    }
    
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    public Usuario findByRut() {
        Usuario usuario = null;
        if (rut != null) {
            usuario = usuarioDao.findByRut(rut);
        } else {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void save() {
        usuarioDao.save(this);
    }
    
    public void update() {
        usuarioDao.update(this);
    }

    public void delete() {
        usuarioDao.delete(this);
    }
}