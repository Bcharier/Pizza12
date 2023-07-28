package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.OrderEntity;

public interface OrderRepository {

    public List<OrderEntity> getAllOrders();

    public void addOrder();

    public void updateOrder();

}
