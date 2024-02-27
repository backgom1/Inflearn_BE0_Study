package com.group.enslibraryapp.daliy.dayseven.dto.reponse;

import lombok.Getter;

@Getter
public class CountNameResponse {

    private long count;

    public CountNameResponse(long count) {
        this.count = count;
    }
}
