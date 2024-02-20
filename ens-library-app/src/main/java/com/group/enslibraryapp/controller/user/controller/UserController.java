package com.group.enslibraryapp.controller.user.controller;

import com.group.enslibraryapp.controller.user.domain.Fruit;
import com.group.enslibraryapp.controller.user.domain.User;
import com.group.enslibraryapp.controller.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.controller.user.dto.response.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @GetMapping("/user")
    public List<UserResponseDto> getUsers() {
        List<UserResponseDto> responses = new ArrayList<>();
        for (int i = 0; i<users.size(); i++) {
            responses.add(new UserResponseDto(i+1L, users.get(i)));
        }
        return responses;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequestDto request) {
        users.add(new User(request.getName(), request.getAge()));
    }



    @GetMapping("/fruit")
    public Fruit findAllFruit() {
        return new Fruit("키위",2000);
    }
}
