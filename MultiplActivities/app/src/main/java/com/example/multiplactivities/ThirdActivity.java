package com.example.multiplactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    String age;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle args = getIntent().getExtras();
        TextView textName = findViewById(R.id.third_text);
        TextView textAge = findViewById(R.id.third_text2);
        if (args != null) {
            age = args.getString("age");
            name = args.getString("name");
            textName.setText("Your name is " + name);
            textAge.setText("And you " + age + " year(s) old");
        } else {
            textName.setText("Error");
        }
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}