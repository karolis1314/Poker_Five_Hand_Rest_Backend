package com.poker.fivehand.poker.fivehand.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deck")
public class Deck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "deckId")
    private int deck_id;

    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Card> cards;
}
