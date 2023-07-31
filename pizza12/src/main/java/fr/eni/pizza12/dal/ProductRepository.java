package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.CategoryEntity;
import fr.eni.pizza12.bo.ProductEntity;
import fr.eni.pizza12.bo.ProductTypeEntity;

public interface ProductRepository {

    public List<ProductEntity> getAllProducts();

    public List<ProductEntity> getAllProductsAndCategories();

    public List<ProductEntity> getAllActiveProducts();

    public ProductEntity getProductByName(String name);

    public ProductEntity getProductById(int id);

    public void addProduct(ProductEntity productEntity);

    public void deleteProduct(ProductEntity productEntity);

    public void deleteProductById(int id);

    public void deleteProductByName(String name);

    public void updateProductEntity(ProductEntity productEntity);

    public List<ProductEntity> getAllProductsByCategory(CategoryEntity categoryEntity);

    public List<ProductEntity> getAllProductsByCategory(int categoryId);

    public List<ProductEntity> getAllProductsByCategory(String categoryName);

    public List<ProductEntity> getAllProductsByType(ProductTypeEntity productTypeEntity);

    public List<ProductEntity> getAllProductsByType(int productTypeId);

    public List<ProductEntity> getAllProductsByType(String productTypeName);

}
