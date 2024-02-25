package com.group.enslibraryapp.daliy.dayfour.repository;

import com.group.enslibraryapp.daliy.dayfour.dto.reponse.CalculatorSaleResponseDto;
import com.group.enslibraryapp.daliy.dayfour.dto.reponse.FruitListResponseDto;
import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitSaleRequestDto;
import com.group.enslibraryapp.daliy.dayfour.dto.request.FruitStockRequestDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.group.enslibraryapp.daliy.dayfour.enums.SaleStatusEnum.NOT_SALE;
import static com.group.enslibraryapp.daliy.dayfour.enums.SaleStatusEnum.SALE;

@Repository
public class FruitShopRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitShopRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(FruitStockRequestDto request) {
        String sql = "insert into fruit (name,price,status,ware_housing_date) values (?,?,?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getPrice(), NOT_SALE.getStatus(), request.getWarehousingDate());
    }

    public void update(FruitSaleRequestDto request) {
        String sql = "update fruit set status = ? where id = ?";
        jdbcTemplate.update(sql, SALE.getStatus(), request.getId());
    }

    public List<CalculatorSaleResponseDto> findSumSaleCalculator(String name) {
        String sql = "select \n" +
                "(select sum(price) from fruit where status = 0 and name = ?) as salesAmount, \n" +
                "(select sum(price) from fruit where status = 1 and name = ?) as notSalesAmount\n" +
                "from fruit\n" +
                "group by salesAmount,notSalesAmount";
        return jdbcTemplate.query(sql,new String[]{name,name}, (rs, rowNum) -> {
            long salesAmount = rs.getLong("salesAmount");
            long notSalesAmount = rs.getLong("notSalesAmount");
            return CalculatorSaleResponseDto.builder()
                    .salesAmount(salesAmount)
                    .notSalesAmount(notSalesAmount)
                    .build();
        });

    }

    public List<FruitListResponseDto> findByAll() {
        String sql = "select * from fruit";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            long price = rs.getLong("price");
            String name = rs.getString("name");
            int status = rs.getInt("status");
            LocalDate wareHousingDate = rs.getDate("ware_housing_date").toLocalDate();
            return FruitListResponseDto.builder()
                    .id(id)
                    .name(name)
                    .price(price)
                    .status(status)
                    .warehousingDate(wareHousingDate)
                    .build();
        });
    }
}
