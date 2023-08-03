package fr.eni.pizza12.controller;

public class DTOListOrders {

    private int orderId;
    private int orderItemCategory;

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderItemCategory() {
        return this.orderItemCategory;
    }

    public void setOrderItemCategory(int orderItemCategory) {
        this.orderItemCategory = orderItemCategory;
    }

    @Override
    public String toString() {
        return "{" +
                " orderId='" + getOrderId() + "'" +
                ", orderItemCategory='" + getOrderItemCategory() + "'" +
                "}";
    }

}
