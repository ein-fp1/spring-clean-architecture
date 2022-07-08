package com.ein_fp1.springcleanarchitecture.account.application.port.out;

import com.ein_fp1.springcleanarchitecture.account.domain.Account;

public interface RegisterAccountPort {
  void registerAccount(Account account, String password);
}
