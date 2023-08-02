package fr.eni.pizza12.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderEntity {

    private int orderId;
    private int tableNumber;
    private LocalTime deliveryTime;
    private OrderStates orderState;
    private int accountId;
    private List<OrderItemEntity> orderItems;

    public OrderEntity() {
    }

    public OrderEntity(int orderId, int tableNumber, LocalTime deliveryTime, OrderStates orderState, int accountId,
            List<OrderItemEntity> itemList) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.deliveryTime = deliveryTime;
        this.orderState = orderState;
        this.accountId = accountId;
        this.orderItems = itemList;
    }

    public OrderEntity(int orderId, int tableNumber, LocalTime deliveryTime, OrderStates orderState, int accountId) {
        this(orderId, tableNumber, deliveryTime, orderState, accountId, new ArrayList<>());
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

    public OrderStates getOrderState() {
        return this.orderState;
    }

    public void setOrderState(OrderStates orderState) {
        this.orderState = orderState;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<OrderItemEntity> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

}