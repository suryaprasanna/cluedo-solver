package com.evolution.cluedo.service;

import com.evolution.cluedo.common.entity.*;
import com.evolution.cluedo.common.service.ICluedoInputService;
import com.evolution.cluedo.dao.IClueDataRepository;
import com.evolution.cluedo.dao.ISuggestionDataRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by surya on 06/02/16.
 */
@Service("cluedoInputService")
public class CluedoInputService implements ICluedoInputService {
    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    IClueDataRepository clueDataRepository;

    @Autowired
    ISuggestionDataRepository suggestionDataRepository;

    @Override
    public String setPlayer(Integer playerId, List<String> cards) {

        ClueData clueData = new ClueData();
        clueData.setPlayerId(playerId);
        List<Player> playerList = new ArrayList<>();
        for(int i = 1; i <= 6; i++) {
            Player player = new Player(i);
            if (i != playerId) {
                player.setIsCurrentPlayer(false);
            } else {
                player.setIsCurrentPlayer(true);
                List<Card> cardList = new ArrayList<>();
                cards.forEach(cardName -> cardList.add(ClueToolUtil.getCardByName(cardName)));
            }
            playerList.add(player);
        }
        clueData.setPlayers(playerList);

        try {
            clueDataRepository.save(clueData);
        } catch(Exception e) {
            logger.error("Exception in setting the playerId " + playerId, e);
            return null;
        }
        return clueData.getId();
    }

    @Override
    public void setSuggestion(String clueDataId, Integer entryId, Integer playerId, Integer personId, Integer weaponId, Integer roomId) {

        //logged into mysql
        SuggestData suggestData = new SuggestData();
        suggestData.setExtractedDataId(clueDataId);
        suggestData.setEntryId(entryId);
        suggestData.setPerson(Person.getById(personId).toString());
        suggestData.setWeapon(Weapon.getById(weaponId).toString());
        suggestData.setRoom(Room.getById(roomId).toString());
        suggestionDataRepository.save(suggestData);

    }

    public void disproveSuggestion(String clueDataId, Integer entryId, Integer playerId, Integer suggestedPlayerId,
                                   Integer cardShownPlayerId, String shownCardName, List<Card> suggestedCards) {

        //entering suggestions details in clueData mongo
        ClueData clueData = clueDataRepository.findOne(clueDataId);

        List<Integer> inBetweenPlayerIds = new ArrayList<>();
        //get inbetween players id
        try {
             inBetweenPlayerIds = clueData.getPlayers().stream()
                     .filter(player1 ->
                             (suggestedPlayerId < cardShownPlayerId)
                                     ? (player1.getId() > suggestedPlayerId && player1.getId() < cardShownPlayerId)
                                     : (player1.getId() > suggestedPlayerId || player1.getId() < cardShownPlayerId))
                     .map(Player::getId).collect(Collectors.toList());
        } catch (Exception e) {
            logger.info("For clueDataId " + clueDataId + " and entryId " + entryId + ". No in between players present");
        }
        final List<Integer> finalInBetweenPlayerIds = inBetweenPlayerIds;

        List<Player> players = clueData.getPlayers();

        if (playerId.equals(suggestedPlayerId)) {

            //entered the shown card details
            Card shownCard = ClueToolUtil.getCardByName(shownCardName);
            Player cardShownPlayer = players.get(cardShownPlayerId);
            List<Card> cardList = cardShownPlayer.getMyCards();
            if (null == cardList) {
                cardList = new ArrayList<>();
            }
            cardList.add(shownCard);

            //update shown card as absent to other players
            players.stream()
                    .filter(player ->
                            !player.getId().equals(suggestedPlayerId)
                                    && !player.getId().equals(cardShownPlayerId)
                                    && (finalInBetweenPlayerIds.size() > 0 && !finalInBetweenPlayerIds.contains(player.getId())))
                    .forEach(player1 -> {
                        List<Card> absentCards = player1.getPlayerMetadata().getAbsentCards();
                        absentCards.add(shownCard);
                    });
        }

        //set ineligibility for in between players
        finalInBetweenPlayerIds.stream().filter(id -> !finalInBetweenPlayerIds.contains(playerId))
                .forEach(id -> {
                    List<Card> absentCardList = players.get(id).getPlayerMetadata().getAbsentCards();
                    if (null == absentCardList) {
                        absentCardList = new ArrayList<>();
                    }
                    absentCardList.addAll(suggestedCards);
        });
    }


}
