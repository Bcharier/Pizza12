package fr.eni.pizza12.bo;

import java.util.ArrayList;
import java.util.List;

public class ProductType {

    private int productTypeId;
    private String productTypeName;
    private List<ProductTypeProperty> productTypePropertyList;

    public ProductType() {
    }

    public ProductType(int productTypeId, String productTypeName) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.productTypePropertyList = new ArrayList<>();
    }

    public int getProductTypeId() {
        return this.productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return this.productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public List<ProductTypeProperty> getProductTypePropertyList() {
        return this.productTypePropertyList;
    }

    public void setProductTypePropertyList(List<ProductTypeProperty> productTypePropertyList) {
        this.productTypePropertyList = productTypePropertyList;
    }

    @Override
    public String toString() {
        return "{" +
                " productTypeId='" + getProductTypeId() + "'" +
                ", productTypeName='" + getProductTypeName() + "'" +
                "}";
    }

}
