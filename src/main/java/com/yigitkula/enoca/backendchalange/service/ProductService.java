package com.yigitkula.enoca.backendchalange.service;

import com.yigitkula.enoca.backendchalange.entity.Product;

public interface ProductService {

    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Long id, Product product);
    public void deleteProduct(Long id);

}
