package com.example.researchproject_01.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.researchproject_01.data.entities.RatingEntity;

import java.util.List;

@Dao
public interface RatingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(RatingEntity rating);

    @Query("SELECT AVG(rating) FROM ratings WHERE movieId = :movieId")
    Float getAverageForMovie(long movieId);

    @Query("SELECT * FROM ratings WHERE userId = :userId ORDER BY ratedAt DESC")
    List<RatingEntity> getUserRatings(long userId);

    @Query("DELETE FROM ratings WHERE movieId = :movieId AND userId = :userId")
    void deleteUserRating(long movieId, long userId);
}
