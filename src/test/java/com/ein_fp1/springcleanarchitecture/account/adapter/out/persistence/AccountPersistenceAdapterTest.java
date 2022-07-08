package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class AccountPersistenceAdapterTest {

  @Autowired
  private AccountPersistenceAdapter accountPersistenceAdapter;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private PasswordRepository passwordRepository;

  @Test
  @Sql("AccountPersistenceAdapterTest.sql")
  void loadAccountTest() {
    Account account = accountPersistenceAdapter.loadAccount(AccountId.fromString("1001"));

    assertThat(account.username()).isEqualTo("username1");
  }

  @Test
  void registerAccountTest() {
    Account account = new Account(
        AccountId.fromString("ID0001"),
        "ein.fp1",
        "ein_fp1",
        "ein.fp1@gmail.com"
    );

    assertThat(accountRepository.findByAccountId("ID0001")).isEmpty();
    accountPersistenceAdapter.registerAccount(account, "abcd");

    assertThat(accountRepository.findByAccountId("ID0001")).isNotEmpty();


    assertThat(
        accountRepository.findByAccountId("ID0001")
        .get().accountId())
        .isEqualTo("ID0001");

    assertThat(accountRepository.findByAccountId("ID0001")).isNotEmpty();
    assertThat(passwordRepository.findByAccountId("ID0001")).isNotEmpty();


  }


}
