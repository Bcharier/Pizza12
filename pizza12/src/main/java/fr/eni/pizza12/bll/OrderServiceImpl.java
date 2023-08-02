package fr.eni.pizza12.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.dal.OrderItemRepository;
import fr.eni.pizza12.dal.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  OrderItemRepository orderItemRepository;

  public List<OrderEntity> getAllPendingOrdersAndAssociatedOrderItems() {
    List<OrderEntity> orderList = orderRepository.getAllPendingOrders();

    for (OrderEntity orderEntity : orderList) {
      orderEntity.setOrderItems(orderItemRepository.getOrderItemByOrderId(orderEntity.getOrderId()));
    }

    return orderList;
  }

}
