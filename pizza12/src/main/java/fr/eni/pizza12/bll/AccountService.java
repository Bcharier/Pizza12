package fr.eni.pizza12.bll;

import java.util.List;

import fr.eni.pizza12.bo.AccountEntity;

public interface AccountService {
    public List<AccountEntity> getAllAccounts();

    public AccountEntity getAccountbyId(int id);

    public AccountEntity getAccountByFirstName(String accountFirstName);

    public AccountEntity getAccountByLastName(String accountLastName);

    public AccountEntity getAccountByName(String accountName);

    public AccountEntity 
}
