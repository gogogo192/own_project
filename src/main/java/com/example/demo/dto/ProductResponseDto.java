package com.example.demo.dto;


import com.example.demo.domain.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final int price;
    private final int stockQuantity;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
    }
}