package com.akshat.springtransactionpoc.repository;

import com.akshat.springtransactionpoc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

