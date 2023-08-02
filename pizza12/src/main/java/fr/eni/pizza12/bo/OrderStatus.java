package fr.eni.pizza12.bo;

public enum OrderStatus {
  ANNULEE("Annulée"),
  EN_ATTENTE("En attente"),
  A_PREPARER("A préparer"),
  PAYEE("Payée"),
  LIVREE("Livrée");

  private final String name;

  private OrderStatus(String s) {
    name = s;
  }

  public boolean equalsName(String otherName) {
    // (otherName == null) check is not needed because name.equals(null) returns
    // false
    return name.equals(otherName);
  }

  public String toString() {
    return this.name;
  }

}