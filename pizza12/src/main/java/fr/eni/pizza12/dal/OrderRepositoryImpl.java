package fr.eni.pizza12.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.OrderEntity;
import fr.eni.pizza12.bo.OrderStates;

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
    public void addOrder() {
        String sql = "INSERT INTO orders (orderId, orderTableNum, orderAccountId, orderScheduledDeliveryTime, orderStatus, orderBillTotal) VALUES (?, ?, ?, ?, ?, ?)";

    }

    @Override
    public void updateOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

}
