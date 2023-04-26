package com.upgrad.BookingService.service.impl;

import com.upgrad.BookingService.accessMicroService.AccessPaymentService;
import com.upgrad.BookingService.accessMicroService.Transaction;
import com.upgrad.BookingService.dao.BookingDAO;
import com.upgrad.BookingService.entities.BookingInfoEntity;
import com.upgrad.BookingService.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccessPaymentService paymentService;

    @Override
    public BookingInfoEntity createBooking(BookingInfoEntity booking) {
        Random random = new Random();
        int upperBound = 100;
        List<String> roomNumbers = new ArrayList<>();

        for(int i=0;i<booking.getNumOfRooms();i++){
            roomNumbers.add(String.valueOf(random.nextInt(upperBound)));
        }

        int roomPrice = (1000*booking.getNumOfRooms()*
                (int)(((booking.getToDate().getTime()-booking.getFromDate().getTime())/(1000 * 60 * 60 * 24))%365));
        booking.setRoomPrice(roomPrice);
        booking.setRoomNumbers(roomNumbers);
        booking.setBookedOn(booking.getFromDate());
        return bookingDAO.save(booking);
    }

    @Override
    public BookingInfoEntity getBookingInfo(int id) {
       return bookingDAO.findById(id).get();
    }

    @Override
    public BookingInfoEntity allowTransaction(int bookingId,Transaction transaction) {
       int transactionId = paymentService.sendDetailsToTransactionService(transaction).
               getBody().getTransactionId();
       BookingInfoEntity booking = bookingDAO.findById(bookingId).get();
       booking.setTransactionId(transactionId);
       return booking;

    }

}
