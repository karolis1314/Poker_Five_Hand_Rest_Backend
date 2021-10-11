package com.poker.fivehand.poker.fivehand.service;

import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import com.poker.fivehand.poker.fivehand.repository.DeckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {


    @Autowired
    DeckRepo deckRepo;

    public List<Deck> findAll(){
        return deckRepo.findAll();
    }

    public void save(Deck deck){
        deckRepo.save(deck);
    }

    public Deck getOne(long id){
        return deckRepo.getById(id);
    }

    public int getRemaining(long id){
        return deckRepo.getById(id).getRemaining();
    }

}
