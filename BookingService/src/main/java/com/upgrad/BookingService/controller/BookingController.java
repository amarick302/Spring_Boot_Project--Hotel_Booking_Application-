package com.upgrad.BookingService.controller;

import com.upgrad.BookingService.accessMicroService.AccessPaymentService;
import com.upgrad.BookingService.accessMicroService.Transaction;
import com.upgrad.BookingService.entities.BookingInfoEntity;
import com.upgrad.BookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    AccessPaymentService paymentService;

    @PostMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingInfoEntity> crateBooking(@RequestBody BookingInfoEntity booking){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(booking));
    }

    @GetMapping("/booking/{id}")
    public BookingInfoEntity getBookingInfo(@PathVariable int id){
        return bookingService.getBookingInfo(id);
    }

    @PostMapping(value = "/booking/{bookingid}/transaction")
    public ResponseEntity<BookingInfoEntity> allowTransaction(@PathVariable int bookingid,@RequestBody Transaction transaction){
       return ResponseEntity.ok(bookingService.allowTransaction(bookingid,transaction));
    }
}
