package com.online.Smart_Online_Shopping_Platform.dto.request;

import com.online.Smart_Online_Shopping_Platform.Enum.ProductCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {

    String sellerEmail;

    String productName;

    ProductCategory category;

    int price;

    int availableQuantity;
}
