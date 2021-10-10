package com.poker.fivehand.poker.fivehand.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "image")
    private String image;

    @Column(name = "value")
    private String value;

    @Column(name = "suit")
    private String suit;

    @Column(name = "code")
    private String code;

}
