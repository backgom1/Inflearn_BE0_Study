package com.group.enslibraryapp.learn.controller.user.dto.response;

import com.group.enslibraryapp.learn.controller.user.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private Integer age;

    public UserResponseDto(Long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public UserResponseDto(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
