package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

record RegisterAccountRequest(
    String email,
    String username,
    String displayName,
    String password
) {

}
