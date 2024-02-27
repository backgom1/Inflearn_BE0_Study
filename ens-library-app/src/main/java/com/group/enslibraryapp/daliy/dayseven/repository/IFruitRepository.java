package com.group.enslibraryapp.daliy.dayseven.repository;

import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitStockRequestDto;

import java.util.List;

public interface IFruitRepository {

    void save(FruitStockRequestDto request);

    void update(FruitSaleRequestDto request);

    List<CalculatorSaleResponseDto> findSumSaleCalculator(String name);

    List<FruitListResponseDto> findByAll();
}
