package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // If the card has a numerical value; use Integer wrapper to allow null
    private Integer value;

    // Enum for card type; if value is present, type should be null
    @Enumerated(EnumType.STRING)
    private Type type;

    // Enum for card color; should be null if type is JOKER
    @Enumerated(EnumType.STRING)
    private Color color;
}
