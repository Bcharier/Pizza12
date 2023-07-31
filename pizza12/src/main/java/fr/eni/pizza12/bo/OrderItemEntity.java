package fr.eni.pizza12.bo;

public class OrderItemEntity {

    private int orderId;
    private int orderItemId;
    private int orderItemQuantity;
    private OrderItemsStatus OrderItemsStatus;

    public OrderItemEntity() {
    }

    public OrderItemEntity(int orderId, int orderItemId, int orderItemQuantity, OrderItemsStatus OrderItemsStatus) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.orderItemQuantity = orderItemQuantity;
        this.OrderItemsStatus = OrderItemsStatus;
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
                ", orderItemId='" + getOrderItemId() + "'" +
                ", orderItemQuantity='" + getOrderItemQuantity() + "'" +
                ", OrderItemsStatus='" + getOrderItemsStatus() + "'" +
                "}";
    }

}
