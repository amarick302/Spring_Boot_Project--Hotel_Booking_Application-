package com.upgrad.BookingService.accessMicroService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PAYMENT-SERVICE")
public interface AccessPaymentService {

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> sendDetailsToTransactionService(@RequestBody Transaction transaction);
}
