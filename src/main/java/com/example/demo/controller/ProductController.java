package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductRequestDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // => REST 컨트롤러.
@RequestMapping("/products") // => /products 시작.
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        List<Product> products = productService.getAll();
        List<ProductResponseDto> result = products.stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
        // => 전체 상품 목록 반환.
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getOne(@PathVariable Long id) {
        return productService.getById(id)
                .map(product -> ResponseEntity.ok(new ProductResponseDto(product)))
                .orElse(ResponseEntity.notFound().build());
        // => 단건 조회. 없으면 404.
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto dto) {
        Product saved = productService.create(dto);
        return ResponseEntity.ok(new ProductResponseDto(saved));
        // => 등록.
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id, @RequestBody ProductRequestDto dto) {
        Product updated = productService.update(id, dto);
        return ResponseEntity.ok(new ProductResponseDto(updated));
        // => 수정.
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
        // => 삭제. 204 No Content 반환.
    }
}
