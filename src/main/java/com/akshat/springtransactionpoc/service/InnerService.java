package com.akshat.springtransactionpoc.service;

public interface InnerService {

  void requiredInner();

  void requiresNewInner();

  void nestedInner();

  void supportsInner();

  void notSupportedInner();

  void neverInner();

  void mandatoryInner();
}
