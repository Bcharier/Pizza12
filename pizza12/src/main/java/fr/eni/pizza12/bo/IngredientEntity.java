package fr.eni.pizza12.bo;

public class IngredientEntity {

  private int ingredientId;
  private String ingredientName;
  private boolean isAllergenic;
  private boolean isVegan;
  private int ingredientStock;

  public IngredientEntity() {
  }

  public IngredientEntity(int ingredientId, String ingredientName, boolean isAllergenic, boolean isVegan,
      int ingredientStock) {
    this.ingredientId = ingredientId;
    this.ingredientName = ingredientName;
    this.isAllergenic = isAllergenic;
    this.isVegan = isVegan;
    this.ingredientStock = ingredientStock;
  }

  public int getIngredientId() {
    return this.ingredientId;
  }

  public void setIngredientId(int ingredientId) {
    this.ingredientId = ingredientId;
  }

  public String getIngredientName() {
    return this.ingredientName;
  }

  public void setIngredientName(String ingredientName) {
    this.ingredientName = ingredientName;
  }

  public boolean isIsAllergenic() {
    return this.isAllergenic;
  }

  public boolean getIsAllergenic() {
    return this.isAllergenic;
  }

  public void setIsAllergenic(boolean isAllergenic) {
    this.isAllergenic = isAllergenic;
  }

  public boolean isIsVegan() {
    return this.isVegan;
  }

  public boolean getIsVegan() {
    return this.isVegan;
  }

  public void setIsVegan(boolean isVegan) {
    this.isVegan = isVegan;
  }

  public int getIngredientStock() {
    return this.ingredientStock;
  }

  public void setIngredientStock(int ingredientStock) {
    this.ingredientStock = ingredientStock;
  }

}
