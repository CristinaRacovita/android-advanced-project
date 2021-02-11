package com.example.tasty.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RecipeEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase instance(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "tasty.db").build();
    }

    public abstract RecipeDao recipeDao();
}
