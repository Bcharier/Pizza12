package fr.eni.pizza12.controller;

public class DTO {

    private int accountId;
    private int productId;

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

    @Override
    public String toString() {
        return "{" +
                " accountId='" + getAccountId() + "'" +
                ", productId='" + getProductId() + "'" +
                "}";
    }

}
