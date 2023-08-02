package fr.eni.pizza12.controller;

import fr.eni.pizza12.dal.OrderRepository;
import fr.eni.pizza12.dal.ProductRepository;
import fr.eni.pizza12.bll.OrderService;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.ProductEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class MappingController {

  private ProductRepository productRepository;

  @Autowired
  private OrderService orderService;

  public MappingController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping("/")
  public String helloPizza12(Model model) {
    List<ProductEntity> menu = productRepository.getAllProductsAndCategories();

    model.addAttribute("products", menu);
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
    List<OrderEntity> orderList = orderService.getAllPendingOrdersAndAssociatedOrderItems();
    model.addAttribute("orderList", orderList);
    return "listOrders";
  }

  @GetMapping("orderTool")
  public String orderTool() {
    return "orderTool";
  }
}
