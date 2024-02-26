package com.group.enslibraryapp.daliy.daysix.repository;

import com.group.enslibraryapp.daliy.daysix.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.daysix.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.daysix.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.daysix.dto.request.FruitStockRequestDto;

import java.util.List;

public interface IFruitRepository {

    void save(FruitStockRequestDto request);

    void update(FruitSaleRequestDto request);

    List<CalculatorSaleResponseDto> findSumSaleCalculator(String name);

    List<FruitListResponseDto> findByAll();
}
