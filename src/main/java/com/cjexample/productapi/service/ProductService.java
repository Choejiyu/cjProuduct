package com.cjexample.productapi.service;

import com.cjexample.productapi.model.Product;
import com.cjexample.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // final 필드에 대해 자동 생성되는 생성자
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * 재고 차감 처리 (비관적 잠금)
     * @param productId 상품 ID
     * @param quantity 차감할 수량
     * @return 차감 결과 메시지
     */
    public String deductStock(Long productId, int quantity) {
        // 상품 찾기 (비관적 잠금 적용)
        Product product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            return "상품을 찾을 수 없습니다.";
        }

        // 재고 차감
        if (product.getStock() < quantity) {
            return "재고가 부족합니다.";
        }

        // 재고 차감 후 저장
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        return "재고 차감 성공!";
    }

    // 상품 ID로 상품 정보 조회 (최신 상태 반환)
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}