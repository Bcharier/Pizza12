package fr.eni.pizza12.bo;

public class CategoryEntity {

    private int categoryId;
    private String categoryName;
    private int categoryOrder;

    public CategoryEntity() {
    }

    public CategoryEntity(int categoryId, String categoryName, int categoryOrder) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryOrder = categoryOrder;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryOrder() {
        return this.categoryOrder;
    }

    public void setCategoryOrder(int categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    @Override
    public String toString() {
        return "{" +
                " categoryId='" + getCategoryId() + "'" +
                ", categoryName='" + getCategoryName() + "'" +
                "}";
    }
}
