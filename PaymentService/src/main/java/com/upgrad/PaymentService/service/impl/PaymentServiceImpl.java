package com.upgrad.PaymentService.service.impl;

import com.upgrad.PaymentService.accessMicroService.AccessBookingService;
import com.upgrad.PaymentService.dao.PaymentDAO;
import com.upgrad.PaymentService.dto.TransactionDetailsEntity;
import com.upgrad.PaymentService.dto.TransactionId;
import com.upgrad.PaymentService.entities.Transaction;
import com.upgrad.PaymentService.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDAO paymentDAO;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccessBookingService bookingService;

    @Override
    public TransactionId createTransaction(Transaction transaction) {
        Transaction savedTransaction1 = paymentDAO.save(transaction);
        return new TransactionId(savedTransaction1.getTransactionId());

    }

    @Override
    public TransactionDetailsEntity getTransactionDetails(int transactionId) {
        Transaction transaction = paymentDAO.findByTransactionId(transactionId);
        TransactionDetailsEntity transactionDetailsEntity=modelMapper.map(transaction, TransactionDetailsEntity.class);
        int bookingId=transactionDetailsEntity.getBookingId();
        String message ="Booking confirmed for user with aadhaar number: "+bookingService.getBookingInfo(bookingId).getAadharNumber()+
                ". Here are the booking details:    "
                +bookingService.getBookingInfo(bookingId);
        System.out.println(message);
        return transactionDetailsEntity;
    }
}
