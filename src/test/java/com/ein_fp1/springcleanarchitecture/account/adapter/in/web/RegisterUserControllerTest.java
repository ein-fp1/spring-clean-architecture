package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterGuestCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterUserUseCase;
import com.ein_fp1.springcleanarchitecture.account.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterUserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RegisterUserUseCase registerUserUseCase;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void testRegisterGuest() throws Exception {
    mockMvc.perform(post("/account/user/guests")
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
            .content(
                objectMapper.writeValueAsBytes(
                    new RegisterGuestRequest(
                        "user",
                        "nick",
                        "19000101")
                )
            )
        )
        .andExpect(status().isOk());

    then(registerUserUseCase)
        .should()
        .registerGuest(
            eq(new RegisterGuestCommand(new User("user", "nick", "19000101"))
            )
        );
  }

}
