package com.example.tasty.data.remote;

import com.example.tasty.data.RecipeItemDTO;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RecipeAPI {
    String BASE_URL = "https://tasty-69676-default-rtdb.firebaseio.com/";

    @GET("recipes.json")
    Call<List<RecipeItemDTO>> getRecipes();

    @FormUrlEncoded
    @PUT("recipes.json")
    Call<RecipeItemDTO> updateRecipe(@Field("favourite") Boolean fav, @Field("recipe_id") String id);

    static RecipeAPI createAPI() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RecipeAPI.class);
    }
}
