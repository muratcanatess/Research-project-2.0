package com.example.researchproject_01.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.researchproject_01.data.entities.MovieEntity;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MovieEntity> movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieEntity movie);

    @Query("SELECT * FROM movies ORDER BY title")
    List<MovieEntity> getAll();

    @Query("SELECT * FROM movies WHERE movieId = :id LIMIT 1")
    MovieEntity getById(long id);

    @Query("SELECT * FROM movies WHERE title LIKE '%' || :q || '%' ORDER BY title LIMIT :limit OFFSET :offset")
    List<MovieEntity> searchByTitle(String q, int limit, int offset);
}
