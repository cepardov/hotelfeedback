package models.beans;
import models.dao.Habitaciondao;
import models.entity.Habitacion;
public class Habitacionbeans extends Habitacion{
    private Habitaciondao habitaciondao = new Habitaciondao();
    
    public void save(){
        habitaciondao.save(this);
    }
    public void update(){
        habitaciondao.update(this);
    }
    public void delete(){
        habitaciondao.delete(this);
    }

}

