package fr.eni.pizza12.bo;

public class OrderItemEntity {

  private int orderId;
  private ProductEntity orderItem;
  private int orderItemQuantity;
  private OrderItemsStatus orderItemsStatus;

  public OrderItemEntity() {
  }

  public OrderItemEntity(int orderId, ProductEntity orderItem, int orderItemQuantity,
      OrderItemsStatus orderItemsStatus) {
    this.orderId = orderId;
    this.orderItem = orderItem;
    this.orderItemQuantity = orderItemQuantity;
    this.orderItemsStatus = orderItemsStatus;
  }

  public int getOrderId() {
    return this.orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public ProductEntity getOrderItem() {
    return this.orderItem;
  }

  public void setOrderItem(ProductEntity orderItem) {
    this.orderItem = orderItem;
  }

  public int getOrderItemQuantity() {
    return this.orderItemQuantity;
  }

  public void setOrderItemQuantity(int orderItemQuantity) {
    this.orderItemQuantity = orderItemQuantity;
  }

  public OrderItemsStatus getOrderItemsStatus() {
    return this.orderItemsStatus;
  }

  public void setOrderItemsStatus(OrderItemsStatus orderItemsStatus) {
    this.orderItemsStatus = orderItemsStatus;
  }

  @Override
  public String toString() {
    return "{" +
        " orderId='" + getOrderId() + "'" +
        ", orderItemId='" + getOrderItem() + "'" +
        ", orderItemQuantity='" + getOrderItemQuantity() + "'" +
        ", orderItemsStatus='" + getOrderItemsStatus() + "'" +
        "}";
  }

}
