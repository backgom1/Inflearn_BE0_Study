package com.group.enslibraryapp.learn.domain.user.dto.response;

import com.group.enslibraryapp.learn.domain.user.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;
    private final String name;
    private final Integer age;

    public UserResponseDto(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
