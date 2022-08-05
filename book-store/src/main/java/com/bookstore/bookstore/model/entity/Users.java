package com.bookstore.bookstore.model.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UserTable")
@Data
public class Users extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;
        @Column(name = "FirstName",length = 100)
        private String firstName;
        @Column(name = "lastName",length = 100)
        private String lastName;
        @Column(name = "Password",length = 100)
        private String password;
        @Column(name = "Age")
        private int age;
        @OneToMany
        private List<Reservation> reservations;
}
