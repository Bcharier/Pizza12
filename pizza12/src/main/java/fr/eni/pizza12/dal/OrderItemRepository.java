package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.OrderItemEntity;

public interface OrderItemRepository {

    public List<OrderItemEntity> getAllOrderItems();

    public List<OrderItemEntity> getOrderItemByOrderId(int id);

    public void addOrderItem(OrderItemEntity orderItemEntity);

    public void deleteOrderItem(OrderItemEntity orderItemEntity);

    public void deleteAllOrderItemsInOrder(OrderItemEntity orderItemEntity);

    public void updateOrderItem(OrderItemEntity orderItemEntity);

}
