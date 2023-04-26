package com.upgrad.PaymentService.controller;

import com.upgrad.PaymentService.dto.TransactionDetailsEntity;
import com.upgrad.PaymentService.dto.TransactionId;
import com.upgrad.PaymentService.entities.Transaction;
import com.upgrad.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/transaction")
    public ResponseEntity<TransactionId> makeTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createTransaction(transaction));
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<TransactionDetailsEntity> getTransactionDetails(@PathVariable int transactionId){
        return ResponseEntity.ok(paymentService.getTransactionDetails(transactionId));

    }
}
