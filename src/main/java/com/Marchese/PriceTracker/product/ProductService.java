package com.Marchese.PriceTracker.product;

import com.Marchese.PriceTracker.product.dto.ProductRequestDTO;
import com.Marchese.PriceTracker.product.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

}
