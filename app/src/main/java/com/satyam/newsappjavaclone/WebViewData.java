package com.satyam.newsappjavaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewData extends AppCompatActivity {
private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_wiew);
        setTitle("News Detail");
        mywebView = findViewById(R.id.webview);
        WebSettings webSettings= mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String Url= String.valueOf(getIntent().getSerializableExtra("view"));
        mywebView.loadUrl(Url);
    }
}