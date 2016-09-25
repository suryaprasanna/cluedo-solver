package com.evolution.cluedo.common.entity;

/**
 * Created by surya on 06/02/16.
 */
public enum Room {
    KITCHEN,
    DINNING_ROOM,
    LOUNGE,
    HALL,
    STUDY,
    LIBRARY,
    BILLIARD_ROOM,
    CONSERVATORY,
    BALLROOM;

    public static Room getById(Integer id) {
        if (1 == id) {
            return KITCHEN;
        } else if (2 == id) {
            return DINNING_ROOM;
        } else if (3 == id) {
            return LOUNGE;
        } else if (4 == id) {
            return HALL;
        } else if (5 == id) {
            return STUDY;
        } else if (6 == id) {
            return LIBRARY;
        } else if (7 == id) {
            return BILLIARD_ROOM;
        } else if (8 == id) {
            return CONSERVATORY;
        } else if (9 == id) {
            return BALLROOM;
        } else {
            return null;
        }
    }

    public static Room getByName(String name) {
        if (name.equalsIgnoreCase("kitchen")) {
            return KITCHEN;
        } else if (name.equalsIgnoreCase("dinningRoom")) {
            return DINNING_ROOM;
        } else if (name.equalsIgnoreCase("lounge")) {
            return LOUNGE;
        } else if (name.equalsIgnoreCase("hall")) {
            return HALL;
        } else if (name.equalsIgnoreCase("study")) {
            return STUDY;
        } else if (name.equalsIgnoreCase("library")) {
            return LIBRARY;
        } else if (name.equalsIgnoreCase("billiardRoom")) {
            return BILLIARD_ROOM;
        } else if (name.equalsIgnoreCase("conservatory")) {
            return CONSERVATORY;
        } else if (name.equalsIgnoreCase("ballRoom")) {
            return BALLROOM;
        } else {
            return null;
        }
    }
}
