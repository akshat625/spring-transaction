package com.akshat.springtransactionpoc.service;

import com.akshat.springtransactionpoc.entity.Account;
import com.akshat.springtransactionpoc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InnerServiceImpl implements InnerService {

  private final AccountRepository repo;

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void requiredInner() {
    Account account = createAccount("Inner-REQ", 200.0);
    log.info("REQUIRED INNER executed: {}", buildLog(account, "JOINED_EXISTING_TX"));
    throw new RuntimeException("Fail REQUIRED");

  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void requiresNewInner() {
    Account account = createAccount("Inner-NEW", 300.0);
    log.info("REQUIRES_NEW INNER executed: {}", buildLog(account, "NEW_TX_STARTED"));

    throw new RuntimeException("Fail REQUIRES_NEW");
  }

  @Override
  @Transactional(propagation = Propagation.NESTED)
  public void nestedInner() {
    Account account = createAccount("Inner-NESTED", 400.0);
    log.info("NESTED INNER executed: {}", buildLog(account, "SAVEPOINT_CREATED"));

    throw new RuntimeException("Fail NESTED");
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public void supportsInner() {
    Account account = createAccount("Inner-SUPPORTS", 500.0);
    log.info("SUPPORTS INNER executed: {}", buildLog(account, "TX_IF_PRESENT"));
//    throw new RuntimeException("Fail NESTED");
  }

  @Override
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void notSupportedInner() {
    Account account = createAccount("Inner-NOT_SUPPORTED", 600.0);
    log.info("NOT_SUPPORTED INNER executed: {}", buildLog(account, "NO_TX_AUTOCOMMIT"));
//    throw new RuntimeException("Fail NESTED");

  }

  @Override
  @Transactional(propagation = Propagation.NEVER)
  public void neverInner() {
    Account account = createAccount("Inner-NEVER", 700.0);
    log.info("NEVER INNER executed: {}", buildLog(account, "NO_TX_ALLOWED"));
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public void mandatoryInner() {
    Account account = createAccount("Inner-MANDATORY", 800.0);
    log.info("MANDATORY INNER executed: {}", buildLog(account, "TX_REQUIRED"));
//    throw new RuntimeException("Fail NESTED");

  }


  private Account createAccount(String name, Double amount) {
    return repo.save(new Account(null, name, amount));
  }

  private String buildLog(Account account, String status) {
    return String.format(
        "account=%s, amount=%.2f, status=%s",
        account.getName(),
        account.getBalance(),
        status
    );
  }
}