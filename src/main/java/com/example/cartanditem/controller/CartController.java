package com.example.cartanditem.controller;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.CartResponse;
import com.example.cartanditem.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class CartController {

    @Autowired
    private CartService cartService;
    @PostMapping(path = "/carts", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createItems(@RequestBody Cart cart) {
        CartResponse cartResponse = cartService.createItems(cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }
    @GetMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping(path = "/carts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> cart = cartService.getAllItems();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping(path = "/carts/{id}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCart(@PathVariable Long id, @RequestBody Cart cart, @RequestParam String name)  {
         cartService.updateCart(id, cart,name);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(path = "/carts/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
        return ResponseEntity.ok().build();
    }
}
