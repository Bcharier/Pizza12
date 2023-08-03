package fr.eni.pizza12.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.CategoryEntity;
import fr.eni.pizza12.bo.OrderItemEntity;
import fr.eni.pizza12.bo.OrderItemsStatus;
import fr.eni.pizza12.bo.ProductEntity;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public OrderItemRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static class OrderItemRowMapper implements RowMapper<OrderItemEntity> {
    public OrderItemEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      OrderItemEntity orderItemEntity = new OrderItemEntity();
      orderItemEntity.setOrderId(rs.getInt("orderId"));
      orderItemEntity.setOrderItem(new ProductEntity(rs.getInt("productId"), rs.getString("productName"),
          rs.getBigDecimal("productPrice"), rs.getBoolean("isActive"), new CategoryEntity()));
      orderItemEntity.setOrderItemQuantity(rs.getInt("orderItemQuantity"));
      if (Objects.isNull(rs.getString("orderItemStatus"))) {
        orderItemEntity.setOrderItemsStatus(null);
      } else {
        orderItemEntity.setOrderItemsStatus(OrderItemsStatus.valueOf(rs.getString("orderItemStatus")));
      }
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
    String sql = "SELECT * FROM orderItems oI INNER JOIN Products p ON oI.orderItemId = p.productId WHERE orderId = ? ORDER BY p.categoryId";

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
        preparedStatement.setInt(2, orderItemEntity.getOrderItem().getProductId());
        preparedStatement.setInt(3, orderItemEntity.getOrderItemQuantity());
        if (Objects.isNull(orderItemEntity.getOrderItemsStatus())) {
          preparedStatement.setString(4, null);
        } else {
          preparedStatement.setString(4, orderItemEntity.getOrderItemsStatus().name());
        }
      }
    });
  }

  @Override
  public void deleteOrderItem(OrderItemEntity orderItemEntity) {
    String sql = "DELETE FROM orderItems WHERE orderItemId = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, orderItemEntity.getOrderItem().getProductId());
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
        preparedStatement.setInt(2, orderItemEntity.getOrderItem().getProductId());
        preparedStatement.setInt(3, orderItemEntity.getOrderItemQuantity());
        preparedStatement.setString(4, orderItemEntity.getOrderItemsStatus().name());
      }
    });
  }
}
