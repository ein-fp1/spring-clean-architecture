package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

record RegisterPersonRequest(
    String fullName,
    String photoURL,
    String birthdate
) {

}
