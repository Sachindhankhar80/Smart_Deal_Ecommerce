package com.online.Smart_Online_Shopping_Platform.transformer;

import com.online.Smart_Online_Shopping_Platform.dto.request.CustomerRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.CustomerResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Customer;
import lombok.experimental.UtilityClass;

// @UtilityClass   // for ensuring class is not instantiated but not a std. practice to write
public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .email(customerRequestDto.getEmail())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .gender(customer.getGender())
                .email(customer.getEmail())
                .mobNo(customer.getMobNo())
                .build();
    }
}
