package com.poker.fivehand.poker.fivehand.service.impl;

import com.poker.fivehand.poker.fivehand.constants.Constants;
import com.poker.fivehand.poker.fivehand.model.dto.DeckDto;
import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import com.poker.fivehand.poker.fivehand.service.DeckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class DeckImpl {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeckService deckService;

    public DeckDto getDeck(){
        DeckDto deck = restTemplate.getForEntity(Constants.GET_DECK, DeckDto.class).getBody();
        Deck deck1 = new Deck();
        deck1.setDeck_id(deck.getDeck_id());
        deckService.save(deck1);
        return deck;
    }
}
