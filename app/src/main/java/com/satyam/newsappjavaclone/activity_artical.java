package com.satyam.newsappjavaclone;

import androidx.appcompat.app.AppCompatActivity;

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
    TextView articleTitle,articleAuthor,articleDescription;
    Button readMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artical);

        String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        String description = getIntent().getStringExtra("description");
        String url = getIntent().getStringExtra("url");

        articleImage=findViewById(R.id.image);
        articleTitle=findViewById(R.id.title);
        articleAuthor=findViewById(R.id.author);
        articleDescription=findViewById(R.id.desc);
        readMoreButton=findViewById(R.id.read_more_button);

        Glide.with(this).load(image).into(articleImage);
        articleTitle.setText(title);
        articleAuthor.setText(author);
        articleDescription.setText(description);

//        val urlIntent=Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        startActivity(urlIntent)
        readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);

            }
        });

    }
}