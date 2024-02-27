package com.group.enslibraryapp.daliy.dayseven.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column
    private Long price;

    @Column
    private int status;

    @Column(name = "ware_housing_date")
    private LocalDate warehousingDate;

    @Builder
    private Fruit(String name, Long price, int status, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.warehousingDate = warehousingDate;
    }
}
