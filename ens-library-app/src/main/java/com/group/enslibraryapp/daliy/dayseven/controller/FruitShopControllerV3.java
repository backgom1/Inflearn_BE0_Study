package com.group.enslibraryapp.daliy.dayseven.controller;

import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CountNameResponse;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.LargeSmallComparisonResponse;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.LargeSmallComparisonRequest;
import com.group.enslibraryapp.daliy.dayseven.service.FruitShopServiceV4;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v3")
public class FruitShopControllerV3 {

    private final FruitShopServiceV4 fruitShopService;

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

    /**
     * 과일에 대한 판매 및 미 판매에 대한 조회 결과를 나타냅니다.
     * @return
     */
    @GetMapping("/fruit/stat")
    public List<CalculatorSaleResponseDto> notSaleAndSaleSumAmount(@RequestParam("name") String name){
       return fruitShopService.calculatorSale(name);
    }

    /**
     * 과일에 대한 전체 조회 결과를 나타냅니다.
     * @return
     */
    @GetMapping("/fruits")
    public List<FruitListResponseDto> fruitList(){
        return fruitShopService.findAll();
    }

    @GetMapping("/fruit/count")
    public CountNameResponse countNameResponse(@RequestParam("name") String name){
       return fruitShopService.countNameResponse(name);
    }

    @GetMapping("/fruit/list")
    public List<LargeSmallComparisonResponse> largeSmallComparison(LargeSmallComparisonRequest request){
        return fruitShopService.largeSmallComparison(request);
    }
}
