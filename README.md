CJ제일제당 
1. 과제 : 온라인 쇼핑몰에서 상품 재고 차감 API 구현
2. 환경
   1) spring boot 2.7.8
   2) maven
   3) 자바 8
   4) H2 Database
3. ProductDataLoader 를 사용해서 어플리케이션 start 시 간단한 데이터 insert되도록 함
4. API url : localhost:8080/api/products/deduct/1
   1) request
      {
        "quantity": 10
      }
   2) response

  
