package com.poker.fivehand.poker.fivehand.service.impl;


import com.poker.fivehand.poker.fivehand.constants.Constants;
import com.poker.fivehand.poker.fivehand.model.entity.Card;
import com.poker.fivehand.poker.fivehand.model.entity.Cards;
import com.poker.fivehand.poker.fivehand.service.CardsService;
import com.poker.fivehand.poker.fivehand.service.DeckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CardImpl {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeckService deckService;

    @Autowired
    CardsService cardsService;

    @Autowired
    DeckImpl deck;


    public Cards getHand(){
        if(deckService.getOne(Constants.ID)==null){
            log.info("No deck yet");
        }else {
            try{
                Cards handCall = restTemplate.getForEntity("https://deckofcardsapi.com/api/deck/"
                        + deckService.getOne(Constants.ID).getDeck_id() + "/draw/?count=5", Cards.class).getBody();
                for (Card card : handCall.getCards()) {
                    cardsService.save(card);
                }
                deckService.getOne(Constants.ID).setRemaining(handCall.getRemaining());
                if(deckService.getOne(Constants.ID).getRemaining()<5){
                    deck.getDeck();
                    Constants.ID++;
                }
                return handCall;
            }catch (Exception e){
                log.info(e.getMessage());
            }
        }
        return null;
    }
}
