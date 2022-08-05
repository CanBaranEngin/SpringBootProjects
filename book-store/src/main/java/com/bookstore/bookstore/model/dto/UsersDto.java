package com.bookstore.bookstore.model.dto;
import lombok.Data;

@Data
public class UsersDto {
    private String firstName;
    private String lastName;
    private int age;
    private String password;
}
