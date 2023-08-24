package com.online.Smart_Online_Shopping_Platform.dto.response;

import com.online.Smart_Online_Shopping_Platform.Enum.ProductCategory;
import com.online.Smart_Online_Shopping_Platform.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {


    String sellerName;

    String productName;

    ProductCategory category;

    int price;

    int availableQuantity;

    ProductStatus productStatus;

    int productId;

}
