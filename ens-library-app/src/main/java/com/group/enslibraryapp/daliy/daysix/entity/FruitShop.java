package com.group.enslibraryapp.daliy.daysix.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class FruitShop {

    private final Long id;
    private final String name;
    private final Long price;
    private final int status;
    private final LocalDate warehousingDate;

    @Builder
    private FruitShop(Long id, String name, Long price, int status, LocalDate warehousingDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.warehousingDate = warehousingDate;
    }
}
