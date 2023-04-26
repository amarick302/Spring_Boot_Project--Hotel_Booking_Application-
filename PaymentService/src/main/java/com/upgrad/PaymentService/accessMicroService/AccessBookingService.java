package com.upgrad.PaymentService.accessMicroService;

import com.upgrad.PaymentService.dto.BookingInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("BOOKING-SERVICE")
public interface AccessBookingService {

    @GetMapping("/booking/{id}")
    public BookingInfo getBookingInfo(@PathVariable int id);
}
