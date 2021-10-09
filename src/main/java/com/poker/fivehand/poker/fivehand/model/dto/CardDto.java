package com.poker.fivehand.poker.fivehand.model.dto;

import com.poker.fivehand.poker.fivehand.model.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private boolean success;
    private String deck_id;
    private List<Card> cards;
    private int remaining;
}
