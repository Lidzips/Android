package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SideJob> jobs = new ArrayList<SideJob>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView header = findViewById(R.id.main_header);
        RecyclerView list = findViewById(R.id.list);
        if (User.user != null) {
            header.setVisibility(View.INVISIBLE);
            list.setVisibility(View.VISIBLE);
        }
        setInitialData();
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

    private void setInitialData(){
        Person person1 = new Person("Андрей", 28, "ул. Железнодорожная д. 16, подъезд 1, квартира 1");
        Person person2 = new Person("Анастасия", 31, "ул. Железнодорожная д. 16, подъезд 2, квартира 35");
        Person person3 = new Person("Геннадий", 41, "ул. Железнодорожная д. 16, подъезд 3, квартира 67");
        Person person4 = new Person("Ольга", 29, "ул. Железнодорожная д. 16, подъезд 4, квартира 89");
        Person person5 = new Person("Михаил", 36, "ул. Железнодорожная д. 16, подъезд 5, квартира 102");
        jobs.add(new SideJob (person1, "Нужно почистить снег на парковочном месте", 500.00));
        jobs.add(new SideJob (person2, "Ищу того кто может поухаживать за попугаем, пока я буду в отпуске", 1500.00));
        jobs.add(new SideJob (person3, "Нужна помощь в починке машины", 700.00));
        jobs.add(new SideJob (person4, "Помогите прикрутить полку", 600.00));
        jobs.add(new SideJob (person5, "Нужно срочно принести суперклей в подъезд 2 кв 101", 500.00));
    }
}