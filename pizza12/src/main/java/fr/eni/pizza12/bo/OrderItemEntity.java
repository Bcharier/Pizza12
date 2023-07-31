package fr.eni.pizza12.bo;

public class OrderItemEntity {

    private int orderId;
    private int orderItemId;
    private int orderItemQuantity;
    private OrderItemsStatus orderItemsStatus;

    public OrderItemEntity() {
    }

    public OrderItemEntity(int orderId, int orderItemId, int orderItemQuantity, OrderItemsStatus orderItemsStatus) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.orderItemQuantity = orderItemQuantity;
        this.orderItemsStatus = orderItemsStatus;
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
        return this.orderItemsStatus;
    }

    public void setOrderItemsStatus(OrderItemsStatus orderItemsStatus) {
        this.orderItemsStatus = orderItemsStatus;
    }

    @Override
    public String toString() {
        return "{" +
                " orderId='" + getOrderId() + "'" +
                ", orderItemId='" + getOrderItemId() + "'" +
                ", orderItemQuantity='" + getOrderItemQuantity() + "'" +
                ", orderItemsStatus='" + getOrderItemsStatus() + "'" +
                "}";
    }

}
