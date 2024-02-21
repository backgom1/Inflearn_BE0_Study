package com.group.enslibraryapp.learn.controller.user.dto.request;


import lombok.Getter;

@Getter
public class UserCreateRequestDto {

    private String name;
    private Integer age;  //자료형입니다 null을 표현하는 자료형
}
