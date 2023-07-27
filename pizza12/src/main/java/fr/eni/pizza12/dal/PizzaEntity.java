package fr.eni.pizza12.dal;

public class PizzaEntity {

  public PizzaEntity() {

  }

  public PizzaEntity(Integer pizzaId, String pizzaName) {
    this.pizzaId = pizzaId;
    this.pizzaName = pizzaName;
  }

  private Integer pizzaId;

  private String pizzaName;

  public Integer getPizzaId() {
    return pizzaId;
  }

  public void setPizzaId(Integer pizzaId) {
    this.pizzaId = pizzaId;
  }

  public String getPizzaName() {
    return pizzaName;
  }

  public void setPizzaName(String pizzaName) {
    this.pizzaName = pizzaName;
  }
}