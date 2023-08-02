package fr.eni.pizza12.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.eni.pizza12.utils.Constants;

public class AccountEntity {

  private int accountId;
  private String accountLastName;
  private String accountFirstName;
  private LocalDate accountDateOfBirth;
  private LocalDate accountDateOfCreation;
  private String accountMail;
  private String accountPhone;

  public AccountEntity() {
  }

  public AccountEntity(int accountId, String accountLastName, String accountFirstName, LocalDate accountDateOfBirth,
      LocalDate accountDateOfCreation, String accountMail, String accountPhone) {
    this.accountId = accountId;
    this.accountLastName = accountLastName;
    this.accountFirstName = accountFirstName;
    this.accountDateOfBirth = accountDateOfBirth;
    this.accountDateOfCreation = accountDateOfCreation;
    this.accountMail = accountMail;
    this.accountPhone = accountPhone;
  }

  /*
   * public AccountEntity(int accountId, String accountLastName, String
   * accountFirstName, String accountDateOfBirth,
   * String accountDateOfCreation, String accountMail, String accountPhone) {
   * 
   * DateTimeFormatter formatter =
   * DateTimeFormatter.ofPattern(Constants.LOCALDATE_WITHOUT_TIME_PATTERN);
   * this.accountId = accountId;
   * this.accountLastName = accountLastName;
   * this.accountFirstName = accountFirstName;
   * this.accountDateOfBirth = LocalDate.parse(accountDateOfBirth, formatter);
   * this.accountDateOfCreation = LocalDate.parse(accountDateOfCreation,
   * formatter);
   * this.accountMail = accountMail;
   * this.accountPhone = accountPhone;
   * 
   * }
   */

  public int getAccountId() {
    return this.accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getAccountLastName() {
    return this.accountLastName;
  }

  public void setAccountLastName(String accountLastName) {
    this.accountLastName = accountLastName;
  }

  public String getAccountFirstName() {
    return this.accountFirstName;
  }

  public void setAccountFirstName(String accountFirstName) {
    this.accountFirstName = accountFirstName;
  }

  public LocalDate getAccountDateOfBirth() {
    return this.accountDateOfBirth;
  }

  public void setAccountDateOfBirth(LocalDate accountDateOfBirth) {
    this.accountDateOfBirth = accountDateOfBirth;
  }

  public LocalDate getAccountDateOfCreation() {
    return this.accountDateOfCreation;
  }

  public void setAccountDateOfCreation(LocalDate accountDateOfCreation) {
    this.accountDateOfCreation = accountDateOfCreation;
  }

  public String getAccountMail() {
    return this.accountMail;
  }

  public void setAccountMail(String accountMail) {
    this.accountMail = accountMail;
  }

  public String getAccountPhone() {
    return this.accountPhone;
  }

  public void setAccountPhone(String accountPhone) {
    this.accountPhone = accountPhone;
  }

  @Override
  public String toString() {
    return "{" +
        " accountId='" + getAccountId() + "'" +
        ", accountLastName='" + getAccountLastName() + "'" +
        ", accountFirstName='" + getAccountFirstName() + "'" +
        ", accountDateOfBirth='" + getAccountDateOfBirth() + "'" +
        ", accountDateOfCreation='" + getAccountDateOfCreation() + "'" +
        ", accountMail='" + getAccountMail() + "'" +
        ", accountPhone='" + getAccountPhone() + "'" +
        "}";
  }

}
