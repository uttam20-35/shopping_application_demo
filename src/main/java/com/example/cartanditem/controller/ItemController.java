package com.example.cartanditem.controller;

import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.CartResponse;
import com.example.cartanditem.model.Item;
import com.example.cartanditem.model.ItemResponse;
import com.example.cartanditem.service.CartService;
import com.example.cartanditem.service.ItemService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(path = "/items", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemResponse> createItems(@RequestBody Item item) {
        ItemResponse itemResponse = itemService.createItems(item);
        return new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }
    @GetMapping(path = "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping(path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> item= itemService.getAllItems();
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

//    @PutMapping(path = "/items/{id}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Item> updateCart(@PathVariable Long id, @RequestBody Item item) {
//        item = itemService.updateCart(id, item);
//        return new ResponseEntity<>(item, HttpStatus.CREATED);
//    }
  /*  @DeleteMapping(path = "/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        ItemService.deleteCart(id);
        return ResponseEntity.ok().build();
    }*/
}
