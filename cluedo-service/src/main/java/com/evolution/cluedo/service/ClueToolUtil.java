package com.evolution.cluedo.service;

import com.evolution.cluedo.common.entity.*;

/**
 * Created by surya on 08/02/16.
 */
public class ClueToolUtil {

    public static Card getCardByName(String name) {

        Card card = new Card(name);
        if (null != Person.getByName(name)) {
            card.setCardType(CardType.PERSON);
        } else if (null != Weapon.getByName(name)) {
            card.setCardType(CardType.WEAPON);
        } else if (null != Room.getByName(name)) {
            card.setCardType(CardType.ROOM);
        } else {
            return null;
        }
        return card;
    }

}
