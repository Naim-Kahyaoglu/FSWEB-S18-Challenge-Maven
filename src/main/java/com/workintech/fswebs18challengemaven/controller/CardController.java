package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards")

@RequiredArgsConstructor
@CrossOrigin  // Allows cross-origin requests; adjust as needed for your React/Codepen setup.
public class CardController {

    private final CardRepository cardRepository;

    @GetMapping
    public List<Card> getAllCards() {
        log.info("Fetching all cards");
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getCardsByColor(@PathVariable String color) {
        log.info("Fetching cards with color: {}", color);
        return cardRepository.findByColor(color);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getCardsByValue(@PathVariable int value) {
        log.info("Fetching cards with value: {}", value);
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getCardsByType(@PathVariable String type) {
        log.info("Fetching cards with type: {}", type);
        return cardRepository.findByType(type);
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        log.info("Creating card: {}", card);
        CardValidation.validateCard(card);
        return cardRepository.save(card);
    }

    @PutMapping
    public Card updateCard(@RequestBody Card card) {
        log.info("Updating card with id: {}", card.getId());
        CardValidation.validateCard(card);
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card deleteCard(@PathVariable Long id) {
        log.info("Deleting card with id: {}", id);
        return cardRepository.remove(id);
    }
}
