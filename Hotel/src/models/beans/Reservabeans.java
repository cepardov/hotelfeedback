package models.beans;
import models.dao.Reservadao;
import models.entity.Reserva;

public class Reservabeans extends Reserva{
    private Reservadao reservadao = new Reservadao();
    
    public void save(){
        reservadao.save(this);
    }
    public void update(){
        reservadao.update(this);
    }
    public void delete(){
        reservadao.delete(this);
    }
}
