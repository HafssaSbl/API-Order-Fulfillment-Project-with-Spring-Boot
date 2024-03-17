package com.example.projet_spring.controller;

import com.example.projet_spring.entity.product;
import com.example.projet_spring.service.productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class productcontroller {
private final productservice productService;
@PostMapping("/product")
public product postproduct(@RequestBody product Product){
    return productService.postproduct(Product);
}

    @GetMapping("/products")
 private List<product> getAllProduct()
{
        return productService.getAllProduct();
    }
    @GetMapping("/product/{id}")
    private ResponseEntity<product> getProductById(@PathVariable  Long id)
    {
        product Product=productService.getProductById(id);
        if(Product==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Product);
    }
    @PutMapping("/product/{id}")
    private ResponseEntity<product> updateProduct(@PathVariable  Long id,@RequestBody product Product)
    {
     product existingProduct=productService.getProductById(id);
     if(existingProduct==null)
         return ResponseEntity.notFound().build();
     existingProduct.setName(Product.getName());
     existingProduct.setDescription(Product.getDescription());
     existingProduct.setPrix(Product.getPrix());
     existingProduct.setQuantite_en_stock(Product.getQuantite_en_stock());
     existingProduct.setFournisseur(Product.getFournisseur());
     existingProduct.setDate_ajout(Product.getDate_ajout());
     existingProduct.setCommande(Product.getCommande());
     existingProduct.setStockage(Product.getStockage());
     existingProduct.setEntropot(Product.getEntropot());
     product updateProduct=productService.updateProduct(existingProduct);
     return ResponseEntity.ok(updateProduct);
    }
    @DeleteMapping ("/product/{id}")

    private ResponseEntity<?> deleteProduct(@PathVariable  Long id){
        product existingProduct=productService.getProductById(id);
        if(existingProduct==null)
            return ResponseEntity.notFound().build();
        productService.deleteProduct(id);
        return  ResponseEntity.ok().build();

    }
}
