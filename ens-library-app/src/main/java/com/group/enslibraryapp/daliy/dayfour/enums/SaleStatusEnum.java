package com.group.enslibraryapp.daliy.dayfour.enums;

import lombok.Getter;

@Getter
public enum SaleStatusEnum {
    NOT_SALE(0),
    SALE(1);
    private int status;

    SaleStatusEnum(int status) {
        this.status = status;
    }
}
