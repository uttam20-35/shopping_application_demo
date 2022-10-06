package com.example.cartanditem.service;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.mapper.ItemMapper;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.CartResponse;
import com.example.cartanditem.model.Item;
import com.example.cartanditem.model.ItemResponse;
import com.example.cartanditem.repository.CartRepository;
import com.example.cartanditem.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ItemService{

@Autowired
private ItemMapper itemMapper;


@Autowired
private ItemRepository itemRepository;
@Autowired
private CartRepository cartRepository;
 public static void deleteCart(Long id) {
 }

 public ItemResponse createItems(Item item) {
  ItemResponse itemResponse=new ItemResponse();
  ItemEntity itemEntity=itemMapper.modelToEntity(item);
  itemRepository.save(itemEntity);
  log.info("Item has been added successfully in your cart");
  itemResponse.setId(itemEntity.getId());
  return  itemResponse;

 }

 public Item getItem(Long id) {
 Item item=new Item();
 Optional<ItemEntity> optionalItemEntity=itemRepository.findById(id);
 if(optionalItemEntity.isPresent()){


 }
  return item;
 }

// public Item updateCart(Long id, Item item) {
// }

 public List<Item> getAllItems() {
  List<ItemEntity> itemEntities = itemRepository.findAll();
  List<Item> items = itemMapper.entityListToModelList(itemEntities);
  log.info("Getting full list of all the items");
  return items;
 }
}
