package com.example.multiplactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle args = getIntent().getExtras();
        if (args != null) {
            age = args.getString("age");
        }

    }

    public void onClickConfirmName(View view) {
        EditText nameBox = findViewById(R.id.name);
        if (!nameBox.getText().toString().equals("")) {
            String name = nameBox.getText().toString();

            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra("age", age);
            intent.putExtra("name", name);

            startActivity(intent);
        } else {
            //вывести сообщение о необходимости ввести данные
        }
    }
}