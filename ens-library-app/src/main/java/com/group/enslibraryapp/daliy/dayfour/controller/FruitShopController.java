package com.group.enslibraryapp.daliy.dayfour.controller;

import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayfour.service.FruitShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class FruitShopController {

    private final FruitShopService fruitShopService;

    /**
     * 과일을 입고(생성) 하는 컨트롤러입니다.
     * @param request 입력받은 과일 정보의 값
     */
    @PostMapping("/fruit")
    public void stockInFruit(@RequestBody FruitStockRequestDto request){
        fruitShopService.warehousingFruit(request);
    }

    /**
     * 과일이 판매를 위한 컨트롤러 입니다.
     * @param request 과일 판매를 위한 id값
     */
    @PutMapping("/fruit")
    public void fruitSaleProgress(@RequestBody FruitSaleRequestDto request){
        fruitShopService.fruitSale(request);
    }

    @GetMapping("/fruit/stat")
}
