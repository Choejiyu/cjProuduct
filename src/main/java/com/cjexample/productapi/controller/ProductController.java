package com.cjexample.productapi.controller;


import com.cjexample.productapi.dto.ProductDeductReqDto;

import com.cjexample.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor  // 생성자 주입을 자동으로 처리
public class ProductController {

    private final ProductService productService;

    @PostMapping("/{productId}/deduct")
    public String deductStock(@PathVariable Long productId, @RequestBody ProductDeductReqDto productDeductReqDto) {
        return productService.deductStock(productId, productDeductReqDto.getQuantity());
    }
}