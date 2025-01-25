package com.example.graphql.resource;

import com.example.graphql.entity.Product;
import com.example.graphql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductHttpController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }
}
