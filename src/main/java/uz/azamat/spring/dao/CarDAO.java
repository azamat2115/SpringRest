package uz.azamat.spring.dao;

import uz.azamat.spring.model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> getAll();

    Car get(int id);

    void save(Car car);

    void update(Car car);

    void delete(int id);
}
