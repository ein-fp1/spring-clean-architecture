package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import com.ein_fp1.springcleanarchitecture.account.domain.Guest;
import org.springframework.stereotype.Component;

@Component
class GuestMapper {
  GuestJpaEntity mapToJpaEntity(Guest guest) {
    return new GuestJpaEntity(guest.getId().getValue());
  }
}
