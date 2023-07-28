package fr.eni.pizza12.dal;

import java.util.List;

import fr.eni.pizza12.bo.AccountEntity;

public interface AccountRepository {

    public List<AccountEntity> getAllAccounts();

    public AccountEntity getAccountbyId(int id);

    public List<AccountEntity> getAccountByFirstName(String accountFirstName);

    public List<AccountEntity> getAccountByLastName(String accountLastName);

    public List<AccountEntity> getAccountByName(String accountName);
}
