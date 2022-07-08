package com.ein_fp1.springcleanarchitecture.account.application.port.in;

import com.ein_fp1.springcleanarchitecture.account.domain.User;
import com.ein_fp1.springcleanarchitecture.common.SelfValidating;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false)
public class RegisterAccountCommand extends SelfValidating<RegisterAccountCommand> {

  @Email
  @NotNull
  private final String email;

  private final String username;

  private final String displayName;
  @NotNull
  private final String password;

  public RegisterAccountCommand(
      String email,
      String username,
      String displayName,
      String password
  ) {
    this.email = email;
    this.username = username;
    this.displayName = displayName;
    this.password = password;
    this.validateSelf();
  }

}
