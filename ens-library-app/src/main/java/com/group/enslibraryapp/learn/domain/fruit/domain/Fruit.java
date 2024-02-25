package com.group.enslibraryapp.learn.domain.fruit.domain;

import lombok.Getter;

@Getter
public class Fruit {

    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
