package com.group.enslibraryapp.learn.domain.user.controller;

import com.group.enslibraryapp.learn.domain.fruit.domain.Fruit;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.response.UserResponseDto;
import com.group.enslibraryapp.learn.domain.user.service.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserServiceV2 userService;

    @GetMapping("/user")
    public List<UserResponseDto> getUsers() {
       return userService.getUsers();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequestDto request) {
       userService.saveUser(request);
    }

    @GetMapping("/fruit")
    public Fruit findAllFruit() {
        return new Fruit("키위", 2000);
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequestDto request) throws IllegalAccessException {
        userService.updateUser(request);
    }


    @DeleteMapping("/user")
    public void deleteUser(@RequestParam("name") String name) {
        userService.deleteUser(name);
    }

}
