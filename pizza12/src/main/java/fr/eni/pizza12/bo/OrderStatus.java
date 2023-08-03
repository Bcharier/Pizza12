package fr.eni.pizza12.bo;

public enum OrderStatus {
  ANNULEE("Annulée"),
  EN_ATTENTE("En attente"),
  A_PREPARER("A préparer"),
  PAYEE("Payée"),
  LIVREE("Livrée");

  private final String name;
  private static final OrderStatus[] states = values();

  private OrderStatus(String s) {
    name = s;
  }

  public boolean equalsName(String otherName) {

    return name.equals(otherName);
  }

  public String toString() {
    return this.name;
  }

  public OrderStatus next() {
    return states[(this.ordinal() + 1) % states.length];
  }
}