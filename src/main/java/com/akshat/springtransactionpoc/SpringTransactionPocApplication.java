package com.akshat.springtransactionpoc;

import static com.akshat.springtransactionpoc.config.ApplicationConstant.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTransactionPocApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringTransactionPocApplication.class, args);
    System.out.println(APP_STARTED_MESSAGE);
  }

}
