package com.group.enslibraryapp.controller.calculator;


import com.group.enslibraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 클래스를 API 진입지점으로 만들어주는 컨트롤러
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1()+request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorAddRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
