package com.group.enslibraryapp.learn.controller.user.repository;


import com.group.enslibraryapp.learn.controller.user.dto.request.UserUpdateRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    public UserRepository(JdbcTemplate jdbcTemplate) {
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

    public void updateUser(UserUpdateRequestDto request) {
        String sql = "UPDATE user SET name = ? where id= ?";
        jdbcTemplate.update(sql, request.getName(),request.getId());

    }

    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name =?";
        jdbcTemplate.update(sql, name);
    }

}
