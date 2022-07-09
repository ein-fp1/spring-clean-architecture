package com.ein_fp1.springcleanarchitecture.account.application.port.in;

import com.ein_fp1.springcleanarchitecture.account.domain.User;
import com.ein_fp1.springcleanarchitecture.common.SelfValidating;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false)
public class RegisterAccountCommand extends SelfValidating<RegisterAccountCommand> {

  @Email
  @NotNull
  @Size(min = 5)
  private final String email;

  @NotBlank
  @Size(min = 5)
  private final String username;

  @NotBlank
  @Size(min = 2)
  private final String displayName;
  @NotNull
  @NotBlank
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
