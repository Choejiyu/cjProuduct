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
        if (productRepository.count() == 0) {
            Product product1 = new Product();
            product1.setId(1L);
            product1.setName("Product 1");
            product1.setStock(100);

            Product product2 = new Product();
            product2.setId(2L);
            product2.setName("Product 2");
            product2.setStock(150);

            Product product3 = new Product();
            product3.setId(3L);
            product3.setName("Product 3");
            product3.setStock(200);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);

            System.out.println("초기 상품 데이터 삽입 완료");
        }
    }
}
