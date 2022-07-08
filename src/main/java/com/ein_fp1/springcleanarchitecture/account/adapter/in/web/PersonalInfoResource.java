package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

record PersonalInfoResource (
    AccountResource account
) {

    record AccountResource (
      String username,
      String displayName
  ) {

  }
}
