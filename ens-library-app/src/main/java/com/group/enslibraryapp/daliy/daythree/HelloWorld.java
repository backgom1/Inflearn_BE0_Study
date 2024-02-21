package com.group.enslibraryapp.daliy.daythree;

import java.util.Arrays;
import java.util.List;

public class HelloWorld {

    public String helloWorld(){
        return "헬로 월드!";
    }
}

class VirtualHelloWorld extends HelloWorld {
    @Override
    public String helloWorld() {
        return "가상 세계 오신걸 환영합니다.";
    }
}

class Main {
    public static void main(String[] args) {
        List<String> food = Arrays.asList("사과", "피자", "초콜릿", "딸기");
        food.stream().forEach(item ->System.out.println(item));
//        HelloWorld helloWorld = () -> "헬로 월드";

//        String s = helloWorld.helloWorld();
//        helloWorld.virtualWorld();

//        System.out.println("s = " + s);
    }
}
