package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {


}
