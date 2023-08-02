package fr.eni.pizza12.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderStatus;
import fr.eni.pizza12.utils.Constants;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  private static class OrderRowMapper implements RowMapper<OrderEntity> {
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

      OrderEntity orderEntity = new OrderEntity();
      orderEntity.setOrderId(rs.getInt("orderId"));
      orderEntity.setTableNumber(rs.getInt("orderTableNum"));
      orderEntity.setAccount(new AccountEntity(
          rs.getInt("orderAccountId"), rs.getString("accountLastName"), rs.getString("accountFirstName"),
          rs.getDate("accountDateOfBirth").toLocalDate(), rs.getDate("accountCreationDate").toLocalDate(),
          rs.getString("accountMail"),
          rs.getString("accountPhone")));
      orderEntity.setDeliveryTime(rs.getTime("orderScheduledDeliveryTime").toLocalTime());
      orderEntity.setOrderState(OrderStatus.valueOf(rs.getString("orderStatus")));

      return orderEntity;
    }
  }

  @Override
  public List<OrderEntity> getAllOrders() {
    String sql = "SELECT * FROM orders";

    return jdbcTemplate.query(sql, new OrderRowMapper());
  }

  @Override
  public void addOrder(OrderEntity orderEntity) {
    String sql = "INSERT INTO orders (orderId, orderTableNum, orderAccountId, orderScheduledDeliveryTime, orderStatus, orderBillTotal) VALUES (?, ?, ?, ?, ?, ?)";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderEntity.getOrderId());
        preparedStatement.setInt(2, orderEntity.getTableNumber());
        preparedStatement.setInt(3, orderEntity.getAccount().getAccountId());
        preparedStatement.setTime(4, Time.valueOf(orderEntity.getDeliveryTime()));
        preparedStatement.setString(5, orderEntity.getOrderState().name());
        preparedStatement.setInt(6, 0);
      }
    });
  }

  @Override
  public void updateOrder(OrderEntity orderEntity) {
    String sql = "Update Orders SET orderId = ?, orderTableNum = ?, orderAccountId = ?, orderScheduleDeliveryTime = ?, orderStatus = ?, orderBillTotal = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderEntity.getOrderId());
        preparedStatement.setInt(2, orderEntity.getTableNumber());
        preparedStatement.setInt(3, orderEntity.getAccount().getAccountId());
        preparedStatement.setTime(4, Time.valueOf(orderEntity.getDeliveryTime()));
        preparedStatement.setString(5, orderEntity.getOrderState().name());
        preparedStatement.setInt(6, 0);
      }
    });
  }

  public List<OrderEntity> getAllPendingOrders() {
    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT *");
    sql.append(" FROM orders o");
    sql.append(" INNER JOIN Accounts a ON o.orderAccountId = a.accountId");
    sql.append(" WHERE orderStatus = 'A_PREPARER'");
    sql.append(" ORDER BY orderId");
    sql.append(";");

    return jdbcTemplate.query(sql.toString(), new OrderRowMapper());
  }
}
