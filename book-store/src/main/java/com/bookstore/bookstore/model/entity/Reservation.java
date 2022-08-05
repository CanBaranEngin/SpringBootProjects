package com.bookstore.bookstore.model.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ReservationTable")
@Data
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reserved_book_ıd",referencedColumnName = "ID")
    private Book reservedBook;
    @ManyToOne
    @JoinColumn(name = "reserved_by_ıd",referencedColumnName = "ID")
    private Users reservedBy;
    @Column(name = "ReservationDate")
    private String reservationDate;
    @Column(name = "ReservationDeadline")
    private String resDeadline;
}
