package fr.eni.pizza12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MappingController {
    @GetMapping("/")
    public String helloPizza12() {
        return "index";
    }

    @GetMapping("/designSystem")
    public String designSystem() {
        return "designSystem";
    }

    @GetMapping("/account")
    public String openAccount() {
        return "account";
    }

    @GetMapping("/cart")
    public String openCart() {
        return "cart";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/employeeRedirect")
    public String serviceTools() {
        return "serviceTools";
    }

    @GetMapping("/listOrders")
    public String listOrders() {
        return "listOrders";
    }

    @GetMapping("orderTool")
    public String orderTool() {
        return "orderTool";
    }
}
