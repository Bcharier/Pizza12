package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderItemsStatus;
import fr.eni.pizza12.bo.OrderStatus;

public interface OrderItemRepository {

  public List<OrderItemEntity> getAllOrderItems();

  public List<OrderItemEntity> getOrderItemByOrderId(int id);

  public void addOrderItem(OrderItemEntity orderItemEntity);

  public void deleteOrderItem(OrderItemEntity orderItemEntity);

  public void deleteAllOrderItemsInOrder(OrderItemEntity orderItemEntity);

  public void updateOrderItem(OrderItemEntity orderItemEntity);

  public void updateOrderItemByOrderIdAndOrderItemCategory(int orderItemId, int orderItemCategory,
      OrderItemsStatus orderItemStatus);
}
