package com.group.enslibraryapp.learn.controller.example.controller;


import com.group.enslibraryapp.learn.annotation.CustomTimeStamp;
import com.group.enslibraryapp.learn.controller.example.dto.reponse.CalcResponseDto;
import com.group.enslibraryapp.learn.controller.example.dto.reponse.WeekResponseDto;
import com.group.enslibraryapp.learn.controller.example.dto.request.CalcRequestDto;
import com.group.enslibraryapp.learn.controller.example.dto.request.SumOfNumberRequestDto;
import com.group.enslibraryapp.learn.controller.example.dto.request.WeekRequestDto;
import com.group.enslibraryapp.learn.controller.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;


    /**
     * 사칙연산하는 엔드 포인트
     * @param dto number1 , number2
     * @return 합,곱,뺄셈에 대한 값
     */
    @CustomTimeStamp
    @GetMapping("/calc")
    public CalcResponseDto calculators(CalcRequestDto dto){
        return exampleService.performArithmeticOperations(dto);
    }


    /**
     * 년월일을 입력하면 요일로 반환 해주는 엔드 포인트
     * @param dto 요청 받은 년월일 객체 dto
     * @return 대문자인 요일로 반환
     */
    @CustomTimeStamp
    @GetMapping("/day-of-the-week")
    public WeekResponseDto dayOfTheWeek(WeekRequestDto dto){
        return exampleService.findByDayOfTheWeek(dto);
    }


    /**
     * 배열에 대한 합을 구하기 위한 엔드 포인트
     * @param dto 요청된 배열 값
     * @return 배열의 합 반환
     */
    @CustomTimeStamp
    @PostMapping("/numbers")
    public int sumOfNumbers(@RequestBody SumOfNumberRequestDto dto){
        return exampleService.sumOfNumbers(dto);
    }
}
