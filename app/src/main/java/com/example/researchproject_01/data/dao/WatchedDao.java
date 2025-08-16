package com.example.researchproject_01.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.researchproject_01.data.entities.MovieEntity;

import com.example.researchproject_01.data.entities.WatchedEntity;

import java.util.List;

@Dao
public interface WatchedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void markWatched(WatchedEntity watched);

    @Query("SELECT EXISTS(SELECT 1 FROM watched WHERE movieId = :movieId AND userId = :userId)")
    boolean isWatched(long movieId, long userId);

    @Query("SELECT m.* FROM movies m " +
            "INNER JOIN watched w ON m.movieId = w.movieId " +
            "WHERE w.userId = :userId ORDER BY w.watchedAt DESC")
    List<MovieEntity> getWatchedMovies(long userId);
}
