package com.example.tasty;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.runner.AndroidJUnitRunner;

import com.example.tasty.data.db.AppDatabase;
import com.example.tasty.data.db.RecipeDao;
import com.example.tasty.data.db.RecipeEntity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4ClassRunner.class)
public class DbAndroidTest {
    private RecipeDao recipeDao;
    private AppDatabase db;

    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        recipeDao = db.recipeDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void when_adding_data_to_db() {
        List<RecipeEntity> recipeEntityList = recipeDao.getRecipes();
        int size = recipeEntityList.size();

        recipeDao.insert(new RecipeEntity("test", "test", false));

        Assert.assertEquals(size + 1, recipeDao.getRecipes().size());
    }
}
