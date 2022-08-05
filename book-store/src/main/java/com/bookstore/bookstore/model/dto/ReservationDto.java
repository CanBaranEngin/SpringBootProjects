package com.bookstore.bookstore.model.dto;

import lombok.Data;


import java.util.Date;
@Data
public class ReservationDto {
    private Long bookId;
    private Long userId;
    private String reservationDate;
    private String resDeadline;
}
