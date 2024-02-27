package com.group.enslibraryapp.learn.domain.user.service;

import com.group.enslibraryapp.learn.domain.fruit.service.IFruitService;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.response.UserResponseDto;
import com.group.enslibraryapp.learn.domain.user.repository.UserJdbcRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;
    private final IFruitService fruitService;

    public UserServiceV1(UserJdbcRepository userJdbcRepository, @Qualifier("main") IFruitService fruitService) {
        this.userJdbcRepository = userJdbcRepository;
        this.fruitService = fruitService;
    }

    public List<UserResponseDto> getUsers() {
       return userJdbcRepository.getUserV1();
    }
    public void updateUser(UserUpdateRequestDto request) {

        if (userJdbcRepository.isUserNotExist(request)) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserV1(request);

    }


    public void deleteUser(String name) {
        if (userJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUserV1(name);
    }

    public void save(UserCreateRequestDto request) {
        userJdbcRepository.saveV1(request);
    }
}
