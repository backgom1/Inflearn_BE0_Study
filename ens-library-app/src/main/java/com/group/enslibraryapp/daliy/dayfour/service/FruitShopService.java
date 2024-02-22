package com.group.enslibraryapp.daliy.dayfour.service;

import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayfour.repository.FruitShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FruitShopService {

    private final FruitShopRepository fruitShopRepository;

    /**
     * 제고를 입고하기 위한 서비스 로직입니다.
     */
    public void warehousingFruit(FruitStockRequestDto request){
        fruitShopRepository.save(request);
        log.info("과일 입고 성공!!");
    }
    public void fruitSale(FruitSaleRequestDto request){
        fruitShopRepository.update(request);
        log.info("과일 판매 성공!!");
    }

}
