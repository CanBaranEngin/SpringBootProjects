package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.model.dto.ReservationDto;
import com.bookstore.bookstore.model.entity.Reservation;
import com.bookstore.bookstore.model.maper.BookReservationMapper;
import com.bookstore.bookstore.repository.ReservationRepository;
import com.bookstore.bookstore.service.ReservationService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Data
public class ReservationServiceImpl implements ReservationService {

    private final BookReservationMapper bookReservationMapper;
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    public ReservationServiceImpl(BookReservationMapper bookReservationMapper, ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.bookReservationMapper = bookReservationMapper;
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Reservation createReservation(ReservationDto reservationDto) {

        Reservation reservation = bookReservationMapper.toEntity(reservationDto);

        return reservationRepository.save(reservation);

    }
}
