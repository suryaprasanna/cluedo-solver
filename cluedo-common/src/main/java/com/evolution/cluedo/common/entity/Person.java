package com.evolution.cluedo.common.entity;

/**
 * Created by surya on 06/02/16.
 */
public enum Person {
    MISS_SCARLETT,
    COLONEL_MUSTARD,
    MRS_WHITE,
    REVEREND_GREEN,
    MRS_PEACOCK,
    PROFESSOR_PLUM;

//    MISS_SCARLETT(1),
//    COLONEL_MUSTARD(2),
//    MRS_WHITE(3),
//    REVEREND_GREEN(4),
//    MRS_PEACOCK(5),
//    PROFESSOR_PLUM(6);
//
//    private Integer id;
//
//    Person(Integer id){
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public static Person getById(Integer id) {
        if (1 == id ) {
            return MISS_SCARLETT;
        } else if (2 == id) {
            return COLONEL_MUSTARD;
        } else if (3 == id) {
            return MRS_WHITE;
        } else if (4 == id) {
            return REVEREND_GREEN;
        } else if (5 == id) {
            return MRS_PEACOCK;
        } else if (6 == id) {
            return PROFESSOR_PLUM;
        } else {
            return null;
        }
    }

    public static Person getByName(String name) {
        if (name.equalsIgnoreCase("missScarlett")) {
            return MISS_SCARLETT;
        } else if (name.equalsIgnoreCase("colonelMustard")) {
            return COLONEL_MUSTARD;
        } else if (name.equalsIgnoreCase("mrsWhite")) {
            return MRS_WHITE;
        } else if (name.equalsIgnoreCase("reverendGreen")) {
            return REVEREND_GREEN;
        } else if (name.equalsIgnoreCase("mrsPeacock")) {
            return MRS_PEACOCK;
        } else if (name.equalsIgnoreCase("professorPlum")) {
            return PROFESSOR_PLUM;
        } else {
            return null;
        }
    }


}
