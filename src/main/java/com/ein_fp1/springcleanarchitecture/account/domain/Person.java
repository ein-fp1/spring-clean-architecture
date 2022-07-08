package com.ein_fp1.springcleanarchitecture.account.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Person {
  @Email
  @NotNull
  private final String email;

  @NotNull
  private final String birthdate;

  @NotNull
  private final String firstName;

  @NotNull
  private final String country;

}
