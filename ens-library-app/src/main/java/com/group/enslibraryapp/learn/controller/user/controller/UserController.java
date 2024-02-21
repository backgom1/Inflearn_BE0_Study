package com.group.enslibraryapp.learn.controller.user.controller;

import com.group.enslibraryapp.learn.controller.user.domain.Fruit;
import com.group.enslibraryapp.learn.controller.user.domain.User;
import com.group.enslibraryapp.learn.controller.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.controller.user.dto.response.UserResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/user")
    public List<UserResponseDto> getUsers() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponseDto>() {
            @Override
            public UserResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponseDto(id,name,age);
            }
        });
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequestDto request) {
        String sql = "insert into user (name,age) values (?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }


    @GetMapping("/fruit")
    public Fruit findAllFruit() {
        return new Fruit("키위", 2000);
    }
}
