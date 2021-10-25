package com.poker.fivehand.poker.fivehand.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    private boolean success;
    private String deck_id;
    private List<Card> cards;
    private int remaining;
}
