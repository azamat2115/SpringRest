package uz.azamat.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.azamat.spring.dao.CarDAO;
import uz.azamat.spring.model.Car;

import java.util.List;

@Service
@Slf4j
public class CarService {
    @Autowired
    CarDAO dao;

    public List<Car> getAll() {
        log.info("Getting list of all cars");
        return dao.getAll();
    }

    public Car get(int id) {
        return dao.get(id);
    }

    public void save(Car car) {
        log.info("Saving new car " + car);
        dao.save(car);
    }

    public void delete(int id) {
        log.info("Delete car by id " + id);
        dao.delete(id);
    }

    public void update(Car car) {
        log.info("Updating car " + car);
        dao.update(car);
    }
}
