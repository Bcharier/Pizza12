package fr.eni.pizza12.bo;

public enum OrderItemsStatus {
  ANNULEE("Annulée"),
  COMMANDEE("Commandée"),
  EN_PREPARATION("En préparation"),
  PREPAREE("Préparée"),
  CUISSON("En cours de cuisson"),
  PRETE("Prête"),
  LIVREE("Livrée");

  private final String name;
  private static final OrderItemsStatus[] states = values();

  private OrderItemsStatus(String s) {
    name = s;
  }

  public boolean equalsName(String otherName) {

    return name.equals(otherName);
  }

  public String toString() {
    return this.name;
  }

  public OrderItemsStatus next() {
    return states[(this.ordinal() + 1) % states.length];
  }
}
