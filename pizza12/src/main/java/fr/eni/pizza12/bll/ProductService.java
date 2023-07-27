package fr.eni.pizza12.bll;

import java.util.List;

import fr.eni.pizza12.bo.CategoryEntity;
import fr.eni.pizza12.bo.ProductEntity;
import fr.eni.pizza12.bo.ProductTypeEntity;

public interface ProductService {

    public List<ProductEntity> getAllProducts();

    public List<ProductEntity> getAllActiveProducts();

    public ProductEntity getProductByName();

    public ProductEntity getProductById(int id);

    public void addProduct(ProductEntity productEntity);

    public void deleteProduct(ProductEntity productEntity);

    public ProductEntity updateProductEntity(ProductEntity productEntity);

    public List<ProductEntity> getAllProductsByCategory(CategoryEntity categoryEntity);

    public List<ProductEntity> getAllProductsByCategory(int categoryId);

    public List<ProductEntity> getAllProductsByType(ProductTypeEntity productTypeEntity);

    public List<ProductEntity> getAllProductsByType(int productTypeId);

}
