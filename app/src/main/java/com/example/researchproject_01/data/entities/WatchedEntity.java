package com.example.researchproject_01.data.entities;

import androidx.room.Entity;

@Entity(
        tableName = "watched",
        primaryKeys = {"movieId", "userId"} // tekil işaretleme
)
public class WatchedEntity {
    public long movieId;
    public long userId;
    public long watchedAt; // epoch millis
}
