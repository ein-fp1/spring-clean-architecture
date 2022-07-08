package com.ein_fp1.springcleanarchitecture.common;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UuidGenerateService implements IdGenerator{

  @Override
  public String generateId() {
    return UUID.randomUUID().toString();
  }
}
