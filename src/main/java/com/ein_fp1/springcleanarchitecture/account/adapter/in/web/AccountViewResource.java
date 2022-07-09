package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

record AccountViewResource(
    String accountId,
    String displayName,
    String username,
    String email
) {

}
