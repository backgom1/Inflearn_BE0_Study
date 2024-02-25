package com.group.enslibraryapp.learn.domain.example.dto.reponse;

import lombok.Builder;
import lombok.Getter;

/**
 * 요일을 구하는 반환 객체입니다.
 */
@Getter
public class WeekResponseDto {
    //문제 2번에 대한 필드명
    private final String dayOfTheWeek;

    @Builder
    private WeekResponseDto(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
