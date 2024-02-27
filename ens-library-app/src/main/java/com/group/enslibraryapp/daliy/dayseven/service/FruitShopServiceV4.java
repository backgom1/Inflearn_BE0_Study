package com.group.enslibraryapp.daliy.dayseven.service;

import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CountNameResponse;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.dayseven.dto.reponse.LargeSmallComparisonResponse;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayseven.dto.request.LargeSmallComparisonRequest;
import com.group.enslibraryapp.daliy.dayseven.entity.Fruit;
import com.group.enslibraryapp.daliy.dayseven.repository.FruitShopJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JPA 서비스 클래스입니다.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class FruitShopServiceV4 {

    private final FruitShopJpaRepository fruitShopJpaRepository;

    /**
     * 제고를 입고하기 위한 서비스 로직입니다.
     */
    public void warehousingFruit(FruitStockRequestDto request) {
        //추후에 예외 처리를 넣을곳
        saveValidation(request);
        Fruit fruit = Fruit.builder()
                .name(request.getName())
                .status(0)
                .price(request.getPrice())
                .warehousingDate(request.getWarehousingDate()).build();
        fruitShopJpaRepository.save(fruit);

        log.info("과일 입고 성공!!");
    }

    /**
     * 저장을 하기 위한 전 단계에 대한 예외 처리입니다.
     *
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
        Fruit fruit = fruitShopJpaRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        Fruit updateFruit = Fruit.builder()
                .name(fruit.getName())
                .status(1)
                .price(fruit.getPrice())
                .warehousingDate(fruit.getWarehousingDate()).build();
        fruitShopJpaRepository.save(updateFruit);
        log.info("과일 판매 성공!!");
    }

    /**
     * name값을 이용하여 계산된 과일과 계산이 되지않는 과일을 찾아내는 서비스 로직입니다.
     *
     * @param name
     * @return
     */
    public List<CalculatorSaleResponseDto> calculatorSale(String name) {
        saleValidation(name);
        return fruitShopJpaRepository.findSumSaleCalculator(name);
    }

    /**
     * name값을 이용하여 계산된 과일과 계산이 되지않는 과일을 찾기전 유효성 검사로직입니다.
     *
     * @param name 검증받을 String값
     */
    private void saleValidation(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name은 공백이 될수 없습니다.");
        }

        if (name.matches(".*" + "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+" + ".*")) {
            throw new IllegalArgumentException("이름에 특수문자 포함해 검색할 수 없습니다.");
        }
    }


    public List<FruitListResponseDto> findAll() {
        return fruitShopJpaRepository.findAll().stream()
                .map((data) -> FruitListResponseDto.builder()
                        .id(data.getId())
                        .name(data.getName())
                        .price(data.getPrice())
                        .status(data.getStatus())
                        .warehousingDate(data.getWarehousingDate())
                        .build()).collect(Collectors.toList());
    }

    /**
     * name값을 기준으로 count조회 메서드
     *
     * @param name 원하는 과일 이름
     * @return 총 name count
     */
    public CountNameResponse countNameResponse(String name) {
        return new CountNameResponse(fruitShopJpaRepository.countByName(name));
    }

    public List<LargeSmallComparisonResponse> largeSmallComparison(LargeSmallComparisonRequest request) {
        validation(request);
        return getLargeSmallComparisonResponses(request);
    }

    /**
     * option값에 따른 가격 비교하는 로직
     * @param request 옵션값, 가격
     * @return 반환된 과일
     */
    private List<LargeSmallComparisonResponse> getLargeSmallComparisonResponses(LargeSmallComparisonRequest request) {
        if (request.getOption().equals("GTE")) {
            return fruitShopJpaRepository.findByPriceGreaterThanEqual(request.getPrice())
                    .stream()
                    .map(fruit -> LargeSmallComparisonResponse.builder()
                            .name(fruit.getName())
                            .price(fruit.getPrice())
                            .warehousingDate(fruit.getWarehousingDate())
                            .build())
                    .collect(Collectors.toList());
        } else {
            return fruitShopJpaRepository.findByPriceLessThanEqual(request.getPrice())
                    .stream()
                    .map(fruit -> LargeSmallComparisonResponse.builder()
                            .name(fruit.getName())
                            .price(fruit.getPrice())
                            .warehousingDate(fruit.getWarehousingDate())
                            .build())
                    .collect(Collectors.toList());
        }
    }

    private void validation(LargeSmallComparisonRequest request) {
        if (request.getPrice() < 0) {
            throw new IllegalArgumentException("올바르지 않은 가격입니다.");
        }
    }
}
