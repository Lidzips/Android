package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    EditText editName;
    EditText editAge;
    EditText editAddress;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editName = findViewById(R.id.name_field);
        editAge = findViewById(R.id.age_field);
        editAddress = findViewById(R.id.address_field);
        header = findViewById(R.id.settingsHeader);

        sqlHelper = new DatabaseHelper(this);
        db = sqlHelper.getWritableDatabase();
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_PERSON, null);
        if (userCursor.moveToPosition(10)) {
            editName.setText(userCursor.getString(1));
            editAge.setText(String.valueOf(userCursor.getInt(2)));
            editAddress.setText(userCursor.getString(3));
        }
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
        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        String address = editAddress.getText().toString();
        if (!name.equals("") && !age.equals("") && !address.equals("")) {
            User.user = new Person( name, Integer.parseInt(age) , address);

            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.COLUMN_NAME, name);
            cv.put(DatabaseHelper.COLUMN_AGE, Integer.parseInt(age));
            cv.put(DatabaseHelper.COLUMN_ADDRESS, address);

            if (userCursor.moveToPosition(10)) {
                db.update(DatabaseHelper.TABLE_PERSON, cv, DatabaseHelper.COLUMN_ID + "=" + 11, null);
            } else {
                db.insert(DatabaseHelper.TABLE_PERSON, null, cv);
            }

            Toast.makeText(getApplicationContext(), "Данные успешно сохранены",
                    Toast.LENGTH_SHORT).show();
        } else {
            header.setText("Заполните все поля");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}