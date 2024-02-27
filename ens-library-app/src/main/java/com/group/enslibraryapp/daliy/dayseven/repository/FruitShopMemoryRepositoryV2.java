package com.group.enslibraryapp.daliy.dayseven.repository;

import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayseven.entity.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j

public class FruitShopMemoryRepositoryV2 implements IFruitRepository {

    private final List<Fruit> fruit = new ArrayList<>();

    Long seq = 0L; //시퀀스

    public void save(FruitStockRequestDto request) {
//        FruitShop saveFruit = FruitShop.builder()
//                .id(seq++)
//                .name(request.getName())
//                .price(request.getPrice())
//                .status(0)
//                .warehousingDate(LocalDate.now())
//                .build();
//        fruitShop.add(saveFruit);
    }


    public void update(FruitSaleRequestDto request) {
//        FruitShop findFruit = fruitShop.get(Math.toIntExact(request.getId()));
//        fruitShop.set(Math.toIntExact(request.getId()), FruitShop.builder()
//                .id(request.getId())
//                .name(findFruit.getName())
//                .price(findFruit.getPrice())
//                .status(1)
//                .warehousingDate(findFruit.getWarehousingDate())
//                .build());
    }


    public List<CalculatorSaleResponseDto> findSumSaleCalculator(String name) {
        long salesAmount = 0L;
        long notSalesAmount = 0L;

        salesAmount = fruit.stream()
                .filter(shop -> shop.getName().equals(name))
                .filter((shop) -> shop.getStatus() == 1)
                .mapToInt((shop) -> Math.toIntExact(shop.getPrice()))
                .sum();

        notSalesAmount = fruit.stream()
                .filter(shop -> shop.getName().equals(name))
                .filter((shop) -> shop.getStatus() == 0)
                .mapToInt((shop) -> Math.toIntExact(shop.getPrice()))
                .sum();

        List<CalculatorSaleResponseDto> calculatorSaleResponseDto = new ArrayList<>();
        CalculatorSaleResponseDto result = CalculatorSaleResponseDto.builder()
                .salesAmount(salesAmount)
                .notSalesAmount(notSalesAmount)
                .build();
        calculatorSaleResponseDto.add(result);
        return calculatorSaleResponseDto;
    }


    public List<FruitListResponseDto> findByAll() {
        List<FruitListResponseDto> result = new ArrayList<>();
        for (Fruit shop : fruit) {
            FruitListResponseDto responseDto = FruitListResponseDto.builder()
                    .id(shop.getId())
                    .name(shop.getName())
                    .price(shop.getPrice())
                    .status(shop.getStatus())
                    .warehousingDate(shop.getWarehousingDate())
                    .build();
            result.add(responseDto);
        }
        return result;
    }
}
