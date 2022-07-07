package com.ein_fp1.springcleanarchitecture.account.application.service;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterGuestCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterUserCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterUserUseCase;
import com.ein_fp1.springcleanarchitecture.account.application.port.out.RegisterUserPort;
import com.ein_fp1.springcleanarchitecture.account.domain.Guest;
import com.ein_fp1.springcleanarchitecture.common.UseCase;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterUserService implements RegisterUserUseCase {

  private final RegisterUserPort registerUserPort;

  @Override
  public void registerGuest(RegisterGuestCommand command) {
    Guest guest = new Guest(1L, command.getUser());
    registerUserPort.registerGuest(guest);
  }

  @Override
  public void registerHost(RegisterUserCommand command) {

  }

  @Override
  public void registerAdmin(RegisterUserCommand command) {

  }
}
