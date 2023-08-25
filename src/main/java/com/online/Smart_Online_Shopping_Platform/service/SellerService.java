package com.online.Smart_Online_Shopping_Platform.service;

import com.online.Smart_Online_Shopping_Platform.dto.request.SellerRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.SellerResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Seller;
import com.online.Smart_Online_Shopping_Platform.repository.SellerRepository;
import com.online.Smart_Online_Shopping_Platform.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto to entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save the entity

        Seller savedSeller = sellerRepository.save(seller);

        // prepare response Dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}
