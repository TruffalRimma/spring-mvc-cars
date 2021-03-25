package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAO {

    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("white", "BMW", 16));
        cars.add(new Car("blue", "Cadillac", 25500));
        cars.add(new Car("green", "Audi", 880));
        cars.add(new Car("pink", "Tesla", 525));
        cars.add(new Car("black", "Lamborghini", 138));
    }

    public List<Car> getCars() {
        return cars;
    }
}
