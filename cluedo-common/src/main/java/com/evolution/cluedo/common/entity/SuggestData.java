package com.evolution.cluedo.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by surya on 06/02/16.
 */
@Entity
@Table(name = "suggest_data")
public class SuggestData implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "extracted_data_id")
    private String extractedDataId;

    @Column(name = "entry_id")
    private Integer entryId;

    private String person;
    private String weapon;
    private String room;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "updated_on")
    private Timestamp updatedOn;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getExtractedDataId() {
        return extractedDataId;
    }
    public void setExtractedDataId(String extractedDataId) {
        this.extractedDataId = extractedDataId;
    }
    public Integer getEntryId() {
        return entryId;
    }
    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public Timestamp getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String toString() {
        return "Suggest Data: [ id = " + id + " extractedDataId = " + extractedDataId
                + ", entryId = " + entryId + ", person = " + person
                + ", weapon = " + weapon + ", room = " + room + "].";
    }
}
