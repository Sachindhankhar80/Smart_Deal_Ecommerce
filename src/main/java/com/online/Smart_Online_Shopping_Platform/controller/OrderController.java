package com.online.Smart_Online_Shopping_Platform.controller;

import com.online.Smart_Online_Shopping_Platform.dto.request.OrderRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.OrderResponseDto;
import com.online.Smart_Online_Shopping_Platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){

        try{
            OrderResponseDto response = orderService.placeOrder(orderRequestDto);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}