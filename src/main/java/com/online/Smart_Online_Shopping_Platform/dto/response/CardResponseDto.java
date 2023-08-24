package com.online.Smart_Online_Shopping_Platform.dto.response;

import com.example.smartdeals.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {

    String customerName;

    String cardNo;  // masked

    Date validTill;

    CardType cardType;
}
