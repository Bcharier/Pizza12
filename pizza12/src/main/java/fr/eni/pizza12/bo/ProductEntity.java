package fr.eni.pizza12.bo;

import java.util.ArrayList;
import java.util.List;

public class ProductEntity {

    private int productId;
    private String productName;
    private int productPrice;
    private boolean productActive;
    private CategoryEntity category;
    private ProductTypeEntity productType;

    public ProductEntity() {
    }

    public ProductEntity(int productId, String productName, int productPrice, boolean productActive,
            CategoryEntity category, ProductTypeEntity productType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productActive = productActive;
        this.category = category;
        this.productType = productType;
        List<IngredientEntity> ingredientList = new ArrayList<>();
    }

    public ProductEntity(int productId, String productName, int productPrice, boolean productActive,
            CategoryEntity category) {
        this(productId, productName, productPrice, productActive, category, null);
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isProductActive() {
        return this.productActive;
    }

    public boolean getProductActive() {
        return this.productActive;
    }

    public void setProductActive(boolean productActive) {
        this.productActive = productActive;
    }

    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public ProductTypeEntity getProductType() {
        return this.productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "{" +
                " productId='" + getProductId() + "'" +
                ", productName='" + getProductName() + "'" +
                ", productPrice='" + getProductPrice() + "'" +
                ", productActive='" + isProductActive() + "'" +
                ", category='" + getCategory() + "'" +
                ", productType='" + getProductType() + "'" +
                "}";
    }

}
