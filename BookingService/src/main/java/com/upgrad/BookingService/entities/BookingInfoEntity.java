package com.upgrad.BookingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class BookingInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    private Date fromDate;

    private Date toDate;

    private String aadharNumber;

    private int numOfRooms;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Room_Numbers",joinColumns =@JoinColumn(name = "bookingId"))
    private List<String> roomNumbers;

    private int roomPrice;

    @Column(columnDefinition = "integer default 0")
    private int transactionId;

    private Date bookedOn;
}
