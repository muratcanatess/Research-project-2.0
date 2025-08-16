package com.example.researchproject_01.data.entities;

import androidx.room.Entity;

@Entity(
        tableName = "ratings",
        primaryKeys = {"movieId", "userId"} // aynı film için aynı kullanıcı bir kez oy versin
)
public class RatingEntity {
    public long movieId;
    public long userId;
    public float rating;   // 0.5..5.0
    public long ratedAt;   // epoch millis
}
