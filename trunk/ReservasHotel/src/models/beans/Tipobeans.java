/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.beans;
import models.dao.Tipodao;
import models.entity.Tipo;

public class Tipobeans extends Tipo {
    Tipodao tipodao=new Tipodao();
    public void buscarnombres(){
        tipodao.buscarnombre(this);
    }
    public void save(){
        tipodao.save(this);
    }
    public void delete(){
        tipodao.delete(this);
    }
    public void update(){
        tipodao.update(this);
    }
    
}
