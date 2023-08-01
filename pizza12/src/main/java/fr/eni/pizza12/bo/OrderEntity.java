package fr.eni.pizza12.bo;

import java.time.LocalTime;

public class OrderEntity {

    private int orderId;
    private int tableNumber;
    private LocalTime deliveryTime;
    private OrderStatus orderState;
    private int accountId;

    public OrderEntity() {
    }

    public OrderEntity(int orderId, int tableNumber, LocalTime deliveryTime, OrderStatus orderState, int accountId) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.deliveryTime = deliveryTime;
        this.orderState = orderState;
        this.accountId = accountId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public LocalTime getDeliveryTime() {
        return this.deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public OrderStatus getOrderState() {
        return this.orderState;
    }

    public void setOrderState(OrderStatus orderState) {
        this.orderState = orderState;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
