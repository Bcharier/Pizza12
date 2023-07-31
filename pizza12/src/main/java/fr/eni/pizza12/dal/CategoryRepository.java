package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.CategoryEntity;

public interface CategoryRepository {

  public List<CategoryEntity> getAllCategories();

  public CategoryEntity getCategoryById(int id);

}
