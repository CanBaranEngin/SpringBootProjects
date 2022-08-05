package com.bookstore.bookstore.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BookTable")
@Data
public class Book extends BaseEntity {
    @Id
    @SequenceGenerator(name = "book_seq_gen",sequenceName = "book_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_seq_gen")
    @Column(name = "ID")
    private Long id;
    @Column(name = "Title",length = 100)
    private String title;
    @Column(name = "PageCount")
    private Long pageCount;
    @Column(name = "GenreID")
    private int genreId;
    @Column(name="Author")
    private String author;
    @Column(name = "PublishDate")
    private Date publishDate;
    @Column(name = "BookReservationTime")
    private int bookResTime;
    @OneToMany
    private List<Reservation> reservations;
}
