package fr.eni.pizza12.dal;


import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface PizzaDAO {
  public List<PizzaEntity> getAllPizzas();

  public int insertPizza();

}