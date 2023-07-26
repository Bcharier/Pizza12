package fr.eni.pizza12.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/")
    public String helloPizza12() {
        return "index";
    }

    @GetMapping("/listePizza")
    public String testListePizza() {
        return "listePizza";
    }

    @GetMapping("/designSystem")
    public String designSystem() {
        return "designSystem";
    }
}
