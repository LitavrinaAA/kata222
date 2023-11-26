package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;


@Controller
public class CarsController {
    private final CarServiceImp carService;

    public CarsController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getSomeCars(@RequestParam(value = "count",defaultValue = "5",required = false)
                                  int quantity, Model model) {
        model.addAttribute("cars", carService.listQuantityCars(quantity));

        return "cars";
    }

}
