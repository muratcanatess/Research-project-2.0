package com.example.researchproject_01.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.researchproject_01.data.entities.CommentEntity;

import java.util.List;

@Dao
public interface CommentDao {

    @Insert
    long add(CommentEntity comment);

    @Query("SELECT * FROM comments WHERE movieId = :movieId ORDER BY createdAt DESC")
    List<CommentEntity> forMovie(long movieId);

    @Query("DELETE FROM comments WHERE id = :id")
    void delete(long id);
}
