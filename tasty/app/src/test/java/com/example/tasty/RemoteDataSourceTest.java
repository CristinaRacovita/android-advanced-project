package com.example.tasty;

import com.example.tasty.data.remote.RecipeAPI;
import com.example.tasty.data.remote.RemoteDataSource;

import org.junit.Test;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

public class RemoteDataSourceTest {
    @Test
    public void when_getRecipes_failed() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        RecipeAPI recipeAPI = new Retrofit.Builder()
                .baseUrl("https://www.google.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RecipeAPI.class);

        RemoteDataSource remoteDataSource = new RemoteDataSource(recipeAPI);
        assertEquals(0, remoteDataSource.getRecipeItems().size());
    }

    @Test
    public void when_getRecipes_succeed(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        RecipeAPI recipeAPI = new Retrofit.Builder()
                .baseUrl("https://tasty-69676-default-rtdb.firebaseio.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RecipeAPI.class);

        RemoteDataSource remoteDataSource = new RemoteDataSource(recipeAPI);
        assertEquals(4, remoteDataSource.getRecipeItems().size());
    }
}
