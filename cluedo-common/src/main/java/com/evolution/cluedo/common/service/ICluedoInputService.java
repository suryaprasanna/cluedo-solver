package com.evolution.cluedo.common.service;

import java.util.List;

/**
 * Created by surya on 06/02/16.
 */
public interface ICluedoInputService {

    String setPlayer(Integer playerId, List<String> cards);
    void setSuggestion(String clueDataId, Integer entryId, Integer playerId, Integer personId, Integer weaponId, Integer roomId);
}
