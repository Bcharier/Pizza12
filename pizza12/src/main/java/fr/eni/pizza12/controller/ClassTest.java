package fr.eni.pizza12.controller;

import java.util.List;

import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;

public class ClassTest {

    private int orderId;
    private int orderItemId;
    private List<OrderItemEntity> listOrderitems;

    public ClassTest() {
    }

    public ClassTest(int orderId, int orderItemId) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderItemId() {
        return this.orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

}
