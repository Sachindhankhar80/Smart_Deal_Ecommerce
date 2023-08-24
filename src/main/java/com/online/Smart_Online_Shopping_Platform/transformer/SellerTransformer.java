package com.online.Smart_Online_Shopping_Platform.transformer;

import com.online.Smart_Online_Shopping_Platform.dto.request.SellerRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.SellerResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .pan(sellerRequestDto.getPan())
                .build();
    }

    public static SellerResponseDto SellerToSellerResponseDto(Seller seller){

        return  SellerResponseDto.builder()
                .email(seller.getEmail())
                .name(seller.getName())
                .build();
    }
}
