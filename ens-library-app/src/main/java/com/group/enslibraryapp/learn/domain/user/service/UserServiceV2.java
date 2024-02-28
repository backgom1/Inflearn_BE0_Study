package com.group.enslibraryapp.learn.domain.user.service;

import com.group.enslibraryapp.learn.domain.fruit.service.IFruitService;
import com.group.enslibraryapp.learn.domain.user.domain.User;
import com.group.enslibraryapp.learn.domain.user.domain.UserRepository;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.response.UserResponseDto;
import com.group.enslibraryapp.learn.domain.user.repository.UserJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceV2 {

    private final UserRepository userRepository;


    //어노테이션을 달면 메서드 시작 아래에서 트랜잭션 지작
    //함수가 예외없이 잘끝나면 commit
    //아니면 rollback;
    @Transactional
    public void saveUser(UserCreateRequestDto request) {
        userRepository.save(new User(request.getName(), request.getAge()));
        throw new IllegalArgumentException("틀림");
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponseDto(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequestDto request) throws IllegalAccessException {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessException::new);

        user.updateName(request.getName());
        userRepository.save(user);
    }

    public void deleteUser(String name) {
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);

    }
}
