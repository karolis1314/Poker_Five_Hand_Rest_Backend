package com.poker.fivehand.poker.fivehand.controller;


import com.poker.fivehand.poker.fivehand.model.dto.CardDto;
import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import com.poker.fivehand.poker.fivehand.service.impl.CardImpl;
import com.poker.fivehand.poker.fivehand.service.impl.DeckImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class DeckController {

    @Autowired
    CardImpl card;

    @Autowired
    DeckImpl deck;


    @GetMapping(value = "/getDeck")
    public Deck getDeck(){
       return deck.getDeck();
    }

    @GetMapping(value = "/getHand")
    public CardDto getHand(){
        return card.getHand();
    }
}
