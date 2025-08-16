package com.example.researchproject_01.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "comments")
public class CommentEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public long movieId;
    public long userId;

    @NonNull
    public String text = "";

    public long createdAt;     // epoch millis
    public String sentiment;   // mezunda doldurulacak (nullable)
}
