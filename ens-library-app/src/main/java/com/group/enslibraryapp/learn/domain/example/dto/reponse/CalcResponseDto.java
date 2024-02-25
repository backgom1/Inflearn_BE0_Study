package com.group.enslibraryapp.learn.domain.example.dto.reponse;


import com.group.enslibraryapp.learn.domain.example.dto.request.CalcRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CalcResponseDto {

    //문제 1번에 대한 필드 명
    private int add;
    private int minus;
    private int multiply;


    @Builder
    private CalcResponseDto(CalcRequestDto targetNumbers) {
        this.add = targetNumbers.getNum1() + targetNumbers.getNum2();
        this.minus = targetNumbers.getNum1() - targetNumbers.getNum2();
        this.multiply = targetNumbers.getNum1() * targetNumbers.getNum2();
    }

}
