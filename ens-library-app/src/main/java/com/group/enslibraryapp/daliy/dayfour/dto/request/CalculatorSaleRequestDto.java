package com.group.enslibraryapp.daliy.dayfour.dto.request;

import lombok.Getter;

@Getter
public class CalculatorSaleRequestDto {

    private final String name;

    public CalculatorSaleRequestDto(String name) {
        this.name = name;
    }
}
