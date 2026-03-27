package com.akshat.springtransactionpoc.controller;

import com.akshat.springtransactionpoc.service.IsolationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/isolation")
@RequiredArgsConstructor
public class IsolationController {

  private final IsolationService isolationService;

  @GetMapping("/read-committed/{id}")
  public String readCommitted(@PathVariable Long id) {
    isolationService.readCommitted(id);
    return "READ_COMMITTED done";
  }

  @GetMapping("/repeatable-read/{id}")
  public String repeatableRead(@PathVariable Long id) {
    isolationService.repeatableRead(id);
    return "REPEATABLE_READ done";
  }

  @GetMapping("/update/{id}/{amount}")
  public String update(@PathVariable Long id, @PathVariable double amount) {
    isolationService.updateBalance(id, amount);
    return "Updated";
  }
}