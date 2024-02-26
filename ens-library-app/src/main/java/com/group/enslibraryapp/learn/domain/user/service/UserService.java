package com.group.enslibraryapp.learn.domain.user.service;

import com.group.enslibraryapp.learn.domain.fruit.service.IFruitService;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.response.UserResponseDto;
import com.group.enslibraryapp.learn.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final IFruitService fruitService;

    public UserService(UserRepository userRepository,@Qualifier("main") IFruitService fruitService) {
        this.userRepository = userRepository;
        this.fruitService = fruitService;
    }

    public List<UserResponseDto> getUsers() {
       return userRepository.getUser();
    }
    public void updateUser(UserUpdateRequestDto request) {

        if (userRepository.isUserNotExist(request)) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUser(request);

    }


    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

    public void save(UserCreateRequestDto request) {
        userRepository.save(request);
    }
}
