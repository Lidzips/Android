package com.example.zachet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    String name = "";
    int age;
    String description = "";
    Double payment;
    String address = "";
    TextView nameAgeText;
    TextView descText;
    TextView paymentText;
    TextView information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle args = getIntent().getExtras();
        if (args != null) {
            name = args.getString("name");
            age = args.getInt("age");
            description = args.getString("description");
            payment = args.getDouble("payment");
            address = args.getString("address");
        }
        nameAgeText = findViewById(R.id.employer_name_age);
        descText = findViewById(R.id.job_description);
        paymentText = findViewById(R.id.job_payment_1);
        information = findViewById(R.id.job_info);

        nameAgeText.setText("Заказчик: " + name + " " + age);
        descText.setText(description);
        paymentText.setText("Оплата: " + payment + " руб.");

    }

    public void onClickConfirmJob(View view) {
        information.setVisibility(View.VISIBLE);
        information.setText("Звоните по телефону: +79274044530 или обращайтесь по адресу: " + address);
    }
}