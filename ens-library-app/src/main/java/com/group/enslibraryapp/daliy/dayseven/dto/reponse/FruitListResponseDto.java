package com.group.enslibraryapp.daliy.dayseven.dto.reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class FruitListResponseDto {

    private long id;
    private String name;
    private long price;
    private String status;
    private LocalDate warehousingDate;

    @Builder
    private FruitListResponseDto(long id, String name, long price, int status, LocalDate warehousingDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        if (status == 0) {
            this.status = "판매 중";
        } else {
            this.status = "판매 완료";
        }
        this.warehousingDate = warehousingDate;
    }
}
