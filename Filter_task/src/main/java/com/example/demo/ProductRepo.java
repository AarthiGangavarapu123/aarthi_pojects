package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	List<Product> findByCategory(String category);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByCategoryAndPriceGreaterThan(String category, double price);
}


