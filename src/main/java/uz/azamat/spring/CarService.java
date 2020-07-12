package uz.azamat.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarDAO dao;

    public List<Car> getAll() {
        return dao.getAll();
    }

    public Car get(int id) {
        return dao.get(id);
    }
    public void save(Car car){
        dao.save(car);
    }
    public void delete(int id){
        dao.delete(id);
    }
    public void update(Car car){
        dao.update(car);
    }
}
