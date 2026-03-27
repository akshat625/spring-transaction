package com.akshat.springtransactionpoc.controller;


import com.akshat.springtransactionpoc.config.ApiResponse;
import com.akshat.springtransactionpoc.service.TransactionService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.akshat.springtransactionpoc.config.ApiResponse.success;
import static com.akshat.springtransactionpoc.config.ApiResponse.failure;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService transactionService;

  @GetMapping("/required")
  public ResponseEntity<ApiResponse<Map<String, Object>>> required() {
    try {
      var data = transactionService.requiredExample();
      return ResponseEntity.ok(success("REQUIRED executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("Transaction rolled back for REQUIRED"));
    }
  }

  @GetMapping("/requires-new")
  public ResponseEntity<ApiResponse<Map<String, Object>>> requiresNew() {
    try {
      var data = transactionService.requiresNewExample();
      return ResponseEntity.ok(success("REQUIRES_NEW executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("Transaction rolled back for REQUIRES_NEW"));
    }
  }

  @GetMapping("/nested")
  public ResponseEntity<ApiResponse<Map<String, Object>>> nested() {
    try {
      var data = transactionService.nestedExample();
      return ResponseEntity.ok(success("NESTED executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("Transaction rolled back for NESTED"));
    }
  }

  @GetMapping("/supports")
  public ResponseEntity<ApiResponse<Map<String, Object>>> supports() {
    try {
      var data = transactionService.supportsExample();
      return ResponseEntity.ok(success("SUPPORTS executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("SUPPORTS failed"));
    }
  }

  @GetMapping("/not-supported")
  public ResponseEntity<ApiResponse<Map<String, Object>>> notSupported() {
    try {
      var data = transactionService.notSupportedExample();
      return ResponseEntity.ok(success("NOT_SUPPORTED executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("NOT_SUPPORTED failed"));
    }
  }

  @GetMapping("/never")
  public ResponseEntity<ApiResponse<Map<String, Object>>> never() {
    try {
      var data = transactionService.neverExample();
      return ResponseEntity.ok(success("NEVER executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("NEVER failed due to active transaction"));
    }
  }

  @GetMapping("/mandatory")
  public ResponseEntity<ApiResponse<Map<String, Object>>> mandatory() {
    try {
      var data = transactionService.mandatoryExample();
      return ResponseEntity.ok(success("MANDATORY executed", data));
    } catch (Exception e) {
      return ResponseEntity.ok(failure("MANDATORY failed due to no active transaction"));
    }
  }
}