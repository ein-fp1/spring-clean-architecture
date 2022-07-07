package com.ein_fp1.springcleanarchitecture.account.domain;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Guest {

  @Getter
  private final GuestId id;

  @Getter
  private final User user;

  @Getter
  private final LocalDateTime createdAt;

  public Guest(Long id, User user) {
    this.id = new GuestId(id);
    this.user = user;
    this.createdAt = LocalDateTime.now();
  }

  public static Guest withId(GuestId guestId, User user) {
    return new Guest(guestId.getValue(), user);
  }

  @Value
  public static class GuestId {
    private final Long value;
  }
}
