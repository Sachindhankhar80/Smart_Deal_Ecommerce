package com.online.Smart_Online_Shopping_Platform.model;

import com.online.Smart_Online_Shopping_Platform.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "card")
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String cardNo;

    int cvv;

    Date validTill;

    CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;


}
