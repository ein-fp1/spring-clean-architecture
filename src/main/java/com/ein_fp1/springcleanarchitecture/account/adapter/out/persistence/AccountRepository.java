package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {
  Optional<AccountJpaEntity> findByAccountId(String accountId);
//  AccountJpaEntity findByAccountId(String accountId);
}
