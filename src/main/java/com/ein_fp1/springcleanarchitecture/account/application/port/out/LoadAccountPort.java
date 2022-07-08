package com.ein_fp1.springcleanarchitecture.account.application.port.out;

import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;

public interface LoadAccountPort {

  Account loadAccount(AccountId accountId);

}
