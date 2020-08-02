package com.example.covid19application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toolbar;

public class Fragment extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl("https://www.google.com");
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}