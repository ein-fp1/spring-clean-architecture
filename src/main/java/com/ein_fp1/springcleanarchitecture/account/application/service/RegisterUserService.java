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
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterUserService implements RegisterAccountUseCase {

  private final RegisterAccountPort registerAccountPort;

  private final PasswordEncoder passwordEncoder;

  private final IdGenerator idGenerator;

  @Override
  public void registerAccount(RegisterAccountCommand registerAccountCommand) {
    final AccountId newAccountId = AccountId.fromString(idGenerator.generateId());
    final Account account = new Account(
        newAccountId,
        registerAccountCommand.username(),
        registerAccountCommand.displayName(),
        registerAccountCommand.email()
        );

    final String encodedPassword = passwordEncoder.encode(registerAccountCommand.password());

    registerAccountPort.registerAccount(account, encodedPassword);
  }
}
