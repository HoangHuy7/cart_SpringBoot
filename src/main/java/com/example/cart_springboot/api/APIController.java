package com.example.cart_springboot.api;

import com.example.cart_springboot.entities.Cart;
import com.example.cart_springboot.entities.Product;
import com.example.cart_springboot.entities.formUpdateQuantity;
import com.example.cart_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class APIController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping("/cart/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable(value = "productId") Long id, HttpSession httpSession) {

        try {
            Cart cart = (Cart) httpSession.getAttribute("CART");
            if (cart == null){
                cart = new Cart();
            }
            Product product = productService.findById(id);
            if (product !=null){
                cart.addToCart(product);
            }
            httpSession.setAttribute("CART",cart);
            return  ResponseEntity.ok().body(cart);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/cart/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "productId") Long id, HttpSession httpSession) {

        try {
            Cart cart = (Cart) httpSession.getAttribute("CART");
            if (cart != null){
                cart.delete(id);
            }
            httpSession.setAttribute("CART",cart);
            return  ResponseEntity.ok().body(cart);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/cart/clear")
    public ResponseEntity<?> clear(HttpSession httpSession) {

        try {
            Cart cart = (Cart) httpSession.getAttribute("CART");
            if (cart != null){
                cart.clearAll();
            }
            httpSession.setAttribute("CART",cart);
            return  ResponseEntity.ok().body(cart);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/cart/update")
    public  ResponseEntity<?> updateQuantity(@RequestBody formUpdateQuantity formUpdate, HttpSession httpSession) {

        try {
            Cart cart = (Cart) httpSession.getAttribute("CART");
            if (cart != null){
                cart.updateQuantity(formUpdate.getProductId(),formUpdate.getQuantity());
            }
            httpSession.setAttribute("CART",cart);
            return  ResponseEntity.ok().body(cart);
        } catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}


