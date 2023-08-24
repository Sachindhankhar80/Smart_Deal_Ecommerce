package com.online.Smart_Online_Shopping_Platform.transformer;

import com.online.Smart_Online_Shopping_Platform.dto.response.ItemResponseDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.OrderResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Item;
import com.online.Smart_Online_Shopping_Platform.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderTransformer {

    public static OrderResponseDto OrderToOrderResponseDto(OrderEntity order){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: order.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .cardUsed(order.getCardUsed())
                .orderTotal(order.getOrderTotal())
                .customerName(order.getCustomer().getName())
                .item(itemResponseDtoList)
                .build();

    }
}
