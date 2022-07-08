package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import lombok.Builder;

@Builder
record AccountViewResource(
    String displayName,
    String username,
    String email
) {

}
