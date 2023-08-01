package fr.eni.pizza12.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderStates;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static class OrderRowMapper implements RowMapper<OrderEntity> {
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      OrderEntity orderEntity = new OrderEntity();
      orderEntity.setOrderId(rs.getInt("orderId"));
      orderEntity.setTableNumber(rs.getInt("orderTableNum"));
      orderEntity.setAccountId(rs.getInt("orderAccountId"));
      orderEntity.setDeliveryTime(rs.getTime("orderScheduledDeliveryTime").toLocalTime());
      orderEntity.setOrderState(OrderStates.valueOf(rs.getString("orderStatus")));

      return orderEntity;
    }
  }

  @Override
  public List<OrderEntity> getAllOrders() {
    String sql = "SELECT * FROM orders";

    return jdbcTemplate.query(sql, new OrderRowMapper());
  }

  @Override
  public List<OrderEntity> getOrderByAccountId(int accountId) {
    String sql = "SELECT * FROM orders WHERE orderAccountId = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, accountId);
      }
    }, new OrderRowMapper());
  }

  @Override
  public void addOrder(OrderEntity orderEntity) {
    String sql = "INSERT INTO orders (orderId, orderTableNum, orderAccountId, orderScheduledDeliveryTime, orderStatus, orderBillTotal) VALUES (?, ?, ?, ?, ?, ?)";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderEntity.getOrderId());
        preparedStatement.setInt(2, orderEntity.getTableNumber());
        preparedStatement.setInt(3, orderEntity.getAccountId());
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
        preparedStatement.setInt(3, orderEntity.getAccountId());
        preparedStatement.setTime(4, Time.valueOf(orderEntity.getDeliveryTime()));
        preparedStatement.setString(5, orderEntity.getOrderState().name());
        preparedStatement.setInt(6, 0);
      }
    });
  }

  @Override
  public List<OrderEntity> getOrderByTableNumber(int tableNumber) {
    String sql = "SELECT * FROM orders WHERE orderTableNum = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, tableNumber);
      }
    }, new OrderRowMapper());
  }

  @Override
  public List<OrderEntity> getOrderByOrderState(OrderStates orderState) {
    String sql = "SELECT * FROM orders WHERE orderStatus = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, orderState.name());
      }
    }, new OrderRowMapper());
  }

  @Override
  public List<OrderEntity> getOrderByAccountIdAndByOrderState(int accountId, OrderStates orderState) {
    String sql = "SELECT * FROM orders WHERE orderAccountId = ? AND orderStatus = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, accountId);
        preparedStatement.setString(2, orderState.name());
      }
    }, new OrderRowMapper());
  }
}
