package com.akshat.springtransactionpoc.service;

import static com.akshat.springtransactionpoc.config.ApplicationConstant.*;

import com.akshat.springtransactionpoc.entity.Account;
import com.akshat.springtransactionpoc.repository.AccountRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

  private final AccountRepository repo;
  private final InnerService innerService;

  @Override
  @Transactional
  public Map<String, Object> requiredExample() {
    Account account = createAccount("Rohit", 100);
    innerService.requiredInner();
    return response(account, "REQUIRED_SUCCESS");
  }


  @Override
  @Transactional
  public Map<String, Object> requiresNewExample() {
    Account account = createAccount("Rohit", 100);
    try {
      innerService.requiresNewInner();
    } catch (Exception e) {
      log.info("Inner REQUIRES_NEW failed");
    }

    return response(account, "REQUIRES_NEW_OUTER_COMPLETED");
  }


  @Override
  @Transactional
  public Map<String, Object> nestedExample() {
    Account account = createAccount("Rohit", 100);
      innerService.nestedInner();
    return response(account, "NESTED_INNER_ROLLED_BACK");
  }


  @Override
  @Transactional
  public Map<String, Object> supportsExample() {
//    Account account = createAccount("Rohit", 100);
    innerService.supportsInner();
    return Map.of(STATUS, "SUPPORTS_EXECUTED");
  }


  @Override
  @Transactional
  public Map<String, Object> notSupportedExample() {
    Account account = createAccount("Rohit", 100);
    innerService.notSupportedInner();
    return Map.of(STATUS, "NOT_SUPPORTED_EXECUTED");
  }


  @Override
  @Transactional
  public Map<String, Object> neverExample() {
    Account account = createAccount("Rohit", 100);
    innerService.neverInner();
    return Map.of(STATUS, "NEVER_EXECUTED");
  }


  @Override
  @Transactional
  public Map<String, Object> mandatoryExample() {
    Account account = createAccount("Rohit", 100);
    innerService.mandatoryInner();
    return Map.of(STATUS, "MANDATORY_EXECUTED");
  }


  private Account createAccount(String name, double amount) {
    return repo.save(new Account(null, name, amount));
  }

  private Map<String, Object> response(Account account, String status) {
    return Map.of(
        ACCOUNT, account.getName(),
        AMOUNT, account.getBalance(),
        STATUS, status
    );
  }
}