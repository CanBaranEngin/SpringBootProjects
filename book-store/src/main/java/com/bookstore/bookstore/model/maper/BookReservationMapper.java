package com.bookstore.bookstore.model.maper;

import com.bookstore.bookstore.model.dto.ReservationDto;
import com.bookstore.bookstore.model.entity.Reservation;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.impl.BookServiceImpl;
import com.bookstore.bookstore.service.impl.UsersServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Data
@Component
public class BookReservationMapper {
    private final BookServiceImpl bookServiceImpl;
    private final UsersServiceImpl usersServiceImpl;

    public Reservation toEntity(ReservationDto reservationDto) {

        Reservation reservation = new Reservation();
        reservation.setReservedBook(bookServiceImpl.getBookById(reservationDto.getBookId()));
        reservation.setReservedBy(usersServiceImpl.getUserById(reservationDto.getUserId()));
        reservation.setResDeadline(reservationDto.getResDeadline());
        reservation.setReservationDate(reservationDto.getReservationDate());

        return reservation;
    }

    public ReservationDto toDto(Reservation reservation) {

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setBookId(reservation.getReservedBook().getId());
        reservationDto.setUserId(reservation.getReservedBy().getId());
        reservationDto.setResDeadline(reservation.getResDeadline());
        reservationDto.setReservationDate(reservation.getReservationDate());
        return reservationDto;
    }
}
