package com.online.Smart_Online_Shopping_Platform.transformer;

import com.online.Smart_Online_Shopping_Platform.Enum.ProductStatus;
import com.online.Smart_Online_Shopping_Platform.dto.request.ProductRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.ProductResponseDto;
import com.online.Smart_Online_Shopping_Platform.model.Product;

public class ProductTransformer {

    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .availableQuantity(productRequestDto.getAvailableQuantity())
                .category(productRequestDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .sellerName(product.getSeller().getName())
                .productName(product.getProductName())
                .productStatus(product.getProductStatus())
                .price(product.getPrice())
                .category(product.getCategory())
                .availableQuantity(product.getAvailableQuantity())
                .productId(product.getId())
                .build();
    }
}
