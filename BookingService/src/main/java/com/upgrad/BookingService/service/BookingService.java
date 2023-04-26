package com.upgrad.BookingService.service;

import com.upgrad.BookingService.accessMicroService.Transaction;
import com.upgrad.BookingService.entities.BookingInfoEntity;

public interface BookingService {
    BookingInfoEntity createBooking(BookingInfoEntity booking);
    BookingInfoEntity getBookingInfo(int id);

    BookingInfoEntity allowTransaction(int bookingId,Transaction transaction);
}
