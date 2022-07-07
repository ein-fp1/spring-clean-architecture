package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import lombok.Value;

@Value
class RegisterGuestRequest {
  private final String username;
  private final String nickname;
  private final String birth;
}
