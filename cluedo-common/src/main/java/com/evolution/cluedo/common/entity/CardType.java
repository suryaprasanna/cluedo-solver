package com.evolution.cluedo.common.entity;

/**
 * Created by surya on 07/02/16.
 */
public enum CardType {
    PERSON(1),
    WEAPON(2),
    ROOM(3);

    private int typeId;
    CardType(int typeId) {
        this.typeId = typeId;
    }



    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
