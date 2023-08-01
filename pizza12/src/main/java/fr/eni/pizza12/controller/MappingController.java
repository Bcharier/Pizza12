package fr.eni.pizza12.controller;

import fr.eni.pizza12.dal.OrderItemRepository;
import fr.eni.pizza12.dal.ProductRepository;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.ProductEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class MappingController {

  private ProductRepository productRepository;
  private OrderItemRepository orderItemRepository;

  public MappingController(ProductRepository productRepository, OrderItemRepository orderItemRepository) {
    this.productRepository = productRepository;
    this.orderItemRepository = orderItemRepository;
  }

  @GetMapping("/")
  public String helloPizza12(Model model) {
    List<ProductEntity> menu = new ArrayList<>();
    menu = productRepository.getAllProductsAndCategories();

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
    List<OrderItemEntity> orderList = new ArrayList<>();
    orderList = orderItemRepository.getAllPendingOrdersItems();
    model.addAttribute("orderList", orderList);
    return "listOrders";
  }

  @GetMapping("orderTool")
  public String orderTool() {
    return "orderTool";
  }

  /*
   * @GetMapping("/getPizzas")
   * public String getAllPizzas(Model model) {
   * // This returns a JSON or XML with the users
   * // Récupérer les catégories
   * // Boucler categorie.size()
   * // Pour chaque numéro, récupérer la liste des produits
   * // Stocker la liste dans une List de List
   * // Fin boucle
   * model.addAttribute("pizzas", pizzaDAO.getAllProductsAndCategories());
   * // model.addAttribute("pizza", new PizzaEntity());
   * return "result";
   * }
   */
}
