package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;


import com.ein_fp1.springcleanarchitecture.account.application.port.out.RegisterUserPort;
import com.ein_fp1.springcleanarchitecture.account.domain.Guest;
import com.ein_fp1.springcleanarchitecture.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class UserPersistenceAdapter implements RegisterUserPort {

  private final GuestMapper guestMapper;

  private final GuestRepository guestRepository;

  @Override
  public void registerGuest(Guest guest) {
    System.out.println(guest.getUser().getUsername());
//    guestRepository.save(guestMapper.mapToJpaEntity(guest));
  }
}
