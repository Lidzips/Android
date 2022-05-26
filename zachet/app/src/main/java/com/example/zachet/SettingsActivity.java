package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.menu_main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.settings:
                return true;
            case R.id.info_page:
                Intent intent1 = new Intent(this, InfoActivity.class);
                startActivity(intent1);
                return true;
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    public void onClickConfirm(View view) {
        EditText editName = findViewById(R.id.name_field);
        EditText editAge = findViewById(R.id.age_field);
        EditText editAddress = findViewById(R.id.address_field);
        TextView header = findViewById(R.id.settingsHeader);
        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        String address = editAddress.getText().toString();
        if (!name.equals("") && !age.equals("") && !address.equals("")) {
            User.user = new Person(name, Integer.parseInt(age) , address);
            Toast.makeText(getApplicationContext(), "Данные успешно сохранены",
                    Toast.LENGTH_SHORT).show();
        } else {
            header.setText("Заполните все поля");
        }

    }
}