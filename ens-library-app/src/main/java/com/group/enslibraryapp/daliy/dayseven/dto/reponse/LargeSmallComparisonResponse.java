package com.group.enslibraryapp.daliy.dayseven.dto.reponse;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class LargeSmallComparisonResponse {

    private String name;
    private long price;
    private LocalDate warehousingDate;

    @Builder
    private LargeSmallComparisonResponse(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }
}
