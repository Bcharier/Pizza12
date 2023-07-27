package fr.eni.pizza12.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PizzaDAOImpl implements PizzaDAO {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public PizzaDAOImpl(JdbcTemplate jdbcTemplate)  {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  @Override
  public List<PizzaEntity> getAllPizzas() {
    String sql = "SELECT * FROM Pizzas";

    return jdbcTemplate.query(sql, new PizzaRowMapper());
  }

  private static class PizzaRowMapper implements RowMapper<PizzaEntity> {
    @Override
    public PizzaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      PizzaEntity pizzaEntity = new PizzaEntity();
      pizzaEntity.setPizzaId(rs.getInt("pizzaId"));
      pizzaEntity.setPizzaName(rs.getString("pizzaName"));
      return pizzaEntity;
    }
  }

  @Override
  public int insertPizza() {
    return 0;
  }
}
