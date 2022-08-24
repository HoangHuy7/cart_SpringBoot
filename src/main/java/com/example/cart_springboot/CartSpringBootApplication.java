package com.example.cart_springboot;

import com.example.cart_springboot.entities.Product;
import com.example.cart_springboot.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class CartSpringBootApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {

        SpringApplication.run(CartSpringBootApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        Product product = new Product(1L,"siting",new BigDecimal("10000.0"));
//        Product product2 = new Product(2L,"pessi",new BigDecimal("10000.0"));
//
//
//        log.warn(productService.save(product)+ "product da luu");
//        log.warn(productService.save(product2) + "product da luu");
    }
}
