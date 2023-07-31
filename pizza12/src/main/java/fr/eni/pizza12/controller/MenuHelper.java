package fr.eni.pizza12.controller;

import java.util.List;

import fr.eni.pizza12.bo.ProductEntity;

public class MenuHelper {

  public boolean checkIfDisplayCategoryName(List<ProductEntity> list, int currentIndex) {
    boolean result = false;
    if (currentIndex <= 0) {
      return true;
    }

    if (list != null && !list.isEmpty()) {
      if (list.get(currentIndex - 1).getCategory().getCategoryId() != list.get(currentIndex).getCategory()
          .getCategoryId()) {
        result = true;
      }
    }

    return result;
  }

}
