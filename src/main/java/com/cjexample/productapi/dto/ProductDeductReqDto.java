package com.cjexample.productapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDeductReqDto {
    private int quantity;  // 차감할 수량
}
