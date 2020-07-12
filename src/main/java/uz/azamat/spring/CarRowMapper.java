package uz.azamat.spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setName(resultSet.getString("name"));
        car.setColor(resultSet.getString("color"));
        return car;
    }
}
