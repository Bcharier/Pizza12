package fr.eni.pizza12.bo;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeProperty {

    private int productTypePropertyId;
    private String productTypePropertyName;
    private List<ProductTypePropertyValue> productTypePropertyValueList;

    public ProductTypeProperty() {
    }

    public ProductTypeProperty(int productTypePropertyId, String productTypePropertyName) {
        this.productTypePropertyId = productTypePropertyId;
        this.productTypePropertyName = productTypePropertyName;
        this.productTypePropertyValueList = new ArrayList<>();
    }

    public int getProductTypePropertyId() {
        return this.productTypePropertyId;
    }

    public void setProductTypePropertyId(int productTypePropertyId) {
        this.productTypePropertyId = productTypePropertyId;
    }

    public String getProductTypePropertyName() {
        return this.productTypePropertyName;
    }

    public void setProductTypePropertyName(String productTypePropertyName) {
        this.productTypePropertyName = productTypePropertyName;
    }

    public List<ProductTypePropertyValue> getProductTypePropertyValueList() {
        return this.productTypePropertyValueList;
    }

    public void setProductTypePropertyValueList(List<ProductTypePropertyValue> productTypePropertyValueList) {
        this.productTypePropertyValueList = productTypePropertyValueList;
    }

    @Override
    public String toString() {
        return "{" +
                " productTypePropertyId='" + getProductTypePropertyId() + "'" +
                ", productTypePropertyName='" + getProductTypePropertyName() + "'" +
                "}";
    }

}
