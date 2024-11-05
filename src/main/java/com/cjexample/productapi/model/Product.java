package com.cjexample.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
;

import javax.persistence.Entity;
import javax.persistence.Id;

    @Entity
    @Getter   // 자동으로 getter 메서드를 생성
    @Setter   // 자동으로 setter 메서드를 생성
    @NoArgsConstructor  // 기본 생성자 생성
    @AllArgsConstructor // 모든 필드를 포함한 생성자 생성
    public class Product {

        @Id
        private Long id;
        private String name;
        private int stock;

    }

