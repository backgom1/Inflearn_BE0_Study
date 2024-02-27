package com.group.enslibraryapp.learn.domain.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findById(Long aLong);

    Optional<User> findByName(String name);

    boolean existsByName(String name);

    long countByAge(Integer age);
}
