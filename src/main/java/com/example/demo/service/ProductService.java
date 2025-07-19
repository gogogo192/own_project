package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductRequestDto;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // => 비즈니스 로직 담당. DB 작업 + 추가 로직.
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        // => 생성자 방식 주입.
    }

    public List<Product> getAll() {
        return productRepository.findAll();
        // => 전체 상품 조회.
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
        // => 단건 조회. Optional로 반환.
    }

    public Product create(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        return productRepository.save(product);
        // => DTO 기반으로 생성 후 저장.
    }

    public Product update(Long id, ProductRequestDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("해당 상품이 존재하지 않습니다. ID: " + id));
        // => 없으면 예외.

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        return productRepository.save(product);
        // => 수정 후 저장.
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
        // => 삭제.
    }
}
