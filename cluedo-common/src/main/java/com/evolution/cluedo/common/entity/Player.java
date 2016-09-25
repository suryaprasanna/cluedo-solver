package com.evolution.cluedo.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by surya on 06/02/16.
 */
public class Player implements Serializable{
    Integer id;
    List<Card> myCards;
    Boolean isCurrentPlayer;
    PlayerMetadata playerMetadata;

    public  Player() {}

    public Player (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Card> getMyCards() {
        return myCards;
    }
    public void setMyCards(List<Card> myCards) {
        this.myCards = myCards;
    }
    public Boolean getIsCurrentPlayer() {
        return isCurrentPlayer;
    }
    public void setIsCurrentPlayer(Boolean isCurrentPlayer) {
        this.isCurrentPlayer = isCurrentPlayer;
    }
    public PlayerMetadata getPlayerMetadata() {
        return playerMetadata;
    }
    public void setPlayerMetadata(PlayerMetadata playerMetadata) {
        this.playerMetadata = playerMetadata;
    }

    public String toString() {
        return "Player details, id = " + id
                + ". Cards with me = " + myCards
                + ". Current Player = " + isCurrentPlayer
                + ". My metadata = " + playerMetadata;
    }
}
