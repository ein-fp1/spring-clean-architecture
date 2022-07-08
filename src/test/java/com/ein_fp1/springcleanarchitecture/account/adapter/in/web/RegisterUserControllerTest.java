package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountUseCase;
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
class RegisterUserControllerTest {

  @Autowired
  private MockMvc mockMvc;


  @MockBean
  private RegisterAccountUseCase registerAccountUseCase;

  @Autowired
  ObjectMapper objectMapper;


  @Test
  void testRegisterAccount() throws Exception {
    mockMvc.perform(post("/accounts/register")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(
                objectMapper.writeValueAsBytes(
                    new RegisterAccountRequest(
                        "ein.fp1@gmail.com",
                        "ein.fp1",
                        "ein_fp1",
                        "abcd"
                    )
                )
            )
        )
        .andExpect(status().isOk());

    then(registerAccountUseCase)
        .should()
        .registerAccount(
            eq(new RegisterAccountCommand(
                "ein.fp1@gmail.com",
                "ein.fp1",
                "ein_fp1",
                "abcd"
                )
            )
        );
  }

}
