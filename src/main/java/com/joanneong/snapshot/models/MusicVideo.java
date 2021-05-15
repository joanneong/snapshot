package com.joanneong.snapshot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MusicVideo {
    @Id
    String id;

    public MusicVideo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
