package com.group.enslibraryapp.daliy.dayseven.dto.request;

import lombok.Getter;

@Getter
public class CalculatorSaleRequestDto {

    private final String name;

    public CalculatorSaleRequestDto(String name) {
        this.name = name;
    }
}
