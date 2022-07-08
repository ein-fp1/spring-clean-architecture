package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import com.ein_fp1.springcleanarchitecture.account.application.port.out.LoadAccountPort;
import com.ein_fp1.springcleanarchitecture.account.application.port.out.RegisterAccountPort;
import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import com.ein_fp1.springcleanarchitecture.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, RegisterAccountPort {

  private final AccountRepository accountRepository;

  private final PasswordRepository passwordRepository;

  private final AccountMapper accountMapper;


  @Override
  public Account loadAccount(AccountId accountId){

    AccountJpaEntity accountJpaEntity = accountRepository.findByAccountId(
        accountId.id())
        .orElseThrow();

    return accountMapper.mapToDomainEntity(accountJpaEntity);
  }

  @Override
  public void registerAccount(Account account, String password) {
    accountRepository.save(accountMapper.mapToJpaEntity(account));
    passwordRepository.save(accountMapper.mapToJpaPassword(account.accountId(), password));
  }
}
