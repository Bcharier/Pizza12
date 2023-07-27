package fr.eni.pizza12.controller;

import fr.eni.pizza12.dal.PizzaDAOImpl;
import fr.eni.pizza12.dal.PizzaEntity;
import fr.eni.pizza12.dal.PizzaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

  private PizzaDAO pizzaDAO;


  FormController(PizzaDAO pizzaDao) {
    this.pizzaDAO = pizzaDao;
  }


  @GetMapping("/")
  public String index(Model model) {
    return "index";
  }

  @GetMapping("/designSystem")
  public String designSystem(Model model) {
    return "designSystem";
  }

  @PostMapping("/form")
  public String form(Model model) {
    return "result";
  }

  @GetMapping("/getPizzas")
  public String getAllPizzas(Model model) {
    // This returns a JSON or XML with the users
    model.addAttribute("pizzas", pizzaDAO.getAllPizzas());
    model.addAttribute("pizza", new PizzaEntity());
    return "result";
  }

  @GetMapping("/getPizzasWithoutMushRooms")
  public String getAllPizzasWithoutMushrooms() {
    // This returns a JSON or XML with the users

    return "index";
  }
}