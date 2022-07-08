package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterAccountUseCase;
import com.ein_fp1.springcleanarchitecture.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts/register")
class RegisterUserController {

  private final RegisterAccountUseCase registerAccountUseCase;

  @PostMapping("")
  void registerAccountInfo(
      @RequestBody RegisterAccountRequest registerAccountRequest
  )  {


    registerAccountUseCase.registerAccount(
        new RegisterAccountCommand(
            registerAccountRequest.email(),
            registerAccountRequest.username(),
            registerAccountRequest.displayName(),
            registerAccountRequest.password()
        )
    );
  }

}
