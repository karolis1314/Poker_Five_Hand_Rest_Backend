package com.poker.fivehand.poker.fivehand.service.impl;


import com.poker.fivehand.poker.fivehand.model.dto.CardDto;
import com.poker.fivehand.poker.fivehand.model.entity.Card;
import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import com.poker.fivehand.poker.fivehand.service.CardsService;
import com.poker.fivehand.poker.fivehand.service.DeckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CardImpl {

    private long id = 1;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeckService deckService;

    @Autowired
    CardsService cardsService;

    public CardDto getHand(){
        if(deckService.getOne(id)==null){
            log.info("No deck yet");
        }else {
            try{
                CardDto handCall = restTemplate.getForEntity("https://deckofcardsapi.com/api/deck/"
                        + deckService.getOne(id)
                        .getDeck_id() + "/draw/?count=5", CardDto.class).getBody();
                for (Card card : handCall.getCards()) {
                    cardsService.save(card);
                }
                return handCall;
            }catch (Exception e){
                log.info(e.getMessage());
            }

        }
        return null;
    }
}
