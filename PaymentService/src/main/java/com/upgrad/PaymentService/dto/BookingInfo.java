package com.upgrad.PaymentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingInfo {

    private String aadharNumber;
    private List<String> roomNumbers;
    private int roomPrice;
    private Date bookedOn;
}
