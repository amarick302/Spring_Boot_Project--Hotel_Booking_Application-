//package com.upgrad.BookingService.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import java.util.Date;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Booking {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int bookingId;
//
//    private Date fromDate;
//
//    private Date toDate;
//
//    private String aadharNumber;
//
//    private int numOfRooms;
//
//    @Column(columnDefinition = "integer default 0")
//    private int transactionId;
//}
