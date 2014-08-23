/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.beans;

import models.dao.Clientedao;
import models.entity.Cliente;

/**
 *
 * @author Luis
 */
public class Clientebeans extends Cliente{
     private Clientedao Clientedao = new Clientedao();
    
    public void save(){
        Clientedao.save(this);
    } 
    public void update(){
        Clientedao.update(this);
    }
    public void delete(){
        Clientedao.delete(this);
    }
}
