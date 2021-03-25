package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.model.Car;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarDAO car;

    public List<Car> getCars(int count) {
        List<Car> cars;
        if (count < 5) {
            cars = car.getCars().subList(0, count);
        } else {
            cars = car.getCars();
        }
        return cars;
    }
}
