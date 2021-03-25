package web.controller;

/*
Задание:
1. Создайте еще один контроллер, замаппленный на /cars.
2. Создайте модель Car с тремя произвольными полями.
3. Создайте список из 5 машин.
3. Создайте сервис с методом, который будет возвращать указанное число машин из созданного списка.
4. Создайте страницу cars.html. Реализуйте создание таблицы с машинами из сервиса с помощью thymeleaf.
5. При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из 2 машин,
при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String showCars(@RequestParam(required = false) Integer count, Model model) {
        try {
            model.addAttribute("cars", carService.getCars(count));
        } catch (NullPointerException e) {
            model.addAttribute("cars", carService.getCars(5));
        }
        return "cars";
    }
}
