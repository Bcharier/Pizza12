package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderStatus;

public interface OrderRepository {

  public List<OrderEntity> getAllOrders();

  public OrderEntity getOrderByOrderId(int orderId);

  public List<OrderEntity> getOrderByAccountId(int accountId);

  public List<OrderEntity> getOrderByTableNumber(int tableNumber);

  public List<OrderEntity> getOrderByOrderState(OrderStatus orderState);

  public List<OrderEntity> getOrderByAccountIdAndByOrderState(int accountId, OrderStatus orderState);

  public void addOrder(OrderEntity orderEntity);

  public void updateOrder(OrderEntity orderEntity);

  public List<OrderEntity> getAllPendingOrders();
}
