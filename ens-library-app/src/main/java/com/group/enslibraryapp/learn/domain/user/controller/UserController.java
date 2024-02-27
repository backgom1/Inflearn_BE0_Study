package com.group.enslibraryapp.learn.domain.user.controller;

import com.group.enslibraryapp.learn.domain.fruit.domain.Fruit;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.response.UserResponseDto;
import com.group.enslibraryapp.learn.domain.user.service.UserServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserServiceV1 userServiceV1;

    @GetMapping("/user")
    public List<UserResponseDto> getUsers() {
       return userServiceV1.getUsers();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequestDto request) {
       userServiceV1.save(request);
    }

    @GetMapping("/fruit")
    public Fruit findAllFruit() {
        return new Fruit("키위", 2000);
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequestDto request) {
        userServiceV1.updateUser(request);
    }


    @DeleteMapping("/user")
    public void deleteUser(@RequestParam("name") String name) {
        userServiceV1.deleteUser(name);
    }

}
