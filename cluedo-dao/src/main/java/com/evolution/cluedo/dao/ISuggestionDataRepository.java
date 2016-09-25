package com.evolution.cluedo.dao;

import com.evolution.cluedo.common.entity.SuggestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by surya on 06/02/16.
 */
@Repository("suggestionDataRepository")
public interface ISuggestionDataRepository extends JpaRepository<SuggestData,Integer> {
    List<SuggestData> findByExtractedDataId(String extractedDataId);
    SuggestData findByExtractedDataIdAndEntryId(String extractedDataId, Integer entryId);

}
