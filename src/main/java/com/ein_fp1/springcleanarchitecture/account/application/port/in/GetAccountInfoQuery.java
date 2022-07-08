package com.ein_fp1.springcleanarchitecture.account.application.port.in;

import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;

public interface GetAccountInfoQuery {
  Account getAccountInfo(AccountId accountId);
}
