package com.example.researchproject_01.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies")
public class MovieEntity {
    @PrimaryKey
    public long movieId;

    @NonNull
    public String title = "";

    /** Genres'i virgülle ayırıp string tutuyoruz: "Action|Drama" */
    public String genres;

    /** Örn: 1995 */
    public Integer year;

    /** Opsiyonel: ileride API'den doldururuz */
    public String posterUrl;
}
