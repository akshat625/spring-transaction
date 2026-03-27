package com.akshat.springtransactionpoc.service;


import java.util.Map;

public interface TransactionService {

  Map<String, Object> requiredExample();

  Map<String, Object> requiresNewExample();

  Map<String, Object> nestedExample();

  Map<String, Object> supportsExample();

  Map<String, Object> notSupportedExample();

  Map<String, Object> neverExample();

  Map<String, Object> mandatoryExample();
}

