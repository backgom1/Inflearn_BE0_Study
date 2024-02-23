package com.group.enslibraryapp.learn.controller.user.service;

import com.group.enslibraryapp.learn.controller.user.domain.User;
import com.group.enslibraryapp.learn.controller.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.controller.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

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
}
