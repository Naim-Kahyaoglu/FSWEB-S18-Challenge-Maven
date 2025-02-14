package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {

    public static void validateCard(Card card) {
        // If card type is JOKER, then value and color must be null
        if (card.getType() != null && card.getType() == Type.JOKER) {
            if (card.getValue() != null || card.getColor() != null) {
                throw new CardException("JOKER card must not have a value or color", HttpStatus.BAD_REQUEST);
            }
        } else {
            // For non-JOKER cards, only one of value or type should be provided
            if ((card.getType() != null && card.getValue() != null) ||
                    (card.getType() == null && card.getValue() == null)) {
                throw new CardException("Card must have either a type or a value (but not both)", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
