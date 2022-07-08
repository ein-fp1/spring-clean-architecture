package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<PasswordJpaEntity, Long> {

  Optional<PasswordJpaEntity> findByAccountId(String accountId);

}
