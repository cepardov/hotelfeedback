/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.beans;
import models.dao.Usuariodao;
import models.entity.Usuario;

public class Usuariobeans extends Usuario {
    Usuariodao usuariodao=new Usuariodao();
    
    public void save(){
        usuariodao.save(this);
    }
    public void delete(){
        usuariodao.delete(this);
    }
    public void update(){
        usuariodao.update(this);
    }
}
