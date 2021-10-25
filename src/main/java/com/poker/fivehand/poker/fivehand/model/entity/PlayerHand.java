package com.poker.fivehand.poker.fivehand.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class PlayerHand {

    private String winner;
    private List<Card> hand ;
}
