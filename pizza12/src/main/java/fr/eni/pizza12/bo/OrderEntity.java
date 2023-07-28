package fr.eni.pizza12.bo;

import java.time.LocalTime;

public class OrderEntity {

    private int orderId;
    private int tableNumber;
    private LocalTime deliveryTime;
    private OrderStates orderState;
    private AccountEntity accountEntity;

    enum OrderStates {
        EN_ATTENTE,
        PAYEE,
        LIVREE
    }

    public OrderEntity() {
    }

    public OrderEntity(int orderId, int tableNumber, LocalTime deliveryTime, OrderStates orderState,
            AccountEntity accountEntity) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.deliveryTime = deliveryTime;
        this.orderState = orderState;
        this.accountEntity = accountEntity;
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

    public AccountEntity getAccountEntity() {
        return this.accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public OrderStates[] getAllOrderStates() {
        return OrderStates.values();
    }
}
