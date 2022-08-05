package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.dto.ReservationDto;
import com.bookstore.bookstore.model.entity.Reservation;

public interface ReservationService {
    Reservation createReservation(ReservationDto reservationDto);
}
