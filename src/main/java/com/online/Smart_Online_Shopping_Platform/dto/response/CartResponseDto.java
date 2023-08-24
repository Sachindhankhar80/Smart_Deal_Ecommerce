package com.online.Smart_Online_Shopping_Platform.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {
    String customerName;

    int cartTotal;

    List<ItemResponseDto> items;
}
