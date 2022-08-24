package com.example.cart_springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class formUpdateQuantity{
    private int quantity;
    private Long productId;
}