package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ein_fp1.springcleanarchitecture.account.adapter.in.web.PersonalInfoResource.AccountResource;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.GetAccountInfoQuery;
import com.ein_fp1.springcleanarchitecture.account.domain.Account;
import com.ein_fp1.springcleanarchitecture.account.domain.Account.AccountId;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GetAccountInfoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetAccountInfoQuery getAccountInfoQuery;

  @Autowired
  ObjectMapper objectMapper;
  @Test
  void testGetAccount() throws Exception {
    Account account = new Account(
        AccountId.fromString("1001"),
        "username1",
        "displayName1",
        "ein.fp1@gmail.com"
        );
    given(getAccountInfoQuery.getAccountInfo(AccountId.fromString("1001"))).willReturn(account);

    mockMvc.perform(
        get("/accounts/{accountId}", "1001")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
    ).andExpect(status().isOk());

  }
}
