package com.poker.fivehand.poker.fivehand.service.impl;

import com.poker.fivehand.poker.fivehand.constants.Constants;
import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import com.poker.fivehand.poker.fivehand.service.DeckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class DeckImpl {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeckService deckService;

    public Deck getDeck(){
        try {
            Deck deck = restTemplate.getForEntity(Constants.GET_DECK, Deck.class).getBody();
            deckService.save(deck);
            return deck;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return null;
    }
}
