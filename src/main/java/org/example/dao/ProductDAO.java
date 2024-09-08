package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final JdbcTemplate jdbcTemplate;

    public void save(Product product){
        String insertSql = "INSERT INTO PRODUCTS VALUES (?, ?)";
        Object[] args = {product.getProductId(), product.getName()};

        jdbcTemplate.update(insertSql, args);
    }
}
