package com.group.enslibraryapp.controller.user.dto.response;

import com.group.enslibraryapp.controller.user.domain.User;
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
}
