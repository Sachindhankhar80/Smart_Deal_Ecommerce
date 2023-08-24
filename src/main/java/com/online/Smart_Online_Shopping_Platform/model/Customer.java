package com.online.Smart_Online_Shopping_Platform.model;

import com.online.Smart_Online_Shopping_Platform.Enum.Gender;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.id.factory.spi.GeneratorDefinitionResolver;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    String mobNo;

    @Column(unique = true,nullable = false)
    String email;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cards = new ArrayList<>();

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
}
