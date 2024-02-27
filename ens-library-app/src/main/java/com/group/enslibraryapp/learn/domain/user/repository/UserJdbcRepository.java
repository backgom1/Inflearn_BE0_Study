package com.group.enslibraryapp.learn.domain.user.repository;


import com.group.enslibraryapp.learn.domain.user.dto.request.UserCreateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.request.UserUpdateRequestDto;
import com.group.enslibraryapp.learn.domain.user.dto.response.UserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(UserUpdateRequestDto request){
        String readSql = "select * from user where id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0,request.getId()).isEmpty();
    }

    public boolean isUserNotExist(String name){
        String readSql = "select * from user where id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0,name).isEmpty();
    }

    public void updateUserV1(UserUpdateRequestDto request) {
        String sql = "UPDATE user SET name = ? where id= ?";
        jdbcTemplate.update(sql, request.getName(),request.getId());

    }

    public void deleteUserV1(String name){
        String sql = "DELETE FROM user WHERE name =?";
        jdbcTemplate.update(sql, name);
    }

    public List<UserResponseDto> getUserV1() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponseDto(id, name, age);
        });
    }

    public void saveV1(UserCreateRequestDto request) {
        String sql = "insert into user (name,age) values (?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }
}
