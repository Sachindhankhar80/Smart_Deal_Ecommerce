package com.online.Smart_Online_Shopping_Platform.service;

import com.online.Smart_Online_Shopping_Platform.dto.request.ItemRequestDto;
import com.online.Smart_Online_Shopping_Platform.exception.CustomerNotFoundException;
import com.online.Smart_Online_Shopping_Platform.exception.InsufficientQuantityException;
import com.online.Smart_Online_Shopping_Platform.exception.ProductNotFoundException;
import com.online.Smart_Online_Shopping_Platform.model.Customer;
import com.online.Smart_Online_Shopping_Platform.model.Item;
import com.online.Smart_Online_Shopping_Platform.model.Product;
import com.online.Smart_Online_Shopping_Platform.repository.CustomerRepository;
import com.online.Smart_Online_Shopping_Platform.repository.ProductRepository;
import com.online.Smart_Online_Shopping_Platform.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmail(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exisit");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Product product = productOptional.get();

        // check for required quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not avaiable");
        }

        // create item
        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}
