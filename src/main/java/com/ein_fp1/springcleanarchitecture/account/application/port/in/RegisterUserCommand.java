package com.ein_fp1.springcleanarchitecture.account.application.port.in;

import com.ein_fp1.springcleanarchitecture.account.domain.User;
import com.ein_fp1.springcleanarchitecture.common.SelfValidating;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class RegisterUserCommand extends SelfValidating<RegisterUserCommand> {

  @NotNull
  private final User user;

  public RegisterUserCommand(
      User user
  ) {
    this.user = user;
    this.validateSelf();
  }

}
