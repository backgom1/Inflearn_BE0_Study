package com.group.enslibraryapp.daliy.daysix.repository;

import com.group.enslibraryapp.daliy.daysix.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.daysix.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.daysix.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.daysix.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.daysix.entity.FruitShop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
@Primary
public class FruitShopMemoryRepository implements IFruitRepository {

    private final List<FruitShop> fruitShop = new ArrayList<>();

    Long seq = 0L; //시퀀스

    public void save(FruitStockRequestDto request) {
        FruitShop saveFruit = FruitShop.builder()
                .id(seq++)
                .name(request.getName())
                .price(request.getPrice())
                .status(0)
                .warehousingDate(LocalDate.now())
                .build();
        fruitShop.add(saveFruit);
    }


    public void update(FruitSaleRequestDto request) {
        FruitShop findFruit = fruitShop.get(Math.toIntExact(request.getId()));
        fruitShop.set(Math.toIntExact(request.getId()), FruitShop.builder()
                .id(request.getId())
                .name(findFruit.getName())
                .price(findFruit.getPrice())
                .status(1)
                .warehousingDate(findFruit.getWarehousingDate())
                .build());
    }


    public List<CalculatorSaleResponseDto> findSumSaleCalculator(String name) {
        long salesAmount = 0L;
        long notSalesAmount = 0L;

        salesAmount =fruitShop.stream()
                .filter(shop -> shop.getName().equals(name))
                .filter((shop) -> shop.getStatus() == 1)
                .mapToInt((shop) -> Math.toIntExact(shop.getPrice()))
                .sum();

        notSalesAmount =fruitShop.stream()
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
        for (FruitShop shop : fruitShop) {
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
