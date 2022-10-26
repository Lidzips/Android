package com.example.frasys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Film Rating System");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.spravka, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.spravka:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void next(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, Page.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}