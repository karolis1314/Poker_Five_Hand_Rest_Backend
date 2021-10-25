package com.poker.fivehand.poker.fivehand.controller;

<<<<<<< HEAD

import com.poker.fivehand.poker.fivehand.model.dto.CardDto;
=======
import com.poker.fivehand.poker.fivehand.constants.Constants;
import com.poker.fivehand.poker.fivehand.model.entity.Cards;
import com.poker.fivehand.poker.fivehand.model.entity.Card;
>>>>>>> Changed the entity to represent it properly
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
<<<<<<< HEAD
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
=======
    public Deck getDeck(){
        Deck deck = restTemplate.getForEntity(Constants.GET_DECK, Deck.class).getBody();
        deckService.save(deck);
        return deck;
    }

    @GetMapping(value = "/getHand")
    public Cards getHand(){

        Cards handCall = restTemplate.getForEntity("https://deckofcardsapi.com/api/deck/"
                +deckService.getOne(id)
                .getDeck_id()+"/draw/?count=5", Cards.class).getBody();
        for(Card card : handCall.getCards()){
            cardsService.save(card);
        }
        Deck deck = deckService.getOne(id);
        deck.setRemaining(handCall.getRemaining());
        deckService.save(deck);
        log.info("Before the if: "+ deck.getId());
        if(deckService.getOne(id).getRemaining()<5){
            getDeck();
            id=deck.getId();
        }

        return handCall;

>>>>>>> Changed the entity to represent it properly
    }
}
