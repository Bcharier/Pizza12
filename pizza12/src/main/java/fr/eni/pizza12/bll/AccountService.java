package fr.eni.pizza12.bll;

import java.util.List;

import fr.eni.pizza12.bo.AccountEntity;

public interface AccountService {

  public List<AccountEntity> getAllAccounts();

  public AccountEntity getAccountbyId(int id);

  public List<AccountEntity> getAccountByFirstName(String accountFirstName);

  public List<AccountEntity> getAccountByLastName(String accountLastName);

  public List<AccountEntity> getAccountByName(String accountName);

  public void deleteAccount(AccountEntity accountEntity);

  public void deleteAccountById(int id);

  public AccountEntity updateAccount(AccountEntity accountEntity);

  public void addAccount(AccountEntity accountEntity);
}
