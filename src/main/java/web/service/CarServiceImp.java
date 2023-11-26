package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImp implements CarService {
    private final List<Car> cars = new ArrayList<>() ;
    int id = 1;
    {
        cars.add(new Car(id++,"Гетц","красный"));
        cars.add(new Car(id++,"Сузуки","красный"));
        cars.add(new Car(id++,"Volvo","кофе с молоком"));
        cars.add(new Car(id++,"модель4","цвет1"));
        cars.add(new Car(id++,"модель5","цвет1"));
    }

    @Override
    public List<Car> listQuantityCars(int quantity) {
        if ( quantity < 0 && quantity > cars.size()) {
            quantity = 0;
        }
        return cars.stream().limit(quantity).toList();
    }
}
