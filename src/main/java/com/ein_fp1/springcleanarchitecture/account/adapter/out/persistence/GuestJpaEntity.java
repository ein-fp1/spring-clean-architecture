package com.ein_fp1.springcleanarchitecture.account.adapter.out.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Guest")
@Data
@NoArgsConstructor
@AllArgsConstructor
class GuestJpaEntity {

  @Id
  @GeneratedValue
  private Long id;
}
