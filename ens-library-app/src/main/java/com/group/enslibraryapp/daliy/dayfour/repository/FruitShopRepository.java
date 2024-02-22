package com.group.enslibraryapp.daliy.dayfour.repository;

import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitStockRequestDto;
import com.group.enslibraryapp.daliy.dayfour.enums.SaleStatusEnum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.group.enslibraryapp.daliy.dayfour.enums.SaleStatusEnum.NOT_SALE;
import static com.group.enslibraryapp.daliy.dayfour.enums.SaleStatusEnum.SALE;

@Repository
public class FruitShopRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitShopRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(FruitStockRequestDto request){
        String sql = "insert into fruit (name,price,status,ware_housing_date) values (?,?,?,?)";
        jdbcTemplate.update(sql,request.getName(),request.getPrice(), NOT_SALE.getStatus(),request.getWarehousingDate());
    }

    public void update(FruitSaleRequestDto request){
        String sql = "update fruit set status = ? where id = ?";
        jdbcTemplate.update(sql,SALE.getStatus(),request.getId());
    }
}
