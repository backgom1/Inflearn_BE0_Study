package com.group.enslibraryapp.daliy.dayfour.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FruitStockRequestDto {

    private String name;
    private LocalDate warehousingDate;
    private Long price;
}
