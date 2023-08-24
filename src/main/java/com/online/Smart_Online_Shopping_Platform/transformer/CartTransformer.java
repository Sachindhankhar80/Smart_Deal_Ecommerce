package com.online.Smart_Online_Shopping_Platform.transformer;

import com.online.Smart_Online_Shopping_Platform.dto.response.CartResponseDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.ItemResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Cart;
import com.online.Smart_Online_Shopping_Platform.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponseDto CartToCartReponseDto(Cart cart) {

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for (Item item : cart.getItems()) {
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtoList)
                .build();
    }
}