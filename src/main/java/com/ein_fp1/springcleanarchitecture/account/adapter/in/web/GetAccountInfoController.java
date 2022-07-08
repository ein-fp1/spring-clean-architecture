package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.GetAccountInfoQuery;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import com.ein_fp1.springcleanarchitecture.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
class GetAccountInfoController {


  private final GetAccountInfoQuery getAccountInfoQuery;

  @GetMapping("{accountId}")
  ResponseEntity getAccountInfo (@PathVariable("accountId")AccountId accountId) {
    final var accountInfo = getAccountInfoQuery.getAccountInfo(accountId);

    AccountViewResource accountViewResource = AccountViewResource
        .builder()
        .username(accountInfo.username())
        .displayName(accountInfo.displayName())
        .build();

    return ResponseEntity.ok().body(accountViewResource);

  }

}
