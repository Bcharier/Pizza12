package fr.eni.pizza12.bo;

public class OrderItemEntity {

    private int orderItemQuantity;
    private OrderPreparationState orderPreparationState;

    enum OrderPreparationState {
        ANNULEE,
        COMMANDEE,
        PREPAREE,
        EN_COURS,
        PRETE,
        LIVREE
    }

    public OrderItemEntity() {
    }

    public OrderItemEntity(int orderItemQuantity, OrderPreparationState orderPreparationState) {
        this.orderItemQuantity = orderItemQuantity;
        this.orderPreparationState = orderPreparationState;
    }

    public int getOrderItemQuantity() {
        return this.orderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public OrderPreparationState getOrderPreparationState() {
        return this.orderPreparationState;
    }

    public void setOrderPreparationState(OrderPreparationState orderPreparationState) {
        this.orderPreparationState = orderPreparationState;
    }

}
