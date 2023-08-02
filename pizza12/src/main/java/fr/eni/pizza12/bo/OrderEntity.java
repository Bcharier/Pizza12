package fr.eni.pizza12.bo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderEntity {

  private int orderId;
  private int tableNumber;
  private LocalTime deliveryTime;
  private OrderStatus orderState;
  private AccountEntity account;
  private List<OrderItemEntity> orderItems;

  public OrderEntity() {
  }

  public OrderEntity(int orderId, int tableNumber, LocalTime deliveryTime, OrderStatus orderState,
      AccountEntity account,
      ArrayList<OrderItemEntity> itemList) {
    this.orderId = orderId;
    this.tableNumber = tableNumber;
    this.deliveryTime = deliveryTime;
    this.orderState = orderState;
    this.account = account;
    this.orderItems = itemList;
  }

  public OrderEntity(int orderId, int tableNumber, LocalTime deliveryTime, OrderStatus orderState,
      AccountEntity account) {
    this(orderId, tableNumber, deliveryTime, orderState, account, new ArrayList<OrderItemEntity>());
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

  public String getOrderStateName() {
    return this.orderState.name();
  }

  public void setOrderState(OrderStatus orderState) {
    this.orderState = orderState;
  }

  public AccountEntity getAccount() {
    return this.account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public List<OrderItemEntity> getOrderItems() {
    return this.orderItems;
  }

  public void setOrderItems(List<OrderItemEntity> orderItems) {
    this.orderItems = orderItems;
  }

}
