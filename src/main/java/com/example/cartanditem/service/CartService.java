package com.example.cartanditem.service;


import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.mapper.CartMapper;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.CartResponse;
import com.example.cartanditem.repository.CartRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartMapper cartMapper;

    public CartResponse createItems(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        CartEntity cartEntity = cartMapper.modelToEntity(cart);
        cartRepository.save(cartEntity);
        log.info("Item has been added successfully in your cart");
        cartResponse.setId(cartEntity.getCartId());
        return cartResponse;
    }

    public Cart getCart(Long id) {
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(id);
        Cart cart = new Cart();
        if (optionalCartEntity.isPresent()) {
            cart = cartMapper.entityToModel(optionalCartEntity.get());
            log.info("Received the item {} with " + id);
        } else {
            log.info("No items with id {} found " + id);
        }
        return cart;
    }

    public void updateCart(Long id, Cart cart, String name) {
        ItemEntity itemEntity = null;
        Integer count=0;
        CartEntity cartEntity = new CartEntity();
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(id);
        if (optionalCartEntity.isPresent()) {
            for (ItemEntity iE : optionalCartEntity.get().getItems()) {
                count++;
                if (iE.getName().equalsIgnoreCase(name)) {
                    itemEntity=iE;
                    itemEntity.setQuantity(cart.getItems().get(count).getQuantity());
                    cartEntity = cartRepository.save(cartEntity);
                }
            }
        }

    }

    public void deleteCart(Long id) {
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(id);
        if (optionalCartEntity.isPresent()) {
            cartRepository.deleteById(id);
            log.info("Item has been deleted");
        } else {
            log.info("No items with id {} found " + id);
        }
    }

    public List<Cart> getAllItems() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        List<Cart> carts = cartMapper.entityToModels(cartEntities);
        log.info("Getting full list of all the items");
        return carts;
    }
}
