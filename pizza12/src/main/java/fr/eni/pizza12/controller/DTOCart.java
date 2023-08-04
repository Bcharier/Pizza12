package fr.eni.pizza12.controller;

public class DTOCart {

    private int accountId;
    private int productId;
    private int orderId;

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "{" +
                " accountId='" + getAccountId() + "'" +
                ", productId='" + getProductId() + "'" +
                ", orderId='" + getOrderId() + "'" +
                "}";
    }

}
