package com.cjexample.productapi.service;

import com.cjexample.productapi.model.Product;
import com.cjexample.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // final 필드에 대해 자동 생성되는 생성자
public class ProductService {

    private final ProductRepository productRepository;

    public String deductStock(Long productId, int quantity) {
        // 상품 찾기
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return "상품을 찾을 수 없습니다.";
        }

        // 재고 차감
        if (product.getStock() < quantity) {
            return "재고가 부족합니다.";
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        return "재고 차감 성공!";
    }
}