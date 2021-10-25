package com.satyam.newsappjavaclone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    @GET("v2/top-headlines")
    Call<News> fetchHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);

}
