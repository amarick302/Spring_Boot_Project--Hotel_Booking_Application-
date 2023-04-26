package com.upgrad.PaymentService.dao;

import com.upgrad.PaymentService.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDAO extends JpaRepository<Transaction,Integer> {
    public Transaction findByTransactionId(int transactionId);
}
