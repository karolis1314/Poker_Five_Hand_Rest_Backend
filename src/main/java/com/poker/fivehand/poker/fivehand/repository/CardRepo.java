package com.poker.fivehand.poker.fivehand.repository;

import com.poker.fivehand.poker.fivehand.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository <Card, Long> {
}
