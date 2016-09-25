package com.evolution.cluedo.common.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by surya on 06/02/16.
 */
public class PlayerMetadata implements Serializable {
    List<Card> absentCards;
    Map<Integer, List<Card>> atleastOneMap;

    public List<Card> getAbsentCards() {
        return absentCards;
    }
    public void setAbsentCards(List<Card> absentCards) {
        this.absentCards = absentCards;
    }
    public Map<Integer, List<Card>> getAtleastOneMap() {
        return atleastOneMap;
    }
    public void setAtleastOneMap(Map<Integer, List<Card>> atleastOneMap) {
        this.atleastOneMap = atleastOneMap;
    }

    public String toString() {
        return "Cards not with me [ " + absentCards + " ]. " + "Atleast one map: " + atleastOneMap;
    }
}
