package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SideJob> jobs = new ArrayList<SideJob>();
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor jobCursor;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    TextView header;
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = findViewById(R.id.main_header);
        list = findViewById(R.id.list);

        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(getApplicationContext());
        }
    }

    @SuppressLint("Range")
    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.getReadableDatabase();

        if (User.user == null) {
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE_PERSON, null);
            if (userCursor.moveToPosition(10)) {
                User.user = new Person(userCursor.getString(1), userCursor.getInt(2), userCursor.getString(3));
                header.setVisibility(View.INVISIBLE);
                list.setVisibility(View.VISIBLE);
            }
            userCursor.close();
        } else {
            header.setVisibility(View.INVISIBLE);
            list.setVisibility(View.VISIBLE);
        }

        //получаем данные из бд в виде курсора
        if (User.user != null) {
            jobs.clear();
            String userAddress = User.user.getAddress();
            userAddress = "%" + userAddress + "%";
            try {
                jobCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLE_JOB + " inner join " + DatabaseHelper.TABLE_PERSON + " on " + DatabaseHelper.TABLE_JOB + "." + DatabaseHelper.COLUMN_PERSON_ID + " = " + DatabaseHelper.TABLE_PERSON + "." + DatabaseHelper.COLUMN_ID + " where " + DatabaseHelper.TABLE_PERSON + "." + DatabaseHelper.COLUMN_ADDRESS + " like ?", new String[]{"%" + userAddress + "%"});
                userCursor = db.rawQuery("select * from "+ DatabaseHelper.TABLE_PERSON, null);

                String descr;
                Double payment;
                int userId;
                String name;
                int age;
                String address;
                while (jobCursor.moveToNext()) {
                    descr = jobCursor.getString(jobCursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION));
                    payment = jobCursor.getDouble(jobCursor.getColumnIndex(DatabaseHelper.COLUMN_PAYMENT));
                    userId = jobCursor.getInt(jobCursor.getColumnIndex(DatabaseHelper.COLUMN_PERSON_ID));
                    int pos = userId - 1;
                    userCursor.moveToPosition(pos);
                    name = userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
                    age = userCursor.getInt(userCursor.getColumnIndex(DatabaseHelper.COLUMN_AGE));
                    address = userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_ADDRESS));
                    Person person = new Person(name, age, address);
                    SideJob job = new SideJob(person, descr, payment);
                    jobs.add(job);
                }

                if (jobCursor.getCount() == 0) {
                    System.out.println("123143");
                    header.setVisibility(View.VISIBLE);
                    list.setVisibility(View.INVISIBLE);
                    header.setText("По вашему адресу ничего не найдено");
                }

                jobCursor.close();
                userCursor.close();
            } catch (SQLException ex) {

            }



        }


        SideJobAdapter.OnJobClickListener jobClickListener = new SideJobAdapter.OnJobClickListener() {
            @Override
            public void onJobClick(SideJob job, int position) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", job.getEmployer().getName());
                intent.putExtra("age", job.getEmployer().getAge());
                intent.putExtra("description", job.getDescription());
                intent.putExtra("payment", job.getJobPayment());
                intent.putExtra("address", job.getEmployer().getAddress());

                startActivity(intent);
            }
        };

        SideJobAdapter adapter = new SideJobAdapter(this, jobs, jobClickListener);
        list.setAdapter(adapter);
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
                return true;
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.info_page:
                Intent intent1 = new Intent(this, InfoActivity.class);
                startActivity(intent1);
                return true;
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        jobCursor.close();
    }
}