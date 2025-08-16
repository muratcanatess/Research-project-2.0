package com.example.researchproject_01.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.researchproject_01.data.dao.CommentDao;
import com.example.researchproject_01.data.dao.MovieDao;
import com.example.researchproject_01.data.dao.RatingDao;
import com.example.researchproject_01.data.dao.WatchedDao;
import com.example.researchproject_01.data.entities.CommentEntity;
import com.example.researchproject_01.data.entities.MovieEntity;
import com.example.researchproject_01.data.entities.RatingEntity;
import com.example.researchproject_01.data.entities.WatchedEntity;

@Database(
        entities = {
                MovieEntity.class,
                RatingEntity.class,
                CommentEntity.class,
                WatchedEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
    public abstract RatingDao ratingDao();
    public abstract CommentDao commentDao();
    public abstract WatchedDao watchedDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "movies.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
