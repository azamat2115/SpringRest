package uz.azamat.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class CarController {
    private static final List<Car> cars = new CopyOnWriteArrayList<>();

    static {
        cars.add(new Car(1, "BMW", "Black"));
        cars.add(new Car(2, "Mercedes Benz", "White"));
        cars.add(new Car(3, "Tesla", "Red"));
        cars.add(new Car(4, "Chevrolet", "Black"));
        cars.add(new Car(5, "Toyota", "White"));
        cars.add(new Car(6, "Infinity", "Blue"));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = "application/json")
    public List<Car> getAllCars() {
        return cars;
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET, produces = "application/json")
    public Car getOneCarById(@RequestParam("id") int id) {
        for (Car car : cars) {
            if (id == car.getId()) {
                return car;
            }
        }
        return null;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String addNewCar(@RequestParam("id") int id, @RequestParam("carName") String name,
                            @RequestParam("carColor") String color) {

        cars.add(new Car(id, name, color));

        return "Car added successfully!";
    }

    @RequestMapping(value = "/car", method = RequestMethod.DELETE)
    public String deleteCarById(@RequestParam int id) {
        cars.removeIf(car -> id == car.getId());
        return "Car removed successfully!";
    }

    @RequestMapping(value = "/car", method = RequestMethod.PUT)
    public String upDateCars(@RequestParam("id") int id, @RequestParam("carName") String name,
                             @RequestParam("carColor") String color) {
        cars.set(id - 1, new Car(id, name, color));

        return "Car successfully updated";
    }
}
