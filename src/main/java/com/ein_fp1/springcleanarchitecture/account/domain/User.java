package com.ein_fp1.springcleanarchitecture.account.domain;

import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
public class User {
  @NotNull
  private final String username;
  @NotNull
  private final String nickname;
  @NotNull
  private final String birth;
}
