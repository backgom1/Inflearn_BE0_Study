package com.group.enslibraryapp.learn.domain.user.repository;

import com.group.enslibraryapp.learn.domain.user.domain.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
