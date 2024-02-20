package com.group.enslibraryapp.controller.example.service;

import com.group.enslibraryapp.controller.example.dto.reponse.WeekResponseDto;
import com.group.enslibraryapp.controller.example.dto.request.CalcRequestDto;
import com.group.enslibraryapp.controller.example.dto.reponse.CalcResponseDto;
import com.group.enslibraryapp.controller.example.dto.request.SumOfNumberRequestDto;
import com.group.enslibraryapp.controller.example.dto.request.WeekRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
@Slf4j
public class ExampleService {

    /**
     * 사칙연산을 만들어주는 서비스 로직입니다.
     *
     * @param dto 사칙연산을 위한 입력 객체
     * @return 뎃셈, 곱셈, 뺄셈의 반환을 객체로 합니다.
     */
    public CalcResponseDto performArithmeticOperations(CalcRequestDto dto) {
        CalcResponseDto result = CalcResponseDto.builder()
                .targetNumbers(dto)
                .build();

        log.info("결과 ! : {} ,{} ,{}", result.getAdd(), result.getMinus(), result.getMultiply());

        return result;
    }

    /**
     * 요일을 구하는 서비스 로직입니다.
     *
     * @param dto 요청한 년월일에 대한 값
     * @return 요일 반환
     */
    public WeekResponseDto findByDayOfTheWeek(WeekRequestDto dto) {
        String[] split = dto.getDate().split("-");
//        LocalDate localDate1 = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])); // 문자열을 파싱하여서 직접 넣어주는 방법
        LocalDate localDate2 = LocalDate.parse(dto.getDate()); // 년월일인 String 자료형을 파싱하여 넣어주는 방법
        String dayName = localDate2.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();

        log.info("{}의 해당 요일은 ? : {}", dto.getDate(), dayName);

        return WeekResponseDto.builder().dayOfTheWeek(dayName).build();
    }

    /**
     * 정수형 List 배열 요청에 대한 합을 구하는 서비스 로직입니다.
     *
     * @param dto 정수형 List 배열
     * @return List에 대한 합 반환
     */
    public int sumOfNumbers(SumOfNumberRequestDto dto) {

        int result = 0;

//        int result = dto.getNumbers().stream()
//                .mapToInt(Integer::intValue)
//                .sum();

        for (int number : dto.getNumbers()) {
            result += number;
        }
        log.info("총 합 : {}", result);
        return result;
    }
}
