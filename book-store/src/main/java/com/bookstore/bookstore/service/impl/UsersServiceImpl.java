package com.bookstore.bookstore.service.impl;
import com.bookstore.bookstore.model.dto.UsersDto;
import com.bookstore.bookstore.model.entity.Book;
import com.bookstore.bookstore.model.entity.Users;
import com.bookstore.bookstore.repository.UsersRepository;
import com.bookstore.bookstore.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private  final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Override
    public UsersDto createUsers(UsersDto userDto){
        Users user = modelMapper.map(userDto, Users.class);
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(usersRepository.save(user), UsersDto.class);
    }


    @Override
    public List<UsersDto> getUsers(){
        List<Users> users =usersRepository.findAll();
        List<UsersDto> userDto = users.stream().map(user -> modelMapper.map(user,UsersDto.class)).collect(Collectors.toList());
        return userDto;
    }

    @Override
    public Users getUserById(Long id){
        Optional<Users> user = usersRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException());

    }

    @Override
    public UsersDto updateUser(Long id,UsersDto user){
        Optional<Users> resultUser = usersRepository.findById(id);

        if(resultUser.isPresent()){
            if(user.getAge()!=0){
                resultUser.get().setAge(user.getAge());
            }
            if(user.getFirstName()!=null){
                resultUser.get().setFirstName(user.getFirstName());
            }
            if(user.getLastName()!=null){
                resultUser.get().setLastName(user.getLastName());
            }
            if(user.getPassword()!=null){
                resultUser.get().setPassword(user.getPassword());
            }
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdatedBy("Admin");
            return modelMapper.map(usersRepository.save(resultUser.get()),UsersDto.class);
        }
        return null;

    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<Users> user = usersRepository.findById(id);

        if(user.isPresent()){
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }




}