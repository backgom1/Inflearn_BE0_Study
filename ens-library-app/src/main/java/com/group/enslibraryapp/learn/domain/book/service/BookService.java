package com.group.enslibraryapp.learn.domain.book.service;

import com.group.enslibraryapp.learn.domain.book.dto.request.BookLoanRequest;
import com.group.enslibraryapp.learn.domain.book.dto.request.BookReturnRequest;
import com.group.enslibraryapp.learn.domain.book.dto.request.BookSaveRequest;
import com.group.enslibraryapp.learn.domain.book.entity.Book;
import com.group.enslibraryapp.learn.domain.book.repository.BookJpaRepository;
import com.group.enslibraryapp.learn.domain.user.domain.User;
import com.group.enslibraryapp.learn.domain.user.domain.UserLoanHistory;
import com.group.enslibraryapp.learn.domain.user.domain.UserRepository;
import com.group.enslibraryapp.learn.domain.user.repository.UserLoanHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookJpaRepository bookJpaRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveBook(BookSaveRequest request) {
        bookJpaRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        //1. 책정보를 가져온다.
        Book book = bookJpaRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        //2. 대출기록 정보를 확인해서 대출중인지 확인
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            //3. 만약 확인했는데 대출중이라면 예외 처리
            throw new IllegalArgumentException("현재 대출 중인 책입니다.");
        }

        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);

        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);

        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        userLoanHistory.doReturn(); //반납 처리, 변경 감지로 인해 알아서 업데이트처리
    }
}
