package com.ein_fp1.springcleanarchitecture.account.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.out.RegisterAccountPort;
import com.ein_fp1.springcleanarchitecture.common.IdGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterUserServiceTest {

  private final RegisterAccountPort registerAccountPort =
      Mockito.mock(RegisterAccountPort.class);

  private final PasswordEncoder passwordEncoder =
      Mockito.mock(PasswordEncoder.class);

  private final IdGenerator idGenerator
      = Mockito.mock(IdGenerator.class);

  private final RegisterUserService registerUserService =
      new RegisterUserService(
          registerAccountPort,
          passwordEncoder,
          idGenerator
      );

  @Test
  void accountRegistrationSucceeds() {
    String email = "ein.fp1@gmail.com";
    String username = "ein.fp1";
    String displayName = "ein_fp1";
    String password = "abcd";
    RegisterAccountCommand command = new RegisterAccountCommand(
        email,
        username,
        displayName,
        password
    );

    registerUserService.registerAccount(command);
  }
}
