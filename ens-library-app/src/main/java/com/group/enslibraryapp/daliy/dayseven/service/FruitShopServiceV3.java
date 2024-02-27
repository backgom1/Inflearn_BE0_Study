package com.group.enslibraryapp.daliy.dayseven.service;

import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayseven.repository.IFruitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FruitShopServiceV3 {

    private final IFruitRepository fruitShopRepository;

    /**
     * 제고를 입고하기 위한 서비스 로직입니다.
     */
    public void warehousingFruit(FruitStockRequestDto request) {
        //추후에 예외 처리를 넣을곳
        saveValidation(request);
        fruitShopRepository.save(request);

        log.info("과일 입고 성공!!");
    }

    /**
     * 저장을 하기 위한 전 단계에 대한 예외 처리입니다.
     * @param request
     */
    private void saveValidation(FruitStockRequestDto request) {
        if (request.getName() == null) {
            throw new IllegalArgumentException("과일 이름이 존재하지 않습니다.");
        }

        if (request.getPrice() == null) {
            throw new IllegalArgumentException("과일 이름이 가격이 존재하지 않습니다.");
        }
    }


    /**
     * 과일 판매를 위한 서비스 로직
     *
     * @param request 판매에 필요한 id값
     */
    public void fruitSale(FruitSaleRequestDto request) {
        if (request.getId() == null) {
            throw new IllegalArgumentException("id가 존재하지 않습니다. 다시 확인해주세요.");
        }
        fruitShopRepository.update(request);
        log.info("과일 판매 성공!!");
    }

    /**
     * name값을 이용하여 계산된 과일과 계산이 되지않는 과일을 찾아내는 서비스 로직입니다.
     * @param name
     * @return
     */
    public List<CalculatorSaleResponseDto> calculatorSale(String name) {
        saleValidation(name);
        return fruitShopRepository.findSumSaleCalculator(name);
    }

    /**
     * name값을 이용하여 계산된 과일과 계산이 되지않는 과일을 찾기전 유효성 검사로직입니다.
     * @param name 검증받을 String값
     */
    private void saleValidation(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("name은 공백이 될수 없습니다.");
        }

        if(name.matches(".*"+"[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+"+".*")){
            throw new IllegalArgumentException("이름에 특수문자 포함해 검색할 수 없습니다.");
        }
    }


    public List<FruitListResponseDto> findAll() {
        return fruitShopRepository.findByAll();
    }

}
