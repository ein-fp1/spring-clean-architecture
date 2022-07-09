package com.ein_fp1.springcleanarchitecture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().permitAll()
        .and()
        .formLogin().disable()
        .csrf().disable()
        .logout().disable()
        .sessionManagement().disable()
        .headers().disable();

/*    http.authorizeHttpRequests((auth) -> auth.antMatchers("**").permitAll())
        .httpBasic(Customizer.withDefaults());*/
    return http.build();
  }

}
