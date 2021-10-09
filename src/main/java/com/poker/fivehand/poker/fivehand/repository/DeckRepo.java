package com.poker.fivehand.poker.fivehand.repository;

import com.poker.fivehand.poker.fivehand.model.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepo extends JpaRepository <Deck, Long> {
}
