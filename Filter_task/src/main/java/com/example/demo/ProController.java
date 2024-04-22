package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")

public class ProController {
	@Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@PathVariable double price) {
        List<Product> products = productService.getProductsByPriceGreaterThan(price);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> getFilteredProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice) {
        List<Product> products;
        if (category != null && minPrice != null) {
            products = productService.getProductsByCategoryAndPriceGreaterThan(category, minPrice);
        } else if (category != null) {
            products = productService.getProductsByCategory(category);
        } else if (minPrice != null) {
            products = productService.getProductsByPriceGreaterThan(minPrice);
        } else {
            products = productService.getAllProducts();
        }
        return ResponseEntity.ok().body(products);
    }
}








