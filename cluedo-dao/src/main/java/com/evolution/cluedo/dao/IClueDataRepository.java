package com.evolution.cluedo.dao;

import com.evolution.cluedo.common.entity.ClueData;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by surya on 06/02/16.
 */
public interface IClueDataRepository extends CrudRepository<ClueData, String>{
    ClueData findByPlayerId(Integer playerId);
    ClueData findOne(String id);
}
