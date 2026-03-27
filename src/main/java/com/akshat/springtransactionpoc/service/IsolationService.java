package com.akshat.springtransactionpoc.service;

import com.akshat.springtransactionpoc.entity.Account;
import com.akshat.springtransactionpoc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class IsolationService {

  private final AccountRepository repo;


  @Transactional(isolation = Isolation.READ_COMMITTED)
  public void readCommitted(Long id) {

    log.info("READ_COMMITTED: First read");
    Account acc1 = repo.findById(id).orElseThrow();
    log.info("Balance: {}", acc1.getBalance());

    sleep(5000);

    log.info("READ_COMMITTED: Second read");
    Account acc2 = repo.findById(id).orElseThrow();
    log.info("Balance: {}", acc2.getBalance());
  }


  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void repeatableRead(Long id) {

    log.info("REPEATABLE_READ: First read");
    Account acc1 = repo.findById(id).orElseThrow();
    log.info("Balance: {}", acc1.getBalance());

    sleep(5000);

    log.info("REPEATABLE_READ: Second read");
    Account acc2 = repo.findById(id).orElseThrow();
    log.info("Balance: {}", acc2.getBalance());
  }

  @Transactional
  public void updateBalance(Long id, double newBalance) {
    Account acc = repo.findById(id).orElseThrow();
    acc.setBalance(newBalance);
    repo.save(acc);

    log.info("Updated balance to {}", newBalance);
  }


  private void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}