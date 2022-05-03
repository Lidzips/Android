package com.example.chapter12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView browser=findViewById(R.id.webBrowser);
        browser.loadUrl("https://metanit.com");
        Button nextBtn = findViewById(R.id.nextButton);

    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}