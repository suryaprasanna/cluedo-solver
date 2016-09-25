package com.evolution.cluedo.common.entity;

/**
 * Created by surya on 06/02/16.
 */
public enum Weapon {
    CANDLESTICK,
    DAGGER,
    LEAD_PIPE,
    REVOLVER,
    ROPE,
    SPANNER;

    public static Weapon getById(Integer id) {
        if (1 == id ) {
            return CANDLESTICK;
        } else if (2 == id) {
            return DAGGER;
        } else if (3 == id) {
            return LEAD_PIPE;
        } else if (4 == id) {
            return REVOLVER;
        } else if (5 == id) {
            return ROPE;
        } else if (6 == id) {
            return SPANNER;
        } else {
            return null;
        }
    }

    public static Weapon getByName(String name) {
        if (name.equalsIgnoreCase("candleStick")) {
            return CANDLESTICK;
        } else if (name.equalsIgnoreCase("dagger")) {
            return DAGGER;
        } else if (name.equalsIgnoreCase("leadPipe")) {
            return LEAD_PIPE;
        } else if (name.equalsIgnoreCase("revolver")) {
            return REVOLVER;
        } else if (name.equalsIgnoreCase("rope")) {
            return ROPE;
        } else if (name.equalsIgnoreCase("spanner")) {
            return SPANNER;
        } else {
            return null;
        }
    }
}
