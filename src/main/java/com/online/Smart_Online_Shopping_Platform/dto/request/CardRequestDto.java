package com.online.Smart_Online_Shopping_Platform.dto.request;

import com.online.Smart_Online_Shopping_Platform.Enum.CardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {


    String customerMobile;

    String cardNo;

    int cvv;

    Date validTill;

    CardType cardType;
}
