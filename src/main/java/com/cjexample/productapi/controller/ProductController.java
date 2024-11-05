package com.cjexample.productapi.controller;


import com.cjexample.productapi.dto.ApiResponseDto;
import com.cjexample.productapi.dto.ProductDeductReqDto;

import com.cjexample.productapi.model.Product;
import com.cjexample.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor  // 생성자 주입을 자동으로 처리
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 재고 차감 API
     * @param id 상품 ID
     * @param deductReqDto 요청 DTO (차감 수량 포함)
     * @return ApiResponseDto 응답 DTO
     */
    @PostMapping("/deduct/{id}")
    public ApiResponseDto<Product> deductStock(@PathVariable Long id, @RequestBody ProductDeductReqDto deductReqDto) {
        // 재고 차감 결과 메시지
        String resultMessage = productService.deductStock(id, deductReqDto.getQuantity());

        // 응답 코드와 메시지 설정
        ApiResponseDto<Product> response;

        if (resultMessage.equals("재고가 부족합니다.")) {
            response = new ApiResponseDto<>("400", resultMessage, null);  // 재고 부족
        } else if (resultMessage.equals("상품을 찾을 수 없습니다.")) {
            response = new ApiResponseDto<>("404", resultMessage, null);  // 상품 없음
        } else {
            Product product = productService.getProductById(id); // 차감 후 최신 상품 정보 반환
            response = new ApiResponseDto<>("200", resultMessage, product);  // 재고 차감 성공
        }

        return response;
    }
}