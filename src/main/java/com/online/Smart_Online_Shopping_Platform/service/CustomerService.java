package com.online.Smart_Online_Shopping_Platform.service;

import com.online.Smart_Online_Shopping_Platform.dto.request.CustomerRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.CustomerResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Cart;
import com.online.Smart_Online_Shopping_Platform.model.Customer;
import com.online.Smart_Online_Shopping_Platform.repository.CustomerRepository;
import com.online.Smart_Online_Shopping_Platform.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
  CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        // dto -> entity

//        Customer customer = new Customer();
//        customer.setName(customerRequestDto.getName());
//        customer.setGender(customerRequestDto.getGender());

        // dto -. entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer =customerRepository.save(customer);   // saves both customer and cart;

        // prepare the response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}