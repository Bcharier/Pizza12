package fr.eni.pizza12.bo;

public enum OrderStates {
    ANNULEE("Annulée"),
    EN_ATTENTE("En attente"),
    A_PREPARER("A préparer"),
    PAYEE("Payée"),
    LIVREE("Livrée");

    private final String name;

    private OrderStates(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {

        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
