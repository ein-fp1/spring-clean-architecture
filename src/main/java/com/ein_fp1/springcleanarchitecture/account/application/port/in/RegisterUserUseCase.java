package com.ein_fp1.springcleanarchitecture.account.application.port.in;

public interface RegisterUserUseCase {
  void registerGuest(RegisterGuestCommand command);
  void registerHost(RegisterUserCommand command);
  void registerAdmin(RegisterUserCommand command);

}
