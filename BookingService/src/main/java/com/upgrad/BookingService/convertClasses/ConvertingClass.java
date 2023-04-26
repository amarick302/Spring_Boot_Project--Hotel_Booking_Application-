//package com.upgrad.BookingService.convertClasses;
//
//import com.upgrad.BookingService.entities.BookingInfoEntity;
//import com.upgrad.BookingService.entities.Booking;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Component
//public class ConvertingClass {
//
//    public BookingInfoEntity bookingToBookingInfoEntity(Booking booking){
//
//        Random random = new Random();
//        int upperBound = 100;
//        List<String> roomNumbers = new ArrayList<>();
//
//        for(int i=0;i<booking.getNumOfRooms();i++){
//            roomNumbers.add(String.valueOf(random.nextInt(100)));
//        }
//
//        int roomPrice = (1000*booking.getNumOfRooms()*
//                (int)(((booking.getToDate().getTime()-booking.getFromDate().getTime())/(1000 * 60 * 60 * 24))%365));
//
//        return new BookingInfoEntity(booking.getBookingId(),booking.getFromDate(),
//                booking.getToDate(),booking.getAadharNumber(),roomNumbers,
//                roomPrice,booking.getTransactionId(),booking.getFromDate());
//    }
//
//}
