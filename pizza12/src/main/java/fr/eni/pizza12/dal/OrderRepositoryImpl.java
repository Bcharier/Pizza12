package fr.eni.pizza12.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderStatus;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static class OrderRowMapper implements RowMapper<OrderEntity> {
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      OrderEntity orderEntity = new OrderEntity();
      orderEntity.setOrderId(rs.getInt("orderId"));
      orderEntity.setTableNumber(rs.getInt("orderTableNum"));
      orderEntity.setAccount(new AccountEntity(
          rs.getInt("orderAccountId"), rs.getString("accountLastName"), rs.getString("accountFirstName"),
          rs.getDate("accountDateOfBirth").toLocalDate(), rs.getDate("accountCreationDate").toLocalDate(),
          rs.getString("accountMail"),
          rs.getString("accountPhone")));
      if (Objects.isNull(rs.getTime("orderScheduledDeliveryTime"))) {
        orderEntity.setDeliveryTime(null);
      } else {
        orderEntity.setDeliveryTime(rs.getTimestamp("orderScheduledDeliveryTime").toLocalDateTime());
      }
      orderEntity.setOrderState(OrderStatus.valueOf(rs.getString("orderStatus")));

      return orderEntity;
    }
  }

  @Override
  public List<OrderEntity> getAllOrders() {
    String sql = "SELECT * FROM orders o INNER JOIN Accounts a ON o.orderAccountId = a.accountId";

    return jdbcTemplate.query(sql, new OrderRowMapper());
  }

  @Override
  public List<OrderEntity> getOrderByAccountId(int accountId) {
    String sql = "SELECT * FROM orders o INNER JOIN Accounts a ON o.orderAccountId = a.accountId WHERE orderAccountId = ?";

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
        preparedStatement.setInt(3, orderEntity.getAccount().getAccountId());
        if (Objects.isNull(orderEntity.getDeliveryTime())) {
          preparedStatement.setString(4, null);
        } else {
          preparedStatement.setString(4, orderEntity.getDeliveryTime().toString());
        }
        preparedStatement.setString(5, orderEntity.getOrderState().name());
        preparedStatement.setInt(6, 0);
      }
    });
  }

  @Override
  public void updateOrder(OrderEntity orderEntity) {
    String sql = "Update Orders SET orderTableNum = ?, orderAccountId = ?, orderScheduledDeliveryTime = ?, orderStatus = ?, orderBillTotal = ? WHERE orderId = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderEntity.getTableNumber());
        preparedStatement.setInt(2, orderEntity.getAccount().getAccountId());
        if (Objects.isNull(orderEntity.getDeliveryTime())) {
          preparedStatement.setTime(3, null);
        } else {
          preparedStatement.setString(3, orderEntity.getDeliveryTime().toString());
        }
        preparedStatement.setString(4, orderEntity.getOrderState().name());
        preparedStatement.setInt(5, 0);
        preparedStatement.setInt(6, orderEntity.getOrderId());

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
  public List<OrderEntity> getOrderByOrderState(OrderStatus orderState) {
    String sql = "SELECT * FROM orders WHERE orderStatus = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, orderState.name());
      }
    }, new OrderRowMapper());
  }

  @Override
  public List<OrderEntity> getOrderByAccountIdAndByOrderState(int accountId, OrderStatus orderState) {
    String sql = "SELECT * FROM orders o INNER JOIN Accounts a ON o.orderAccountId = a.accountId INNER JOIN orderItems oI ON o.orderId = oi.orderId INNER JOIN products p ON oi.orderItemId = p.productId WHERE orderAccountId = ? AND orderStatus = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, accountId);
        preparedStatement.setString(2, orderState.name());
      }
    }, new OrderRowMapper());
  }

  public List<OrderEntity> getAllPendingOrders() {
    StringBuffer sql = new StringBuffer();
    sql.append(" SELECT *");
    sql.append(" FROM orders o");
    sql.append(" INNER JOIN Accounts a ON o.orderAccountId = a.accountId");
    sql.append(" WHERE orderStatus = 'A_PREPARER'");
    sql.append(" ORDER BY orderScheduledDeliveryTime;");
    sql.append(";");

    return jdbcTemplate.query(sql.toString(), new OrderRowMapper());
  }

  @Override
  public OrderEntity getOrderByOrderId(int orderId) {
    String sql = "SELECT * FROM orders o INNER JOIN accounts a ON o.orderAccountId = a.accountId WHERE orderId = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderId);
      }
    }, new OrderRowMapper()).get(0);
  }
}
