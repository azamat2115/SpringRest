package uz.azamat.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.azamat.spring.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDAO {
    public JdbcTemplate template;

    public CarDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Car> getAll() {
        return template.query("select * from cars", new CarRowMapper());
    }

    @Override
    public Car get(int id) {
        String query = "select * from cars where id = ?";
        return template.queryForObject(query, new Object[]{id}, new CarRowMapper());
    }

    @Override
    public void save(Car car) {
        String query = "insert into cars(name, color) values (?,?)";
        template.update(query, car.getName(), car.getColor());
    }

    @Override
    public void update(Car car) {
        String query = "update cars set name = ?, color = ? where id = ?";
        template.update(query, car.getName(), car.getColor(), car.getId());
    }

    @Override
    public void delete(int id) {
        String query = "delete from cars where id = ?";
        template.update(query, id);
    }
}
