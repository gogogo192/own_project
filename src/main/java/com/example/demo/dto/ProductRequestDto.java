package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private String description;
    private int price;
    private int stockQuantity;
}