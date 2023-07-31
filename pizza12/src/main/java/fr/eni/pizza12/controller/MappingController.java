package fr.eni.pizza12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.ProductEntity;
import fr.eni.pizza12.dal.OrderRepository;
import fr.eni.pizza12.dal.ProductRepository;

@Controller
public class MappingController {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    MappingController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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
    public String listOrders(Model model) {
        List<OrderEntity> listOrders;
        listOrders = orderRepository.getAllOrders();

        List<OrderItemEntity> listOrderItems;
        listOrderItems = order

        model.addAttribute("orders", listOrders);

        return "listOrders";
    }

    @GetMapping("orderTool")
    public String orderTool() {
        return "orderTool";
    }

}
