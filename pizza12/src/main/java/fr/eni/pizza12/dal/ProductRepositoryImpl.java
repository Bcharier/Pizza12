package fr.eni.pizza12.dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.pizza12.bo.CategoryEntity;
import fr.eni.pizza12.bo.ProductEntity;
import fr.eni.pizza12.bo.ProductTypeEntity;

public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static CategoryRepositoryImpl categoryRepositoryImpl;
    private static final String SQL_CATEGORY = "SELECT * FROM Products Where categoryId = ?";
    private static final String SQL_PROPERTY_TYPE = "SELECT * FROM Products Where productTypeId = ?";

    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        categoryRepositoryImpl = new CategoryRepositoryImpl(jdbcTemplate);
    }

    private static class ProductRowMapper implements RowMapper<ProductEntity> {

        public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductId(rs.getInt("productId"));
            productEntity.setProductName(rs.getString("productName"));
            productEntity.setProductPrice(rs.getInt("productPrice"));
            productEntity.setProductActive(rs.getBoolean("isActive"));
            productEntity.setCategory(categoryRepositoryImpl.getCategoryById(rs.getInt("categoryId")));
            return productEntity;
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        String sql = "SELECT * FROM Products";

        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public List<ProductEntity> getAllProductsAndCategories() {
        String sql = "SELECT * FROM Products p INNER JOIN Categories c ON p.categoryId = c.categoryId ORDER BY c.categoryOrder";

        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public List<ProductEntity> getAllActiveProducts() {
        String sql = "SELECT * FROM Products WHERE isActive = TRUE";

        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public ProductEntity getProductByName(String name) {
        String sql = "SELECT * FROM Products Where productName LIKE %?%";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, name);
            }
        }, new ProductRowMapper()).get(0);
    }

    @Override
    public ProductEntity getProductById(int id) {
        String sql = "SELECT * FROM Products Where productID = ?";

        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, id);
            }
        }, new ProductRowMapper()).get(0);
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        String sql = "INSERT INTO Products (productId, productName, productPrice, isActive, categoryId, productTypeId) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, productEntity.getProductId());
                preparedStatement.setString(2, productEntity.getProductName());
                preparedStatement.setInt(3, productEntity.getProductPrice());
                preparedStatement.setBoolean(4, productEntity.isProductActive());
                preparedStatement.setInt(5, productEntity.getCategory().getCategoryId());
                preparedStatement.setInt(6, productEntity.getProductType().getProductTypeId());
            }
        });
    }

    @Override
    public void deleteProduct(ProductEntity productEntity) {
        String sql = "DELETE FROM Products WHERE productId = ?";

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, productEntity.getProductId());
            }
        });
    }

    @Override
    public void deleteProductById(int id) {
        String sql = "DELETE FROM Products WHERE productId = ?";

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, id);
            }
        });
    }

    @Override
    public void deleteProductByName(String name) {
        String sql = "DELETE FROM Products WHERE productName = ?";

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, name);
            }
        });
    }

    @Override
    public void updateProductEntity(ProductEntity productEntity) {
        String sql = "UPDATE Products SET productId = ?, productName = ?, productPrice = ?, isActive = ?, categoryId = ?, productTypeId = ?";

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, productEntity.getProductId());
                preparedStatement.setString(2, productEntity.getProductName());
                preparedStatement.setInt(3, productEntity.getProductPrice());
                preparedStatement.setBoolean(4, productEntity.getProductActive());
                preparedStatement.setInt(5, productEntity.getCategory().getCategoryId());
                preparedStatement.setInt(6, productEntity.getProductType().getProductTypeId());
            }
        });
    }

    @Override
    public List<ProductEntity> getAllProductsByCategory(CategoryEntity categoryEntity) {
        return jdbcTemplate.query(SQL_CATEGORY, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, categoryEntity.getCategoryId());
            }
        }, new ProductRowMapper());
    }

    @Override
    public List<ProductEntity> getAllProductsByCategory(int categoryId) {
        return jdbcTemplate.query(SQL_CATEGORY, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, categoryId);
            }
        }, new ProductRowMapper());
    }

    @Override
    public List<ProductEntity> getAllProductsByCategory(String categoryName) {
        return jdbcTemplate.query(SQL_CATEGORY, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, categoryName);
            }
        }, new ProductRowMapper());
    }

    @Override
    public List<ProductEntity> getAllProductsByType(ProductTypeEntity productTypeEntity) {
        return jdbcTemplate.query(SQL_PROPERTY_TYPE, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, productTypeEntity.getProductTypeId());
            }
        }, new ProductRowMapper());
    }

    @Override
    public List<ProductEntity> getAllProductsByType(int productTypeId) {
        return jdbcTemplate.query(SQL_PROPERTY_TYPE, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, productTypeId);
            }
        }, new ProductRowMapper());
    }

    @Override
    public List<ProductEntity> getAllProductsByType(String productTypeName) {
        return jdbcTemplate.query(SQL_PROPERTY_TYPE, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, productTypeName);
            }
        }, new ProductRowMapper());
    }

}
