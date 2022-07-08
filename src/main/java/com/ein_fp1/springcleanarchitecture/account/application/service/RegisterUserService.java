package com.ein_fp1.springcleanarchitecture.account.application.service;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountUseCase;
import com.ein_fp1.springcleanarchitecture.account.application.port.out.RegisterAccountPort;
import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import com.ein_fp1.springcleanarchitecture.common.IdGenerator;
import com.ein_fp1.springcleanarchitecture.common.UseCase;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterUserService implements RegisterAccountUseCase {

  private final RegisterAccountPort registerAccountPort;

  private final IdGenerator idGenerator;

  @Override
  public void registerAccount(RegisterAccountCommand registerAccountCommand) {
    AccountId newAccountId = AccountId.fromString(idGenerator.generateId());
    Account account = new Account(
        newAccountId,
        registerAccountCommand.username(),
        registerAccountCommand.displayName(),
        registerAccountCommand.email()
        );

    registerAccountPort.registerAccount(account, registerAccountCommand.password());
  }
}
