package com.evolution.cluedo.common.entity;

/**
 * Created by surya on 06/02/16.
 */
public class Card {

    String name;
    CardType cardType;

    public Card(){}
    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
