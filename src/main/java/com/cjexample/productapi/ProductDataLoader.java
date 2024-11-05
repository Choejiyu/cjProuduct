package com.cjexample.productapi;

import com.cjexample.productapi.model.Product;
import com.cjexample.productapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    // 생성자 주입
    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 초기 데이터 삽입
        if (productRepository.count() == 0) {
            // 데이터가 없으면 초기 상품 데이터 삽입
            Product product1 = new Product(1L, "Product 1", 100);
            Product product2 = new Product(2L, "Product 2", 150);
            Product product3 = new Product(3L, "Product 3", 200);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);

            System.out.println("초기 상품 데이터 삽입 완료");
        }
    }
}
