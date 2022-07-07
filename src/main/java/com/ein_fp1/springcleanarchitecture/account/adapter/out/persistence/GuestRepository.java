package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface GuestRepository extends JpaRepository<GuestJpaEntity, Long> {



}
