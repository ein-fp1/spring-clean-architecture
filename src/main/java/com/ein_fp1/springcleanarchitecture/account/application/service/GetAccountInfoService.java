package com.ein_fp1.springcleanarchitecture.account.application.service;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.GetAccountInfoQuery;
import com.ein_fp1.springcleanarchitecture.account.application.port.out.LoadAccountPort;
import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import com.ein_fp1.springcleanarchitecture.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class GetAccountInfoService implements GetAccountInfoQuery {

  private final LoadAccountPort loadAccountPort;
  @Override
  public Account getAccountInfo(AccountId accountId) {
    return loadAccountPort.loadAccount(accountId);
  }
}
