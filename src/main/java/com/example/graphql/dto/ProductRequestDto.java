package com.example.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {
    private Integer id;
    private String name;
    private String category;
    private Float price;
    private Integer stock;
}
