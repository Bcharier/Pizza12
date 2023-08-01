package fr.eni.pizza12.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderItemsStatus;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public OrderItemRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  private static class OrderItemRowMapper implements RowMapper<OrderItemEntity> {
    public OrderItemEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      OrderItemEntity orderItemEntity = new OrderItemEntity();
      orderItemEntity.setOrderId(rs.getInt("orderId"));
      orderItemEntity.setOrderItemId(rs.getInt("orderItemId"));
      orderItemEntity.setOrderItemQuantity(rs.getInt("orderItemQuantity"));
      orderItemEntity.setOrderItemsStatus(OrderItemsStatus.valueOf(rs.getString("orderItemStatus")));
      return orderItemEntity;
    }
  }

  @Override
  public List<OrderItemEntity> getAllOrderItems() {
    String sql = "SELECT * FROM orderItems";

    return jdbcTemplate.query(sql, new OrderItemRowMapper());
  }

  @Override
  public List<OrderItemEntity> getOrderItemByOrderId(int id) {
    String sql = "SELECT * FROM orderItems WHERE orderId = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    }, new OrderItemRowMapper());
  }

  @Override
  public void addOrderItem(OrderItemEntity orderItemEntity) {
    String sql = "INSERT INTO orderItems(orderId, orderItemId, orderItemQuantity, orderItemStatus) VALUES(?, ?, ?, ?)";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderItemEntity.getOrderId());
        preparedStatement.setInt(2, orderItemEntity.getOrderItemId());
        preparedStatement.setInt(3, orderItemEntity.getOrderItemQuantity());
        preparedStatement.setString(4, orderItemEntity.getOrderItemsStatus().name());
      }
    });
  }

  @Override
  public void deleteOrderItem(OrderItemEntity orderItemEntity) {
    String sql = "DELETE FROM orderItems WHERE orderItemId = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderItemEntity.getOrderItemId());
      }
    });
  }

  @Override
  public void deleteAllOrderItemsInOrder(OrderItemEntity orderItemEntity) {
    String sql = "DELETE FROM orderItems WHERE orderId = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderItemEntity.getOrderId());
      }
    });
  }

  @Override
  public void updateOrderItem(OrderItemEntity orderItemEntity) {
    String sql = "UPDATE orderItems SET orderId = ?, orderItemId = ?, orderItemQuantity = ?, orderItemStatus = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderItemEntity.getOrderId());
        preparedStatement.setInt(2, orderItemEntity.getOrderItemId());
        preparedStatement.setInt(3, orderItemEntity.getOrderItemQuantity());
        preparedStatement.setString(4, orderItemEntity.getOrderItemsStatus().name());
      }
    });
  }

  public List<OrderItemEntity> getAllPendingOrdersItems() {
    StringBuilder sql = new StringBuilder();
    sql.append(" SELECT *");
    sql.append(" FROM orderItems oI");
    sql.append(" INNER JOIN orders o");
    sql.append(" ON oI.orderId = o.orderId");
    sql.append(" WHERE TIMEDIFF(o.orderScheduledDeliveryTime, NOW()) <= '12:00:00'");
    sql.append(" AND orderStatus <> 'LIVREE'");
    sql.append(" ORDER BY o.orderId");
    sql.append(";");

    return jdbcTemplate.query(sql.toString(), new OrderItemRowMapper());
  }
}
