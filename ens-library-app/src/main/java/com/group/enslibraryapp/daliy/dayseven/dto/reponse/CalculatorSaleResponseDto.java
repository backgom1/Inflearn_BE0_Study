package com.group.enslibraryapp.daliy.dayseven.dto.reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CalculatorSaleResponseDto {

    private long salesAmount;
    private long notSalesAmount;

    @Builder
    private CalculatorSaleResponseDto(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }
}
