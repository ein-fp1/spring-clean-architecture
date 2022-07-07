package com.ein_fp1.springcleanarchitecture.account.application.port.out;

import com.ein_fp1.springcleanarchitecture.account.domain.Guest;

public interface RegisterUserPort {

  void registerGuest(Guest guest);
}
