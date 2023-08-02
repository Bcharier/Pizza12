package fr.eni.pizza12.bll;

import java.util.List;

import fr.eni.pizza12.bo.OrderEntity;

public interface OrderService {

  public List<OrderEntity> getAllPendingOrdersAndAssociatedOrderItems();

}
