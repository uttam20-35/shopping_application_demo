package com.example.cartanditem.mapper;

import com.example.cartanditem.entity.CartEntity;
import com.example.cartanditem.entity.ItemEntity;
import com.example.cartanditem.model.Cart;
import com.example.cartanditem.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemEntity modelToEntity(Item item);

    Item entityToModel(ItemEntity itemEntity);
    List<Item> entityListToModelList(List<ItemEntity> itemEntityList);
}
