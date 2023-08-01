package fr.eni.pizza12.bo;

public class OrderItemEntity {

  private int orderId;
  private ProductEntity orderItem;
  private int orderItemQuantity;
  private OrderItemsStatus OrderItemsStatus;

  public OrderItemEntity() {
  }

  public OrderItemEntity(int orderId, ProductEntity orderItem, int orderItemQuantity,
      OrderItemsStatus OrderItemsStatus) {
    this.orderId = orderId;
    this.orderItem = orderItem;
    this.orderItemQuantity = orderItemQuantity;
    this.OrderItemsStatus = OrderItemsStatus;
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
    return this.OrderItemsStatus;
  }

  public void setOrderItemsStatus(OrderItemsStatus OrderItemsStatus) {
    this.OrderItemsStatus = OrderItemsStatus;
  }

  @Override
  public String toString() {
    return "{" +
        " orderId='" + getOrderId() + "'" +
        ", orderItemId='" + getOrderItem() + "'" +
        ", orderItemQuantity='" + getOrderItemQuantity() + "'" +
        ", OrderItemsStatus='" + getOrderItemsStatus() + "'" +
        "}";
  }

}
