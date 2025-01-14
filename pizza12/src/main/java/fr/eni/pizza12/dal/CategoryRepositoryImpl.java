package fr.eni.pizza12.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.CategoryEntity;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public CategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static class CategoryRowMapper implements RowMapper<CategoryEntity> {
    public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      CategoryEntity categoryEntity = new CategoryEntity();
      categoryEntity.setCategoryId(rs.getInt("categoryId"));
      categoryEntity.setCategoryName(rs.getString("categoryName"));
      categoryEntity.setCategoryOrder(rs.getInt("categoryOrder"));
      return categoryEntity;
    }
  }

  @Override
  public List<CategoryEntity> getAllCategories() {
    String sql = "SELECT * FROM categories";

    return jdbcTemplate.query(sql, new CategoryRowMapper());
  }

  @Override
  public CategoryEntity getCategoryById(int id) {
    String sql = "SELECT * FROM Categories WHERE categoryId = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }

    }, new CategoryRowMapper()).get(0);
  }

}
