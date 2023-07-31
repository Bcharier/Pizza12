package fr.eni.pizza12.bo;

public class InvoiceEntity {

    private int invoiceTotalPrice;

    public InvoiceEntity() {
    }

    public InvoiceEntity(int invoiceTotalPrice) {
        this.invoiceTotalPrice = invoiceTotalPrice;
    }

    public int getInvoiceTotalPrice() {
        return this.invoiceTotalPrice;
    }

    public void setInvoiceTotalPrice(int invoiceTotalPrice) {
        this.invoiceTotalPrice = invoiceTotalPrice;
    }

}
