package com.evolution.cluedo.common.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by surya on 06/02/16.
 */
@Document(collection = "extractedData")
public class ClueData implements Serializable {

    @Id
    private String id;
    private Integer playerId;
    private List<Player> players;
    private Person person;
    private Weapon weapon;
    private Room room;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public String toString() {
        return "Process Data: [ id = " + id + " playerId = " + playerId
                + ". List of players = " + players + "]";
    }

}
