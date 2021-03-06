package com.satyam.newsappjavaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class activity_artical extends AppCompatActivity {
    ImageView articleImage;
    TextView articleTitle, articleAuthor, articleDescription;
    Button readMoreButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artical);
        String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        String description = getIntent().getStringExtra("description");
        String url = getIntent().getStringExtra("url");
        setTitle("News Article");

        articleImage = findViewById(R.id.image);
        articleTitle = findViewById(R.id.title);
        articleAuthor = findViewById(R.id.author);
        articleDescription = findViewById(R.id.desc);
        readMoreButton = findViewById(R.id.read_more_button);

        Glide.with(this).load(image).into(articleImage);
        articleTitle.setText(title);
        articleAuthor.setText(author);
        articleDescription.setText(description);

        readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                Intent intent=new Intent(activity_artical.this,WebViewData.class);
                intent.putExtra("view",url);
                startActivity(intent);

            }
        });

    }
}