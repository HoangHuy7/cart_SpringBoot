package com.example.cart_springboot.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class Cart extends HashMap<Long,ProductInCart> implements Serializable {

    public void addToCart(Product product){
        ProductInCart productInCart = this.get(product.getId());
        if (productInCart == null){
            // product ko co trong gio hang
            productInCart = new ProductInCart(product,1);
            this.put(product.getId(),productInCart);
        }
        else {
            // product co trong gio hang
            productInCart.setQuantity(productInCart.getQuantity()+1);
        }
    }
    public void delete(Long id){
        this.remove(id);
    }
    public void clearAll(){
        if (this != null){
            this.clear();
        }
    }
    public Cart updateQuantity(Long id,int quantity){
        ProductInCart productInCart = this.get(id);
        if (productInCart != null) {
            productInCart.setQuantity(quantity);
        }
        return this;
    }
}
