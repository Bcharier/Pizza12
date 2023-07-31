package fr.eni.pizza12.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.pizza12.bo.AccountEntity;
import fr.eni.pizza12.bo.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  private static class EmployeeRowMapper implements RowMapper<EmployeeEntity> {
    public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      EmployeeEntity employeeEntity = new EmployeeEntity();
      employeeEntity.setHiringDate(rs.getDate("employeeHiringDate").toLocalDate());
      employeeEntity.setoccupation(rs.getString("employeeOccupation"));

      return employeeEntity;
    }
  }

  @Override
  public List<EmployeeEntity> getAllEmployees() {
    String sql = "SELECT * From employees";

    return jdbcTemplate.query(sql, new EmployeeRowMapper());
  }

  @Override
  public List<EmployeeEntity> getEmployeeById(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEmployeeById'");
  }

  @Override
  public List<EmployeeEntity> getEmployeeByName(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEmployeeByName'");
  }

  @Override
  public List<EmployeeEntity> getEmployeeByoccupation(String occupation) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getEmployeeByoccupation'");
  }

  @Override
  public void addEmployee(EmployeeEntity employeeEntity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addEmployee'");
  }

  @Override
  public void updateEmployee(EmployeeEntity employeeEntity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
  }

  @Override
  public void deleteEmployee(EmployeeEntity employeeEntity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
  }

}
