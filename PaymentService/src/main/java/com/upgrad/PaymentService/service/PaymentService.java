package com.upgrad.PaymentService.service;

import com.upgrad.PaymentService.dto.TransactionDetailsEntity;
import com.upgrad.PaymentService.dto.TransactionId;
import com.upgrad.PaymentService.entities.Transaction;

public interface PaymentService {
    TransactionId createTransaction(Transaction transaction);
    TransactionDetailsEntity getTransactionDetails(int transactionId);
}
