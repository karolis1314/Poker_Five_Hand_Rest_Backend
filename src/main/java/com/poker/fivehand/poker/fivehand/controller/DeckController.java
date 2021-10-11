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
    public String getDeck(){
        if(deck.getDeck()==null){
            return "No Deck selected yet, please call getDeck for Deck selection.";
        }
       return deck.getDeck().toString();
    }

    @GetMapping(value = "/getHand")
    public String getHand(){
        if(card.getHand() == null){
            return "No Hand made, please get deck than try to get the Hand, call getDeck for deck selection.";
        }return card.getHand().toString();
    }
}
