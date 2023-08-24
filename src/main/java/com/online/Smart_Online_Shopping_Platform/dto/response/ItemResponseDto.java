package com.online.Smart_Online_Shopping_Platform.dto.response;

import com.online.Smart_Online_Shopping_Platform.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {

    String itemName;

    int itemPrice;

    int quantityAdded;

    ProductCategory category;
}
