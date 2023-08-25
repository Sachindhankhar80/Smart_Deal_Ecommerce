package com.online.Smart_Online_Shopping_Platform.dto.response;

import com.online.Smart_Online_Shopping_Platform.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponseDto {

    String name;

    Gender gender;

    String mobNo;

    String email;
}
