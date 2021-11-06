package com.satyam.newsappjavaclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class USNews extends AppCompatActivity {
RecyclerView recyclerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usnews);
        recyclerView2=findViewById(R.id.recyclerview2);
        getnews();

    }

    private void getnews() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsInterface newsInstance = retrofit.create(NewsInterface.class);
        Call<News> news=newsInstance.fetchHeadlines("us",Constants.API_KEY);
        news.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News newsResponse=response.body();
                recyclerView2.setAdapter(new NewsAdapter(newsResponse.articles, USNews.this));
                recyclerView2.setLayoutManager(new LinearLayoutManager(USNews.this));


            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(USNews.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}