package com.group.enslibraryapp.controller.calculator;

import com.group.enslibraryapp.annotation.CustomTimeStamp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TimeStampController {

    @CustomTimeStamp
    @GetMapping("/annoStamp")
    public String annotationStamp(){
        log.info("어노테이션 시작!");
        return "성공!";
    }
}
