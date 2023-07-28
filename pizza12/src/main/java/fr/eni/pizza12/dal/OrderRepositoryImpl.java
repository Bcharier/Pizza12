package fr.eni.pizza12.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.pizza12.bo.OrderEntity;

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
            // orderEntity.setAccountEntity(rs.getInt("orderAccountId"));
            return orderEntity;
        }
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOrders'");
    }

    @Override
    public void addOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOrder'");
    }

    @Override
    public void updateOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

}
