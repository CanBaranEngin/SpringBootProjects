package com.bookstore.bookstore.api;

import com.bookstore.bookstore.model.dto.UsersDto;
import com.bookstore.bookstore.model.entity.Users;
import com.bookstore.bookstore.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public ResponseEntity<UsersDto> createUsers(@RequestBody UsersDto user){
        UsersDto createduser = usersService.createUsers(user);
        return ResponseEntity.ok(createduser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UsersDto>> getUsers(){
        List<UsersDto> users=usersService.getUsers();
        return ResponseEntity.ok(users);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Users> getByIdUser(@PathVariable ("id") Long id){
        Users getUser=usersService.getUserById(id);
        return ResponseEntity.ok(getUser);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable ("id") Long id,@RequestBody UsersDto user){
        UsersDto updatedUser=usersService.updateUser(id,user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser (@PathVariable("id") Long id){
        Boolean status = usersService.deleteUser(id);
        return ResponseEntity.ok(status);

    }
}
