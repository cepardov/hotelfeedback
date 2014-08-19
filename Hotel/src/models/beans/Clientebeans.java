package models.beans;
import models.dao.Clientedao;
import models.entity.Cliente;

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
