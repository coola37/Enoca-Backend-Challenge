package com.yigitkula.enoca.backendchalange.controller;

import com.yigitkula.enoca.backendchalange.entity.Product;
import com.yigitkula.enoca.backendchalange.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/get/{productId}")
    Product getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PutMapping("/update/{productId}")
    Product updateProduct(@PathVariable Long productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/delete/{productId}")
    String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return "Product has been deleted";
    }
}
