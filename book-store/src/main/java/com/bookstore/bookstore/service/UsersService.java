package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.dto.UsersDto;
import com.bookstore.bookstore.model.entity.Users;

import java.util.List;

public interface UsersService {
    UsersDto createUsers(UsersDto user);
    List<UsersDto> getUsers();
    Users getUserById(Long id);
    UsersDto updateUser(Long id, UsersDto user);
    Boolean deleteUser(Long id);
}
