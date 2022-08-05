package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

}
