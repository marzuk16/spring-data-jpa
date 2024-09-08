package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.ProductDAO;
import org.example.entity.Product;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    public void saveProduct(){

        for (int i = 0; i < 10; i++) {
            Product product = Product.builder().productId((long) i).name("product-" + i).build();
            productDAO.save(product);
        }
    }
}
