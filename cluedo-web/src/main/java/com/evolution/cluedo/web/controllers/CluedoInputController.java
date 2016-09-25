package com.evolution.cluedo.web.controllers;

import com.evolution.cluedo.common.service.ICluedoInputService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by surya on 06/02/16.
 */
@Controller
@RequestMapping("/input/*")
public class CluedoInputController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    ICluedoInputService cluedoInputService;

    @RequestMapping(value = "set/player/{playerId}", method = RequestMethod.POST)
    @ResponseBody
    public String setPlayerId(@PathVariable Integer playerId, List<String> cards) {
        logger.info("PlayerId: " + playerId);
        return cluedoInputService.setPlayer(playerId, cards);
    }

    @RequestMapping(value = "set/suggestion/{clueDataId}/{entryId}/{playerId}/{personId}/{weaponId}/{roomId}", method = RequestMethod.POST)
    @ResponseBody
    public void setSuggestion(@PathVariable String clueDataId, @PathVariable Integer entryId,
                              @PathVariable Integer playerId, @PathVariable Integer personId,
                              @PathVariable Integer weaponId, @PathVariable Integer roomId) {
        logger.info("PlayerId: " + playerId + ". Person: " + personId + ". Weapon: "
                + weaponId + ". Room: " + roomId);
        cluedoInputService.setSuggestion(clueDataId, entryId, playerId, personId, weaponId, roomId);
    }

    @RequestMapping(value = "disprove/suggestion/{playerId}/{cardType}/cardId", method = RequestMethod.POST)
    @ResponseBody
    public void disproveSuggestion(@PathVariable String clueDataId, @PathVariable Integer entryId,
                                   @PathVariable Integer playerId, @PathVariable Integer cardShownPlayerId,
                                   @PathVariable Integer cardType, @PathVariable Integer cardId) {
        logger.info("PlayerId: " + playerId + ". CardType: " + cardType + ". CardId: " + cardId);
    }

}
