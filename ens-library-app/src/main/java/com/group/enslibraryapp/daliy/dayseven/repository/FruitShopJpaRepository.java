package com.group.enslibraryapp.daliy.dayseven.repository;

import com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayseven.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitShopJpaRepository extends JpaRepository<Fruit, Long> {


    @Query("select new com.group.enslibraryapp.daliy.dayseven.dto.reponse.CalculatorSaleResponseDto( " +
            "(select sum(f.price) from Fruit f where f.status = 0 and f.name = :name) ," +
            "(select sum(f.price) from Fruit f where f.status = 1 and f.name = :name)) " +
            "from Fruit f where f.name = :name group by f.name")
    List<CalculatorSaleResponseDto> findSumSaleCalculator(@Param("name") String name);

    long countByName(String name);

    List<Fruit> findByPriceGreaterThanEqual(long price);
    List<Fruit> findByPriceLessThanEqual(long price);
}
