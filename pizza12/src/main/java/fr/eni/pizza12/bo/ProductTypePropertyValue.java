package fr.eni.pizza12.bo;

public class ProductTypePropertyValue {

    private int productTypePropertyValueId;
    private String productTypePropertyValueName;

    public ProductTypePropertyValue() {
    }

    public ProductTypePropertyValue(int productTypePropertyValueId, String productTypePropertyValueName) {
        this.productTypePropertyValueId = productTypePropertyValueId;
        this.productTypePropertyValueName = productTypePropertyValueName;
    }

    public int getProductTypePropertyValueId() {
        return this.productTypePropertyValueId;
    }

    public void setProductTypePropertyValueId(int productTypePropertyValueId) {
        this.productTypePropertyValueId = productTypePropertyValueId;
    }

    public String getProductTypePropertyValueName() {
        return this.productTypePropertyValueName;
    }

    public void setProductTypePropertyValueName(String productTypePropertyValueName) {
        this.productTypePropertyValueName = productTypePropertyValueName;
    }

    @Override
    public String toString() {
        return "{" +
                " productTypePropertyValueId='" + getProductTypePropertyValueId() + "'" +
                ", productTypePropertyValueName='" + getProductTypePropertyValueName() + "'" +
                "}";
    }

}
