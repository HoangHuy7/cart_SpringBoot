package com.example.cart_springboot.service;

import com.example.cart_springboot.entities.Product;
import com.example.cart_springboot.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }
    public Product save(Product p){
        return productRepository.save(p);
    }
}
