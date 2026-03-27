package com.akshat.springtransactionpoc.config;


import com.akshat.springtransactionpoc.entity.Account;
import com.akshat.springtransactionpoc.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

  private final AccountRepository accountRepository;

  @Override
  public void run(String... args) {
    if (accountRepository.count() == 0) {
      accountRepository.saveAll(List.of(
          Account.builder().name("Akshat").balance(1000.0).build(),
          Account.builder().name("Aditya").balance(2000.0).build(),
          Account.builder().name("Divyam").balance(3000.0).build()
      ));
      System.out.println("[INIT] Seeded sample accounts.");
    }
  }
}