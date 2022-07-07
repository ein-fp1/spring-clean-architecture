package com.ein_fp1.springcleanarchitecture.account.adapter.in.web;

import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterGuestCommand;
import com.ein_fp1.springcleanarchitecture.account.application.port.in.RegisterUserUseCase;
import com.ein_fp1.springcleanarchitecture.account.domain.User;
import com.ein_fp1.springcleanarchitecture.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
@RequestMapping("/account/user")
class RegisterUserController {

  private final RegisterUserUseCase registerUserUseCase;


  @PostMapping("/guests")
  void RegisterGuest(
      @RequestBody RegisterGuestRequest registerGuestRequest
  )  {

    User user = new User(registerGuestRequest.getUsername()
        , registerGuestRequest.getNickname()
        , registerGuestRequest.getBirth());

    RegisterGuestCommand command = new RegisterGuestCommand(user);

    registerUserUseCase.registerGuest(command);
  }

}
