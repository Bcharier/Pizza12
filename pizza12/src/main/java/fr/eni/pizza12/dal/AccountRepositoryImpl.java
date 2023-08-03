package fr.eni.pizza12.dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import fr.eni.pizza12.bo.AccountEntity;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  private static class AccountRowMapper implements RowMapper<AccountEntity> {
    public AccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
      AccountEntity accountEntity = new AccountEntity();
      accountEntity.setAccountId(rs.getInt("accountId"));
      accountEntity.setAccountFirstName(rs.getString("accountFirstName"));
      accountEntity.setAccountLastName(rs.getString("accountLastName"));
      accountEntity.setAccountDateOfBirth(rs.getDate("accountDateOfBirth").toLocalDate());
      accountEntity.setAccountDateOfCreation(rs.getDate("accountCreationDate").toLocalDate());
      accountEntity.setAccountMail(rs.getString("accountMail"));
      accountEntity.setAccountPhone(rs.getString("accountPhone"));
      return accountEntity;
    }
  }

  @Override
  public List<AccountEntity> getAllAccounts() {
    String sql = "SELECT * FROM Accounts";

    return jdbcTemplate.query(sql, new AccountRowMapper());
  }

  @Override
  public AccountEntity getAccountbyId(int id) {
    String sql = "SELECT * FROM Accounts Where accountId = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    }, new AccountRowMapper()).get(0);
  }

  @Override
  public List<AccountEntity> getAccountByFirstName(String accountFirstName) {
    String sql = "SELECT * FROM Accounts Where accountFirstName LIKE %?%";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, accountFirstName);
      }
    }, new AccountRowMapper());
  }

  @Override
  public List<AccountEntity> getAccountByLastName(String accountLastName) {
    String sql = "SELECT * FROM Accounts Where accountLastName LIKE %?%";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, accountLastName);
      }
    }, new AccountRowMapper());
  }

  @Override
  public List<AccountEntity> getAccountByName(String accountName) {
    String sql = "SELECT * FROM Accounts Where accountFirstName OR accountLastName LIKE %?%";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, accountName);
      }
    }, new AccountRowMapper());
  }

  @Override
  public void deleteAccount(AccountEntity accountEntity) {
    String sql = "DELETE FROM Accounts WHERE accountId = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, accountEntity.getAccountId());
      }
    });
  }

  @Override
  public void deleteAccountById(int id) {
    String sql = "DELETE FROM Accounts WHERE accountId = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
      }
    });
  }

  @Override
  public void updateAccount(AccountEntity accountEntity) {
    String sql = "UPDATE Accounts SET accountId = ?, accountFirstName = ?, accountLastName = ?, accountDateOfBirth = ?, accountDateOfCreation = ?, accountMail = ?, accountPhone = ?";

    jdbcTemplate.update(sql, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, accountEntity.getAccountId());
        preparedStatement.setString(2, accountEntity.getAccountFirstName());
        preparedStatement.setString(3, accountEntity.getAccountLastName());
        preparedStatement.setDate(4, Date.valueOf(accountEntity.getAccountDateOfBirth()));
        preparedStatement.setDate(5, Date.valueOf(accountEntity.getAccountDateOfCreation()));
        preparedStatement.setString(6, accountEntity.getAccountMail());
        preparedStatement.setString(7, accountEntity.getAccountPhone());
      }
    });
  }

  @Override
  public void addAccount(AccountEntity accountEntity) {
    String sql = "INSERT INTO accounts (accountId, accountFirstName, accountLastName, accountDateOfBirth, accountDateOfCreation, accountMail, accountPhone) VALUES (:accountId, :accountFirstName, :accountLastName, :accountDateOfBirth, :accountDateOfCreation, :accountMail, :accountPhone)";
    SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(accountEntity);
    namedParameterJdbcTemplate.update(sql, namedParameters);
  }

}
