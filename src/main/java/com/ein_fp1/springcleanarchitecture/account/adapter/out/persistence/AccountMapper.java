package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
  Account mapToDomainEntity(
      AccountJpaEntity accountJpaEntity
  ) {
    return new Account(
        AccountId.fromString(accountJpaEntity.accountId()),
        accountJpaEntity.username(),
        accountJpaEntity.displayName(),
        accountJpaEntity.email()
    );
  }

  AccountJpaEntity mapToJpaEntity(
      Account account
  ) {
    System.out.println(account.accountId().id());
    return AccountJpaEntity.builder()
        .accountId(account.accountId().id())
        .username(account.username())
        .email(account.email())
        .displayName(account.displayName())
        .build()
        ;
  }

  PasswordJpaEntity mapToJpaPassword(
      AccountId accountId,
      String password
  ) {
    return PasswordJpaEntity.builder()
        .accountId(accountId.id())
        .password(password)
        .build();
  }
}
