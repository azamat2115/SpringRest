package uz.azamat.spring;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class CarController {
    @Resource
    public CarService service;

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = "application/json")
    public List<Car> getAllCars() {
        return service.getAll();
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET, produces = "application/json")
    public Car getOneCarById(@RequestParam("id") int id) {
        return service.get(id);
    }

    //
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public void addNewCar(@RequestBody Car car) {
        service.save(car);
    }

    @RequestMapping(value = "/car", method = RequestMethod.PUT)
    public void upDateCars(@RequestBody Car car) {
        service.update(car);
    }

    @RequestMapping(value = "/car", method = RequestMethod.DELETE)
    public void deleteCarById(@RequestParam int id) {
        service.delete(id);
    }
}
