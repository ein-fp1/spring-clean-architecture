package com.ein_fp1.springcleanarchitecture.account.domain;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class Account {

  @Getter
  private AccountId accountId;

  @NotNull
  @Getter
  private final String username;

  @NotNull
  @Getter
  private final String displayName;

  @NotNull
  @Getter
  private final String email;

  private LocalDateTime createdAt;

  public Account(AccountId accountId, String username, String displayName, String email) {
    this.accountId = accountId;
    this.username = username;
    this.displayName = displayName;
    this.email = email;
  }


  public record AccountId(String id) {
      public static AccountId fromString(String accountId) {
        return new AccountId(accountId);
      }
    }
}
