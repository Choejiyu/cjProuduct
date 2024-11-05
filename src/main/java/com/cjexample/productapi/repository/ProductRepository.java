package com.cjexample.productapi.repository;

import com.cjexample.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
