package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.ProductDAO;
import org.example.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    @Transactional
    public void saveProduct(){

        for (int i = 0; i < 10; i++) {
            Product product = Product.builder().productId((long) i).name("product-" + i).build();
            productDAO.save(product);

//            if(i==7) throw new RuntimeException("Some Error Occurred"); // if we don,t use @Transactional rest products are not going to inserted.

        }
    }
}
