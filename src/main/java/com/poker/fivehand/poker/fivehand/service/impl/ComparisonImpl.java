package com.poker.fivehand.poker.fivehand.service.impl;

import com.poker.fivehand.poker.fivehand.constants.Constants;
import com.poker.fivehand.poker.fivehand.model.entity.Card;
import com.poker.fivehand.poker.fivehand.model.entity.PlayerHand;
import com.poker.fivehand.poker.fivehand.service.CardsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ComparisonImpl {

    @Autowired
    PlayerHand playerHand;

    @Autowired
    CardsService cardsService;

    public PlayerHand getHandPlayerOne(){

        List<Card> list = new ArrayList<>();

        while( Constants.PLAYER_ONE_ID != Constants.PLAYER_TWO_ID) {
            list.add(cardsService.getOne(Constants.PLAYER_ONE_ID));
            Constants.PLAYER_ONE_ID ++;
        }

        playerHand.setHand(list);
        return playerHand;
    }

    public PlayerHand getHandPlayerTwo(){

        List<Card> list = new ArrayList<>();

        while( Constants.PLAYER_TWO_ID != Constants.LIMIT_PLAYER_DRAW) {
            list.add(cardsService.getOne(Constants.PLAYER_TWO_ID));
            Constants.PLAYER_TWO_ID ++;
        }
        Constants.LIMIT_PLAYER_DRAW += 5;

        playerHand.setHand(list);
        return playerHand;
    }

    public PlayerHand highHand(PlayerHand playerHand){
        boolean playerOne = false;

        boolean playerTwo = false;

        int playerOneScore = 0;

        int playerTwoScore = 0;

        if(playerOne) return playerHand;
        if(playerTwo) return playerHand;

        return playerHand;
    }

}
