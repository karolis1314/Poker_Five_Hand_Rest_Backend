package com.poker.fivehand.poker.fivehand.service;

import com.poker.fivehand.poker.fivehand.model.entity.Card;
import com.poker.fivehand.poker.fivehand.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {

    @Autowired
    CardRepo cardRepo;

    public List<Card> findAll(){
        return cardRepo.findAll();
    }

    public void save(Card card){
        cardRepo.save(card);
    }

    public Card getOne(Long id){
        return cardRepo.getById(id);
    }
}
