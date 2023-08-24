package com.online.Smart_Online_Shopping_Platform.controller;


import com.online.Smart_Online_Shopping_Platform.dto.request.CheckoutCartRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.request.ItemRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.CartResponseDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.OrderResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Item;
import com.online.Smart_Online_Shopping_Platform.repository.CartRepository;
import com.online.Smart_Online_Shopping_Platform.service.CartService;
import com.online.Smart_Online_Shopping_Platform.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){

        try{
            Item item = itemService.createItem(itemRequestDto);
            CartResponseDto cartResponseDto = cartService.addItemToCart(itemRequestDto,item);
            return new ResponseEntity(cartResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/checkout")
    public ResponseEntity checkoutCart(@RequestBody CheckoutCartRequestDto checkoutCartRequestDto){

        try{
            OrderResponseDto response = cartService.checkoutCart(checkoutCartRequestDto);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}