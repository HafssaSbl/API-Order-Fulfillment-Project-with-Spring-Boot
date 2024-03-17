package com.example.projet_spring.service;

import com.example.projet_spring.entity.product;
import com.example.projet_spring.repository.product_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class productservice {
    private final product_repository Product_Repository;
    public product postproduct(product Product)
    {
        return Product_Repository.save(Product);  }
    public List<product> getAllProduct()
    {
        return Product_Repository.findAll();  }
    public product getProductById(Long id ){
        return  Product_Repository.findById(id).orElse(null);
    }
    public product updateProduct(product Product ){
        return  Product_Repository.save(Product);
    }
    public void deleteProduct(Long id ){
        Product_Repository.deleteById(id);
    }

}
