package com.example.multiplactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClickConfirm(View view) {
        EditText ageBox = findViewById(R.id.age);
        if (!ageBox.getText().toString().equals("")) {
            String age = ageBox.getText().toString();

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("age", age);

            startActivity(intent);
        } else {
            //вывести сообщение о необходимости ввести данные
        }

    }
}