package com.poker.fivehand.poker.fivehand.controller;

import com.poker.fivehand.poker.fivehand.constants.Constants;
import com.poker.fivehand.poker.fivehand.model.dto.CardDto;
import com.poker.fivehand.poker.fivehand.model.dto.DeckDto;
import com.poker.fivehand.poker.fivehand.model.entity.Card;
import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import com.poker.fivehand.poker.fivehand.service.CardsService;
import com.poker.fivehand.poker.fivehand.service.DeckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class DeckController {

    long id = 1;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeckService deckService;

    @Autowired
    CardsService cardsService;


    @GetMapping(value = "/getDeck")
    public DeckDto getDeck(){
        DeckDto deck = restTemplate.getForEntity(Constants.GET_DECK, DeckDto.class).getBody();
        Deck deck1 = new Deck();
        deck1.setDeck_id(deck.getDeck_id());
        deckService.save(deck1);
        return deck;
    }

    @GetMapping(value = "/getHand")
    public CardDto getHand(){

        CardDto handCall = restTemplate.getForEntity("https://deckofcardsapi.com/api/deck/"
                +deckService.getOne(id)
                .getDeck_id()+"/draw/?count=5", CardDto.class).getBody();
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

    }
}
