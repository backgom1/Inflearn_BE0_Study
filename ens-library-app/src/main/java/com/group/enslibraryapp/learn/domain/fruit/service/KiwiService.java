package com.group.enslibraryapp.learn.domain.fruit.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("main")
public class KiwiService implements IFruitService {
}
