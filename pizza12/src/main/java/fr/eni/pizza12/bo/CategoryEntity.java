package fr.eni.pizza12.bo;

public class CategoryEntity {

    private int categoryId;
    private String categoryName;

    public CategoryEntity() {
    }

    public CategoryEntity(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return "{" +
                " categoryId='" + getCategoryId() + "'" +
                ", categoryName='" + getCategoryName() + "'" +
                "}";
    }

}
