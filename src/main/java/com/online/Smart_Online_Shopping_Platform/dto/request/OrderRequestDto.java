package com.online.Smart_Online_Shopping_Platform.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDto {

    String customerEmail;

    int productId;

    String cardUsed;

    int cvv;

    int requiredQuantity;
}
