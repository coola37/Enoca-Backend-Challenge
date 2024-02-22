package com.yigitkula.enoca.backendchalange.service.impl;

import com.yigitkula.enoca.backendchalange.entity.Product;
import com.yigitkula.enoca.backendchalange.repository.ProductRepository;
import com.yigitkula.enoca.backendchalange.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repo;
    @Override
    public Product getProduct(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product oldProduct = repo.findById(id).orElseThrow();
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setInStock(product.getInStock());
        return repo.save(oldProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
